/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.ReseniasDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class ReseniasServicios {

    public List<String> getAllResenias() {
        ReseniasDao dao = new ReseniasDao();
        return dao.getAllResenias();
    }

    public boolean comprobarResenia(String resenia) {
        boolean confirmado = false;
        ReseniasDao dao = new ReseniasDao();
        List<String> resenias = dao.getAllResenias();
        for (String ids : resenias) {
            if (ids.equals(resenia)) {
                confirmado = true;
            }
        }
        return confirmado;
    }

    public List<String> getReseniasPorArticulo(String articulo) {

        ReseniasDao rd = new ReseniasDao();
        ArticulosServicios as = new ArticulosServicios();

        List<String> lineas;
        List<String> filtradas;

        lineas = rd.getAllResenias();

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

    public boolean addResenia(String articulo, LocalDate fecha, String opinion) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String nueva = articulo + ";" + fecha.format(formatter) + ";"
                + opinion;

        ReseniasDao dao = new ReseniasDao();

        return dao.addReseniaDao(nueva);
    }

    public boolean borrarResenia(String linea) {
        ReseniasDao dao = new ReseniasDao();
        List<String> resenias = dao.getAllResenias();
        resenias.remove(linea);
        return dao.guardaAllResenias(resenias);
    }

    public String getItemCliente() {

        ReseniasDao dao = new ReseniasDao();
        List<String> lineas = dao.getAllResenias();
        String[] partesCliente = null;

        for (String i : lineas) {
            partesCliente = i.split(";");
        }
        String item = partesCliente[0];

        return item;
    }

    public String getDateCliente() {

        ReseniasDao dao = new ReseniasDao();
        List<String> lineas = dao.getAllResenias();
        String[] partesCliente = null;

        for (String i : lineas) {
            partesCliente = i.split(";");
        }
        String date = partesCliente[1];

        return date;
    }

    public String getCommentCliente() {

        ReseniasDao dao = new ReseniasDao();
        List<String> lineas = dao.getAllResenias();
        String[] partesCliente = null;

        for (String i : lineas) {
            partesCliente = i.split(";");
        }
        String comment = partesCliente[2];

        return comment;
    }
}
