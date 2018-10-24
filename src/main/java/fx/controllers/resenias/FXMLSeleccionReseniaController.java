/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers.resenias;

import dao.ReseniasDao;
import fx.controllers.PantallaInicioController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import servicios.ArticulosServicios;
import servicios.ReseniasServicios;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLSeleccionReseniaController implements Initializable {

    private PantallaInicioController inicio;

    public PantallaInicioController getInicio() {
        return inicio;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    @FXML
    private ComboBox<String> fxComboBoxResenia;

    @FXML
    private ListView<String> fxListViewResenia;

    @FXML
    private TextField fxArticulo;

    private Alert alertErrorResenias;

    public void clickBuscarResenia() {
        fxComboBoxResenia.getItems().clear();
        fxListViewResenia.getItems().clear();

        ReseniasDao rd = new ReseniasDao();
        ArticulosServicios as = new ArticulosServicios();
        ReseniasServicios rs = new ReseniasServicios();
        List<String> resenias;

        if (fxArticulo.getText() != null) {

            if (as.comprobarArticulo(fxArticulo.getText()) != true) {

                String fila = "El artículo introducido no es válido";

                alertErrorResenias.setContentText(fila);

                alertErrorResenias.showAndWait();
            } else {
                resenias = rs.getReseniasPorArticulo(fxArticulo.getText());
                fxComboBoxResenia.getItems().addAll(resenias);
                fxListViewResenia.getItems().addAll(resenias);
            }
        } else {    
            resenias = rd.getAllResenias();
            fxComboBoxResenia.getItems().addAll(resenias);
            fxListViewResenia.getItems().addAll(resenias);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alertErrorResenias = new Alert(Alert.AlertType.ERROR);
    }

}
