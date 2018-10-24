/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import dao.ArticulosDao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import servicios.ComprasServicios;

/**
 * FXML Controller class
 *
 * @author dam2
 */
public class PantallaGetController implements Initializable {

    private PantallaInicioController inicio;

    @FXML
    private DatePicker filtroFecha;

    public DatePicker getFiltroFecha() {
        return filtroFecha;
    }

    @FXML
    private ListView<String> fxListView;

    @FXML
    private ComboBox<String> fxComboBoxGet;

    @FXML
    private ComboBox<String> fxComboBoxGetArticulos;

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    private Alert alertErrorCompras;
    private Alert alertErrorArticulos;

    public void cargarCompras() {
        fxListView.getItems().clear();
        fxComboBoxGet.getItems().clear();

        ComprasServicios cs = new ComprasServicios();
        List<String> compras;

        if (filtroFecha.getValue() != null) {
            compras = cs.getComprasPorFecha(filtroFecha.getValue());
        } else {
            compras = cs.getAllCompras();
        }

        if (compras != null) {
            fxListView.getItems().addAll(compras);
            fxComboBoxGet.getItems().addAll(compras);
        } else {
            
            alertErrorCompras.setTitle("Info");
            alertErrorCompras.setHeaderText(null);
            alertErrorCompras.setContentText("El fichero de compras no se pudo cargar");

            alertErrorCompras.showAndWait();
        }

    }

    public void cargarArticulos() {
        fxComboBoxGetArticulos.getItems().clear();
        ArticulosDao ao = new ArticulosDao();
        List<String> articulos;

        articulos = ao.getAllArticulos();

        if (articulos != null) {
            fxComboBoxGetArticulos.getItems().addAll(articulos);
        } else {
            alertErrorArticulos.setTitle("Info");
            alertErrorArticulos.setHeaderText(null);
            alertErrorArticulos.setContentText("El fichero de articulos no se pudo cargar");
            alertErrorArticulos.showAndWait();
        }
    }

    @FXML
    public void mostrarCompras() {

        cargarCompras();

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertErrorCompras = new Alert(Alert.AlertType.ERROR);
        alertErrorArticulos = new Alert(Alert.AlertType.ERROR);
        cargarCompras();
    }

}
