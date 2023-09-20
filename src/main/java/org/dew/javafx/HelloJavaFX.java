package org.dew.javafx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

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

        Button button = new Button("Greeting");

        Label label = new Label();

        button.setOnAction(event -> {
            String name     = textField.getText();
            String greeting = comboBox.getValue();

            if(greeting == null || greeting.length() == 0) greeting = "Hello";
            
            if (!name.isEmpty()) {
              label.setStyle("-fx-text-fill: #000080; -fx-font-weight: bold; -fx-font-size: 14px;");
              label.setText(greeting + " " + name + "!");
            } 
            else {
              label.setStyle("-fx-text-fill: #800000; -fx-font-weight: bold; -fx-font-size: 14px;");
              label.setText("Missing name.");
            }
        });

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(comboBox, textField);

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(hbox, button, label);
        vbox.setStyle("-fx-padding: 20px; -fx-background-color: #c9e8ff;");

        Scene scene = new Scene(vbox, 300, 150);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
