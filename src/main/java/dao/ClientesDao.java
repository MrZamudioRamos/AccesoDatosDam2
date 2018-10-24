/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.ConfigurationProperties;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicios.ClientesServicios;

/**
 *
 * @author Ricardo
 */
public class ClientesDao {

    public List<String> getAllClientes() {

        List<String> idClientes = null;
        try {
            Path fileClientes = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoClientes"));

            idClientes = Files.readAllLines(fileClientes);
        } catch (IOException ex) {
            Logger.getLogger(ArticulosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idClientes;
    }

    public boolean guardaAllClientes(List<String> lineas) {

        boolean ok = false;
        try {
            Path fileClientes = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoClientes"));
            Files.write(fileClientes, lineas);
            ok = true;
        } catch (IOException ex) {
            Logger.getLogger(ClientesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public boolean addCliente(String linea) {

        boolean ok = false;
        try {

            Path fileClientes = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoClientes"));

            Files.write(fileClientes, linea.getBytes(), StandardOpenOption.APPEND);
            ok = true;

        } catch (IOException ex) {
            Logger.getLogger(ClientesServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

}
