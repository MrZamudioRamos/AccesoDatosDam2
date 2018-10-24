/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import fx.controllers.cliente.*;
import fx.controllers.resenias.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaInicioController implements Initializable {

    @FXML
    private BorderPane fxRoot;

    @FXML
    private MenuBar fxMenu;

    private AnchorPane pantallaLogin;
    private LoginController controllerLogin;

    private AnchorPane pantallaAdd;
    private PantallaAddController controllerAdd;

    private AnchorPane pantallaGet;
    private PantallaGetController controllerGet;

    private AnchorPane pantallaDelete;
    private PantallaDeleteController controllerDelete;
    
    private AnchorPane pantallaGetClientes;
    private FXMLSeleccionClienteController controllerGetCliente;
    
    private AnchorPane pantallaAddClientes;
    private FXMLAddClienteController controllerAddCliente;
    
    private AnchorPane pantallaDeleteClientes;
    private FXMLDeleteClienteController controllerDeleteCliente;
    
    private AnchorPane pantallaGetResenias;
    private FXMLSeleccionReseniaController controllerGetResenias;
    
    private AnchorPane pantallaAddResenias;
    private FXMLAddReseniaController controllerAddResenia;
    
    private AnchorPane pantallaDeleteResenias;
    private FXMLDeleteReseniaController controllerDeleteResenias;
    
    @FXML
    public void cargarPantallaLogin() {
        fxRoot.setCenter(pantallaLogin);
    }

    private void preCargaLogin() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/login.fxml"));
            pantallaLogin = loaderMenu.load();
            controllerLogin
                    = loaderMenu.getController();

            controllerLogin.setInicio(this);
        } catch (IOException ex) {

            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaGet() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/pantallaGet.fxml"));
            pantallaGet = loaderMenu.load();
            controllerGet
                    = loaderMenu.getController();

            controllerGet.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(PantallaGetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaAdd() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/pantallaAdd.fxml"));
            pantallaAdd = loaderMenu.load();
            controllerAdd
                    = loaderMenu.getController();

            controllerAdd.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(PantallaAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preCargaDelete() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/pantallaDelete.fxml"));
            pantallaDelete = loaderMenu.load();
            controllerDelete
                    = loaderMenu.getController();

            controllerDelete.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(PantallaDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void preCargaGetClientes() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLSeleccionCliente.fxml"));
            pantallaGetClientes = loaderMenu.load();
            controllerGetCliente
                    = loaderMenu.getController();

            controllerGetCliente.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLSeleccionClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void preCargaAddClientes() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLAddCliente.fxml"));
            pantallaAddClientes = loaderMenu.load();
            controllerAddCliente
                    = loaderMenu.getController();

            controllerAddCliente.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLAddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void preCargaDeleteClientes() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLDeleteCliente.fxml"));
            pantallaDeleteClientes = loaderMenu.load();
            controllerDeleteCliente
                    = loaderMenu.getController();

            controllerDeleteCliente.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLDeleteClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void preCargaGetResenias() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLSeleccionResenia.fxml"));
            pantallaGetResenias = loaderMenu.load();
            controllerGetResenias
                    = loaderMenu.getController();

            controllerGetResenias.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLSeleccionReseniaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void preCargaAddResenias() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLAddResenia.fxml"));
            pantallaAddResenias = loaderMenu.load();
            controllerAddResenia
                    = loaderMenu.getController();

            controllerAddResenia.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLAddReseniaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void preCargaDeleteResenias() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLDeleteResenia.fxml"));
            pantallaDeleteResenias = loaderMenu.load();
            controllerDeleteResenias
                    = loaderMenu.getController();

            controllerDeleteResenias.setInicio(this);

        } catch (IOException ex) {

            Logger.getLogger(FXMLDeleteReseniaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void cargarPantallaGet() {
        fxMenu.setVisible(true);
        fxRoot.setCenter(pantallaGet);
        controllerGet.cargarCompras();

    }

    @FXML
    public void cargarPantallaAdd() {
        fxRoot.setCenter(pantallaAdd);
    }

    @FXML
    public void cargarPantallaDelete() {
        fxRoot.setCenter(pantallaDelete);
    }
    
    @FXML
    public void cargarPantallaGetClientes(){
        fxRoot.setCenter(pantallaGetClientes);
    }
    
    @FXML
    public void cargarPantallaAddClientes(){
        fxRoot.setCenter(pantallaAddClientes);
    }
    
    @FXML
    public void cargarPantallaDeleteClientes(){
        fxRoot.setCenter(pantallaDeleteClientes);
    }
    
    @FXML
    public void cargarPantallaGetResenias(){
        fxRoot.setCenter(pantallaGetResenias);
    }
    
    @FXML
    public void cargarPantallaAddResenias(){
        fxRoot.setCenter(pantallaAddResenias);
    }
    
    @FXML
    public void cargarPantallaDeleteResenias(){
        fxRoot.setCenter(pantallaDeleteResenias);
    }

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        preCargaLogin();
        preCargaGet();
        preCargaAdd();
        preCargaDelete();
        preCargaGetClientes();
        preCargaAddClientes();
        preCargaDeleteClientes();
        preCargaGetResenias();
        preCargaAddResenias();
        preCargaDeleteResenias();
        fxMenu.setVisible(false);
        cargarPantallaLogin();
    }

}
