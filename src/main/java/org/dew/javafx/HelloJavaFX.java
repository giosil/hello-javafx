package org.dew.javafx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Screen;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public 
class HelloJavaFX extends Application 
{
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Hello JavaFX");

    ComboBox<String> comboBox = new ComboBox<String>();
    comboBox.getItems().addAll("Hello", "Ciao", "Salut");
    comboBox.setValue("Hello");

    TextField textField = new TextField();
    textField.setPromptText("Insert name");
    textField.focusedProperty().addListener((obs, oldVal, newVal) -> { 
      System.out.println(newVal ? "Focused" : "Unfocused");
    });

    Button button = new Button("Greeting");

    Label label = new Label();

    button.setOnAction(event -> {
      String name     = textField.getText();
      String greeting = comboBox.getValue();

      if(greeting == null || greeting.length() == 0) greeting = "Hello";

      if (!name.isEmpty()) {
        // label.setStyle("-fx-text-fill: #000080; -fx-font-weight: bold; -fx-font-size: 14pt;");
        label.getStyleClass().clear();
        label.getStyleClass().add("msg-info"); // Defined in HelloJavaFX.css
        label.setText(greeting + " " + name + "!");
      } 
      else {
        // label.setStyle("-fx-text-fill: #800000; -fx-font-weight: bold; -fx-font-size: 14pt;");
        label.getStyleClass().clear();
        label.getStyleClass().add("msg-error"); // Defined in HelloJavaFX.css
        label.setText("Missing name.");
      }
    });

    HBox hbox = new HBox(10);
    hbox.getChildren().addAll(comboBox, textField);

    VBox root = new VBox(10);
    root.getChildren().addAll(hbox, button, label);
    root.setStyle("-fx-padding: 20px; -fx-background-color: #c9e8ff;");
    root.getStylesheets().add(HelloJavaFX.class.getResource("main.css").toExternalForm());

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

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
