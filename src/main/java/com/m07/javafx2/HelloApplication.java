package com.m07.javafx2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("escena1.fxml"));
        scene = new Scene(fxmlLoader.load(), 700, 600);

        scene.getStylesheets().add(getClass().getResource("CSS/estiloScene1.css").toExternalForm());

        stage.setTitle("Form window");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}