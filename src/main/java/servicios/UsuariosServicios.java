/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import config.ConfiguracionYaml;

/**
 *
 * @author oscar
 */
public class UsuariosServicios {

    public boolean comprobarUsuario(String user, String pass) {
        boolean userOK = false;
        if (ConfiguracionYaml.getInstance().getUser().equals(user)
                && ConfiguracionYaml.getInstance().getPass().equals(pass)) {
            userOK = true;
        }
        return userOK;
    }

}
