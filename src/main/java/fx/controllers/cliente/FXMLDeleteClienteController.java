/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers.cliente;

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
import servicios.ClientesServicios;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLDeleteClienteController implements Initializable {
    private PantallaInicioController inicio;

    public PantallaInicioController getInicio() {
        return inicio;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }

    private Alert alertError;

    @FXML
    private ComboBox fxComboBoxBorrarCliente;

    @FXML
    private ListView fxListViewBorrarCliente;

    @FXML
    private Label fxLabelCliente;

    public void cargarClientes() {

        fxListViewBorrarCliente.getItems().clear();
        fxComboBoxBorrarCliente.getItems().clear();

        ClientesServicios cs = new ClientesServicios();
        List<String> clientes = cs.getAllClientes();
        if (clientes != null) {
            fxListViewBorrarCliente.getItems().addAll(clientes);
            fxComboBoxBorrarCliente.getItems().addAll(clientes);
        } else {
            alertError.showAndWait();
        }

    }

    public void clickBorrarCliente() {

        if (fxComboBoxBorrarCliente.getItems().isEmpty()) {
            alertError.setContentText("El fichero de compras no se pudo cargar");
            alertError.showAndWait();
        } else {
            String eliminar = fxComboBoxBorrarCliente.getSelectionModel().getSelectedItem().toString();

            fxLabelCliente.setText("Has seleccionado " + eliminar);

            ClientesServicios cs = new ClientesServicios();
            
            if (cs.borrarCliente(eliminar)) {

                fxListViewBorrarCliente.getItems().remove(fxListViewBorrarCliente.getSelectionModel().getSelectedItem());
                fxComboBoxBorrarCliente.getItems().remove(fxComboBoxBorrarCliente.getSelectionModel().getSelectedItem());

                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Confirmación");
                alert2.setHeaderText(null);
                alert2.setContentText("Cliente borrado correctamente");
                alert2.showAndWait();
            } else {
                alertError.setContentText("Se produjo un error al borrar");
                alertError.showAndWait();
            }
        }

    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
