/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import servicios.ComprasServicios;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaDeleteController implements Initializable {

    @FXML
    private ListView fxListViewBorrar;

    private PantallaInicioController inicio;
    private Alert alertError;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    public void cargarListaView() {

        fxListViewBorrar.getItems().clear();

        ComprasServicios cs = new ComprasServicios();
        List<String> compras = cs.getAllCompras();
        if (compras != null) {
            fxListViewBorrar.getItems().addAll(compras);
        } else {
            alertError.showAndWait();
        }

    }

    @FXML
    public void borrarCompra() {
        if (fxListViewBorrar.getItems().isEmpty()) {
            alertError.setContentText("El fichero de compras no se pudo cargar");
            alertError.showAndWait();
        } else {
            String eliminar = fxListViewBorrar.getSelectionModel().getSelectedItem().toString();

            ComprasServicios cs = new ComprasServicios();
            if (cs.borrarCompra(eliminar)) {

                fxListViewBorrar.getItems().remove(fxListViewBorrar.getSelectionModel().getSelectedItem());

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Confirmación");
                alert2.setHeaderText(null);
                alert2.setContentText("Compra borrada correctamente");
                alert2.showAndWait();
            }
            else
            {
                alertError.setContentText("Se produjo un error al borrar");
                alertError.showAndWait();
            }
        }

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
        alertError.setTitle("Info");
        alertError.setHeaderText(null);
        alertError.setContentText("El fichero de compras no se pudo cargar");

        cargarListaView();
    }

}
