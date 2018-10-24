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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Resenias;
import servicios.ReseniasServicios;

/**
 *
 * @author Ricardo
 */
public class ReseniasDao {

    public List<String> getAllResenias() {
        List<String> resenias = null;
        try {
            Path fileResenias = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoResenias"));

            resenias = Files.readAllLines(fileResenias);
        } catch (IOException ex) {
            Logger.getLogger(ArticulosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resenias;
    }

    public boolean guardaAllResenias(List<String> lineas) {
        boolean ok = false;
        try {
            Path ficheroResenias = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoResenias"));
            Files.write(ficheroResenias, lineas);
            ok = true;
        } catch (IOException ex) {
            Logger.getLogger(ComprasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    public boolean addReseniaDao(String linea) {
        boolean ok = false;
        try {

            Path fileResenias = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoResenias"));

            Files.write(fileResenias, linea.getBytes(), StandardOpenOption.APPEND);
            ok = true;

        } catch (IOException ex) {
            Logger.getLogger(ReseniasServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
    
//    public boolean crearResenia(String linea){
//        boolean ok = false;
//        List<Resenias> resenias = new LinkedList<Resenias>();
//        resenias.add(addReseniaDao(linea));
//        
//        return ok;
//    }
    
}
