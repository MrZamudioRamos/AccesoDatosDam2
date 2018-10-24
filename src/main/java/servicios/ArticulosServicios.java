/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.ArticulosDao;
import java.util.List;

/**
 *
 * @author oscar
 */
public class ArticulosServicios {
    
    public boolean comprobarArticulo(String idArticulo) {
        boolean confirmado = false;
        ArticulosDao dao = new ArticulosDao();
        List<String> idArticulos = dao.getAllArticulos();
        for (String ids : idArticulos) {
            if (ids.equals(idArticulo)) {
                confirmado = true;
            }
        }
        return confirmado;
    }
    
    
  
}
