package com.m07.javafx2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultaController implements Initializable {

    @FXML
    public Text nombreFiscalTexto;
    @FXML
    public Text nombreTexto;
    @FXML
    public Text direccionTexto;
    @FXML
    public Text provinciaTexto;
    @FXML
    public Text ciudadTexto;



    //apreta al boton, cierra
    @FXML
    protected void closeWindow(){
       HelloController.stage.close();
    }

    //cuando se carga la vista, se hace esto
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void traspasarInformacion(String nombreFiscal, String nombre, String direccion, String provincia, String ciudad){//recibes datos del otro
        sets(nombreFiscal, nombreFiscalTexto);
        sets(nombre, nombreTexto);
        sets(direccion, direccionTexto);
        sets(provincia, provinciaTexto);
        sets(ciudad, ciudadTexto);
    }

    private boolean sets(String texto, Text text){
        if(texto!=null){
            if(!texto.equalsIgnoreCase("")){
                text.setText(texto);
                return true;
            }
        }
        text.setText("no hay nada que ver");
        return false;
    }
}
