package com.m07.javafx1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button buttonProjected;

    public static Stage stage = new Stage();
    @FXML
    public static void changeToScene2(ActionEvent cambio) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2.fxml"));
            Parent root = (Parent) fxmlLoader.load();


            stage.setTitle("Ventana Proyection");

            stage.setWidth(635);
            stage.setHeight(450);


            stage.setScene(new Scene(root));
            stage.show();

            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    /*public void changePrimary() {
        try {
            HelloApplication.setRoot("primary");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public  void changeSecondary() {
        try {
            HelloApplication.setRoot("secondary");

        } catch (IOException e) {e.printStackTrace();}


    }*/
}