package org.dew.javafx;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javafx.stage.Screen;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public 
class BlankJavaFX extends Application 
{
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Blank JavaFX");

    Label label = new Label("Hello!");

    VBox root = new VBox(10);
    root.setPadding(new Insets(20));
    root.getChildren().addAll(label);

    double width  = Screen.getPrimary().getVisualBounds().getWidth();
    double height = Screen.getPrimary().getVisualBounds().getHeight();

    primaryStage.setWidth(width / 4);
    primaryStage.setHeight(height / 4);
    primaryStage.setX(50);
    primaryStage.setY(50);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
