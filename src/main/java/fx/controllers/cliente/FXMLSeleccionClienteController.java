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

    public void clickBuscarCliente() {
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
                //Coger datos Y pasarlo a Xstream creando un new Xtrea.. Y envianddo los datos...En el xstream
                //Cargar XML
                //Guardar XML
                //Imprimir XML Clientes
            }
        } else {
            clientes = rd.getAllClientes();
            fxComboBoxCliente.getItems().addAll(clientes);
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



/*public class LocalDateConverter implements SingleValueConverter {

    //Indicates how to convert to String a Telephone object
	public String toString(LocalDate obj) {
            return ((Address) obj).getStreet()+"::"+((Address) obj).getNumber();
    }

    //Indicates how to get a Telephone object from a string
	public Object fromString(String street) {
    	    Address address=new Address();
            String []split = street.split("::");
    	    address.setStreet(split[0]);
    	    address.setNumber(Integer.parseInt(split[1]));
            return address;
    }


    //Indicates the types to be converted
    public boolean canConvert(Class type) {
            return type.equals(LocalDate.class);
    }

    public class LocalDateToString {
    public static void main(String[] args) {

        String now = "2016-11-09 10:30";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);

        System.out.println("Before : " + now);
        
        String sFormatDateTime = formatDateTime.format(formatter);

        System.out.println("After  sdasd  : " + sFormatDateTime);

        System.out.println("After : " + formatDateTime.format(formatter));

    }
}*/



