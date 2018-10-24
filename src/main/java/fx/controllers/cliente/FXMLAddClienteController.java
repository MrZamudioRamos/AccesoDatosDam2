/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers.cliente;

import dao.ClientesDao;
import fx.controllers.PantallaInicioController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import servicios.ClientesServicios;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLAddClienteController implements Initializable {

    @FXML
    private TextField fxIdCliente;

    @FXML
    private TextField fxNombreCliente;

    @FXML
    private TextField fxTelefonoCliente;

    private Alert alertError;
    private Alert alertInformacion;

    private PantallaInicioController inicio;

    public PantallaInicioController getInicio() {
        return inicio;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void limpiarValores() {
        fxIdCliente.clear();
        fxNombreCliente.clear();
        fxTelefonoCliente.clear();
    }

    public void clickAniadirCliente() {

        ClientesServicios cs = new ClientesServicios();
        ClientesDao cd = new ClientesDao();

        if (cs.comprobrarCliente(fxIdCliente.getText()) == true) {
            String fila = "El identificador ya existe";
            alertError.setContentText(fila);
            alertError.showAndWait();
        } else if (fxIdCliente.getText() != null && fxNombreCliente.getText() != null && fxTelefonoCliente.getText() != null) {
            if (cs.addCliente(fxIdCliente.getText(), fxNombreCliente.getText(), fxTelefonoCliente.getText())) {
                alertInformacion.setContentText("Cliente introducido correctamente");
                alertInformacion.showAndWait();
                cd.guardaAllClientes(cd.getAllClientes());
            } else {
                alertError.setContentText("No se pudo guardar el cliente");
                alertError.showAndWait();
            }
        } else {
            alertError.setContentText("No puede dejar parámetros vacíos..");
            alertError.showAndWait();
        }
    }

    //Get ALL clientes.
    //Add a Lista.
    //GuardaXML.
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alertError = new Alert(Alert.AlertType.ERROR);
        alertInformacion = new Alert(Alert.AlertType.INFORMATION);
        alertInformacion.setTitle("Confirmación");
        alertInformacion.setHeaderText(null);
    }

}
