/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers.resenias;

import fx.controllers.PantallaInicioController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import servicios.ReseniasServicios;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLDeleteReseniaController implements Initializable {

    private PantallaInicioController inicio;

    public PantallaInicioController getInicio() {
        return inicio;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    private Alert alertError;

    @FXML
    private ComboBox fxComboBoxReseniaBorrar;

    @FXML
    private ListView fxListViewReseniaBorrar;

    @FXML
    private Label fxLabelResenia;

    public void cargarResenias() {

        fxListViewReseniaBorrar.getItems().clear();
        fxComboBoxReseniaBorrar.getItems().clear();

        ReseniasServicios rs = new ReseniasServicios();
        List<String> resenias = rs.getAllResenias();
        if (resenias != null) {
            fxListViewReseniaBorrar.getItems().addAll(resenias);
            fxComboBoxReseniaBorrar.getItems().addAll(resenias);
        } else {
            alertError.showAndWait();
        }

    }

    public void clickBorrarResenia() {

        if (fxComboBoxReseniaBorrar.getItems().isEmpty()) {
            alertError.setContentText("El fichero de compras no se pudo cargar");
            alertError.showAndWait();
        } else {
            String eliminar = fxComboBoxReseniaBorrar.getSelectionModel().getSelectedItem().toString();

            fxLabelResenia.setText("Has seleccionado " + eliminar);

            ReseniasServicios rs = new ReseniasServicios();
            
            if (rs.borrarResenia(eliminar)) {

                fxListViewReseniaBorrar.getItems().remove(fxComboBoxReseniaBorrar.getSelectionModel().getSelectedItem());
                fxComboBoxReseniaBorrar.getItems().remove(fxComboBoxReseniaBorrar.getSelectionModel().getSelectedItem());

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Confirmación");
                alert2.setHeaderText(null);
                alert2.setContentText("Compra borrada correctamente");
                alert2.showAndWait();
            } else {
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
        // TODO
    }

}
