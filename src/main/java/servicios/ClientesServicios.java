/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import dao.ClientesDao;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ricardo
 */

public class ClientesServicios {
    
    public List<String> getAllClientes() {
        ClientesDao dao = new ClientesDao();
        return dao.getAllClientes();
    }

    public boolean comprobrarCliente(String idCliente) {
        boolean confirmado = false;
        ClientesDao dao = new ClientesDao();
        List<String> idClientes = dao.getAllClientes();
        for (String ids : idClientes) {
            if (ids.equals(idCliente)) {
                confirmado = true;
            }
        }
        return confirmado;
    }
    
    public List<String> getClientesPorArticulo(String articulo) {

        ClientesDao rd = new ClientesDao();
        ArticulosServicios as = new ArticulosServicios();

        List<String> lineas;
        List<String> filtradas;

        lineas = rd.getAllClientes();

        String[] partes;

        if (articulo != null) {

            filtradas = new LinkedList<>();

            for (String i : lineas) {
                partes = i.split(";");
                if (articulo.equals(partes[0])) {
                    filtradas.add(i);
                }
            }

        } else {
            filtradas = lineas;
        }

        return filtradas;
    }

    public boolean addCliente(String idCliente, String nombre, String numero) {

        String nueva = idCliente + ";" + nombre + ";" + numero;

        ClientesDao dao = new ClientesDao();
        return dao.addCliente(nueva);
    }

    public boolean borrarCliente(String linea) {
        ClientesDao dao = new ClientesDao();
        List<String> clientes = dao.getAllClientes();
        clientes.remove(linea);
        return dao.guardaAllClientes(clientes);
    }
    
    public String getIdCliente(){
        
        ClientesDao dao = new ClientesDao();
        List<String> lineas = dao.getAllClientes();
        String[] partesCliente = null;
        
        for(String i : lineas){
            partesCliente = i.split(";");
        }
        String id = partesCliente[0];
        
        return id;
    }
    
    public String getNameCliente(){
        
        ClientesDao dao = new ClientesDao();
        List<String> lineas = dao.getAllClientes();
        String[] partesCliente = null;
        
        for(String i : lineas){
            partesCliente = i.split(";");
        }
        String name = partesCliente[1];
        
        return name;
    }
    
    public String getPhoneCliente(){
        
        ClientesDao dao = new ClientesDao();
        List<String> lineas = dao.getAllClientes();
        String[] partesCliente = null;
        
        for(String i : lineas){
            partesCliente = i.split(";");
        }
        String phone = partesCliente[2];
        
        return phone;
    }
    
}
