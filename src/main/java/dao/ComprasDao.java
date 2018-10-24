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
import servicios.ComprasServicios;

/**
 *
 * @author oscar
 */
public class ComprasDao {

    public List<String> getAllCompras() {
        List<String> lineas = null;
        try {
            Path ficheroCompras = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoCompras"));
            lineas = Files.readAllLines(ficheroCompras);
        } catch (IOException ex) {
            Logger.getLogger(ComprasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineas;
    }

    public boolean guardaAllCompras(List<String> lineas) {
        boolean ok = false;
        try {
            Path ficheroCompras = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoCompras"));
            Files.write(ficheroCompras, lineas);
            ok = true;
        } catch (IOException ex) {
            Logger.getLogger(ComprasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public boolean addCompra(String linea) {
        boolean ok = false;
        try {
            Path fileCompras = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoCompras"));

            Files.write(fileCompras, linea.getBytes(), StandardOpenOption.APPEND);
            ok = true;
            
        } catch (IOException ex) {
            Logger.getLogger(ComprasServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

}
