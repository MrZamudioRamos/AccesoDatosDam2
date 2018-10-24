/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers.resenias;

import dao.ReseniasDao;
import fx.controllers.PantallaInicioController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import servicios.ArticulosServicios;
import servicios.ReseniasServicios;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLAddReseniaController implements Initializable {

    private PantallaInicioController inicio;

    public PantallaInicioController getInicio() {
        return inicio;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    private Alert alertError;
    private Alert alertInformacion;

    @FXML
    private TextField fxArticuloResenia;

    @FXML
    private DatePicker fxFechaResenia;

    @FXML
    private TextField fxOpinionResenia;

    public void limpiarValores() {
        fxArticuloResenia.clear();
        fxOpinionResenia.clear();
        fxFechaResenia.setValue(null);

    }

    public void clickAniadirResenia() {

        ArticulosServicios as = new ArticulosServicios();
        ReseniasServicios rs = new ReseniasServicios();
        ReseniasDao rd = new ReseniasDao();

        if (as.comprobarArticulo(fxArticuloResenia.getText()) != true) {

            String fila = "El identificador introducido no es válido";
            alertError.setContentText(fila);

            alertError.showAndWait();

        } else if (fxFechaResenia.getValue() == null) {
            alertError.setContentText("Introduzca una fecha");
            alertError.showAndWait();

        } else if (fxOpinionResenia.getText() != null) {
            if (rs.addResenia(fxArticuloResenia.getText(), fxFechaResenia.getValue(), fxOpinionResenia.getText())) {
                
                alertInformacion.setContentText("Resenia introducida correctamente");
                alertInformacion.showAndWait();
                
                rd.guardaAllResenias(rd.getAllResenias());
                
            } else {
                alertError.setContentText("No se pudo guardar la resenia");
                alertError.showAndWait();
            }
            
        } else {
            alertError.setContentText("Algún parámetro vacío");
            alertError.showAndWait();
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
        // TODO
        alertError = new Alert(Alert.AlertType.ERROR);
        alertInformacion = new Alert(Alert.AlertType.INFORMATION);
        alertInformacion.setTitle("Confirmación");
        alertInformacion.setHeaderText(null);
    }

}
