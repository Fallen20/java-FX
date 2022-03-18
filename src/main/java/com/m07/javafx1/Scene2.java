package com.m07.javafx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2 {
    public static Stage stage = new Stage();

    @FXML
    public void changeToScene1(ActionEvent actionEvent) {
        //en una nueva ventana
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            //Parent root= (Parent) fxmlLoader.load();//mal, no se hace con fxml pero con code. Esto no sirve
            stage.setTitle("Ventana Sales");
            stage.setWidth(701);
            stage.setHeight(600);


            stage.setScene(HelloApplication.scene);
            stage.show();

            stage.close();


    }



}
