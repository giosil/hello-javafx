package org.dew.javafx;

import javafx.application.Platform;
import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

import javafx.scene.layout.VBox;

import javafx.scene.Parent;
import javafx.stage.Screen;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public 
class HelloFXML extends Application 
{
  @FXML
  protected ComboBox<String> cboGreeting;
  @FXML
  protected Label lblOutput;
  @FXML
  protected TextField txtName;
  @FXML
  protected Button btnGreeting;
  
  protected Scene scene;
  
  public static void main(String[] args) {
    Application.launch(args);
  }

  @FXML
  public void initialize() {
    System.out.println("initialize");
  }

  @FXML
  protected void onGreeting(ActionEvent event) {
    String name     = txtName.getText();
    String greeting = cboGreeting.getValue();

    if(greeting == null || greeting.length() == 0) greeting = "Hello";

    if (!name.isEmpty()) {
      // label.setStyle("-fx-text-fill: #000080; -fx-font-weight: bold; -fx-font-size: 14pt;");
      lblOutput.getStyleClass().clear();
      lblOutput.getStyleClass().add("msg-info"); // Defined in HelloJavaFX.css
      lblOutput.setText(greeting + " " + name + "!");
    } 
    else {
      // label.setStyle("-fx-text-fill: #800000; -fx-font-weight: bold; -fx-font-size: 14pt;");
      lblOutput.getStyleClass().clear();
      lblOutput.getStyleClass().add("msg-error"); // Defined in HelloJavaFX.css
      lblOutput.setText("Missing name.");
    }
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Hello FXML");

    double width  = Screen.getPrimary().getVisualBounds().getWidth();
    double height = Screen.getPrimary().getVisualBounds().getHeight();

    primaryStage.setWidth(width / 4);
    primaryStage.setHeight(height / 4);
    primaryStage.setX(50);
    primaryStage.setY(50);
    primaryStage.setResizable(true);
    primaryStage.setAlwaysOnTop(false);
    primaryStage.setIconified(false);
    primaryStage.setFullScreen(false);
    primaryStage.setOpacity(1);

    scene = new Scene(new VBox());

    primaryStage.setScene(scene);

    primaryStage.show();

    Platform.runLater(() -> {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(HelloFXML.class.getResource("HelloFXML.fxml"));

      Parent root = null;
      try {
        root = loader.load();
        scene.setRoot(root);
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
    });
  }
}
