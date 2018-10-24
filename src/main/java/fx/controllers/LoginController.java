/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import config.ConfiguracionYaml;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;
import servicios.UsuariosServicios;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class LoginController implements Initializable {

    private PantallaInicioController inicio;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    @FXML
    private TextField fxUsuario;

    @FXML
    private PasswordField fxPass;

    @FXML
    public void clickLogin() {

        UsuariosServicios us = new UsuariosServicios();
        if (us.comprobarUsuario(fxUsuario.getText(),fxPass.getText())) {
            inicio.cargarPantallaGet();
        } else {
            fxUsuario.clear();
            fxPass.clear();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Usuario y/o contraseña incorrectos");

            alert.showAndWait();

        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
