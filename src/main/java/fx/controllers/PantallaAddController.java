/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import dao.ClientesDao;
import dao.ComprasDao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import servicios.ArticulosServicios;
import servicios.ComprasServicios;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaAddController implements Initializable {

    private PantallaInicioController inicio;

    @FXML
    private TextField nifNuevo;

    @FXML
    private TextField compraNueva;

    @FXML
    private DatePicker fechaNueva;

    private Alert alertError;
    private Alert alertInformacion;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void limpiarValores() {
        nifNuevo.clear();
        compraNueva.clear();
        fechaNueva.setValue(null);
    }

    @FXML
    public void addCompra() {
        ArticulosServicios as = new ArticulosServicios();
        ComprasServicios cs = new ComprasServicios();
        ComprasDao cd = new ComprasDao();

        if (as.comprobarArticulo(compraNueva.getText()) != true) {

            String fila = "El identificador introducido no es válido";
            alertError.setContentText(fila);

            alertError.showAndWait();

        } else if (fechaNueva.getValue() == null) {
            alertError.setContentText("Introduzca una fecha");
            alertError.showAndWait();
        } else {

            if (cs.addCompra(nifNuevo.getText(), compraNueva.getText(), fechaNueva.getValue())) {
                
                alertInformacion.setContentText("Compra introducida correctamente");
                
                alertInformacion.showAndWait();
                
                cd.guardaAllCompras(cd.getAllCompras());
            
            } else {
                alertError.setContentText("No se pudo guardar la compra");
                alertError.showAndWait();
            }
        }
        limpiarValores();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertError = new Alert(Alert.AlertType.ERROR);
        alertInformacion = new Alert(Alert.AlertType.INFORMATION);
        alertInformacion.setTitle("Confirmación");
        alertInformacion.setHeaderText(null);
    }

}
