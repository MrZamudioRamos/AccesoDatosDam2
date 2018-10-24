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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import servicios.ArticulosServicios;
import servicios.ClientesServicios;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class FXMLSeleccionClienteController implements Initializable {
    
    @FXML
    private TextField fxIdArticulo;
    
    @FXML 
    private ComboBox fxComboBoxCliente;
    
    private PantallaInicioController inicio;

    public PantallaInicioController getInicio() {
        return inicio;
    }

    public void setInicio(PantallaInicioController inicio) {
        this.inicio = inicio;
    }
    
    private Alert alertErrorCliente;
    
    public void clickBuscarCliente(){
        fxComboBoxCliente.getItems().clear();
        

        ClientesDao rd = new ClientesDao();
        ClientesServicios cs = new ClientesServicios();
        ArticulosServicios ass = new ArticulosServicios();
        
        List<String> clientes;

        if (fxIdArticulo.getText() != null) {

            if (ass.comprobarArticulo(fxIdArticulo.getText()) != true) {

                String fila = "El artículo introducido no es válido";

                alertErrorCliente.setContentText(fila);

                alertErrorCliente.showAndWait();
            } else {
                clientes = cs.getClientesPorArticulo(fxIdArticulo.getText());
                fxComboBoxCliente.getItems().addAll(clientes);
            }
        } else {    
            clientes = rd.getAllClientes();
            fxComboBoxCliente.getItems().addAll(clientes);
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
