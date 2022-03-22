package com.m07.javafx2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TextField NombreFiscalInput;
    @FXML
    public TextField NombreInput;
    @FXML
    public TextField DireccionInput;
    @FXML
    public TextField ProvinciaInput;
    @FXML
    public TextField CiudadInput;
    @FXML
    public Button botonEditar;

    @FXML
    public Text fiscalBinding;
    @FXML
    public Text nombreBinding;
    @FXML
    public Text direccionBinding;
    @FXML
    public Text ciudadBinding;
    @FXML
    public Text provinciaBinding;

    public static  Stage stage=new Stage();


    @FXML
    protected void erase() {
        NombreFiscalInput.setText("");
        NombreInput.setText("");
        DireccionInput.setText("");
        ProvinciaInput.setText("");
        CiudadInput.setText("");
    }

    @FXML
    protected void editable() {
        //le cambias el color para que puedas escribir



        if(NombreFiscalInput.isEditable()){
            botonEditar.setText("Editar");
            //no puedes escribir
            NombreFiscalInput.setEditable(false);
            NombreInput.setEditable(false);
            DireccionInput.setEditable(false);
            ProvinciaInput.setEditable(false);
            CiudadInput.setEditable(false);
        }
        else{
            botonEditar.setText("Block");
            //puedes escribir
            NombreFiscalInput.setEditable(true);
            NombreInput.setEditable(true);
            DireccionInput.setEditable(true);
            ProvinciaInput.setEditable(true);
            CiudadInput.setEditable(true);


        }
    }


    @FXML
    protected void consultar() {
        //abre una ventana y dile que campos están llenos
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ventanaConsulta.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),400,300);

            ConsultaController consultaController=fxmlLoader.getController();
            consultaController.traspasarInformacion(NombreFiscalInput.getText(),
                                            NombreInput.getText(),
                                            DireccionInput.getText(),
                                            ProvinciaInput.getText(),
                                            CiudadInput.getText());



            stage.setTitle("Consulta window");
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//al iniciarse haz esto
        fiscalBinding.textProperty().bind(NombreFiscalInput.textProperty());
        nombreBinding.textProperty().bind(NombreInput.textProperty());
        direccionBinding.textProperty().bind(DireccionInput.textProperty());
        provinciaBinding.textProperty().bind(ProvinciaInput.textProperty());
        ciudadBinding.textProperty().bind(CiudadInput.textProperty());
    }
}