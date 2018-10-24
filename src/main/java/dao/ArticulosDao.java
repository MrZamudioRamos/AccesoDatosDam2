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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class ArticulosDao {

    public List<String> getAllArticulos() {
        List<String> idArticulos = null;
        try {
            Path fileArticulos = Paths.get(ConfigurationProperties.
                    getInstance().getProperties().getProperty("archivoArticulos"));

            idArticulos = Files.readAllLines(fileArticulos);
        } catch (IOException ex) {
            Logger.getLogger(ArticulosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idArticulos;
    }

}
