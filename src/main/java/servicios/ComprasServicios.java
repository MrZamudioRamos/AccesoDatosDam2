/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.ComprasDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author oscar
 */
public class ComprasServicios {

    public List<String> getAllCompras() {
        ComprasDao dao = new ComprasDao();
        return dao.getAllCompras();
    }

    public List<String> getComprasPorFecha(LocalDate fecha) {
        ComprasDao dao = new ComprasDao();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<String> lineas;
        List<String> filtradas;

        lineas = dao.getAllCompras();

        String[] partes;

        if (fecha != null) {

            filtradas = new LinkedList<>();
            for (String i : lineas) {
                partes = i.split(";");
                if (fecha.format(formatter).equals(partes[2])) {
                    filtradas.add(i);
                }
            }

        } else {
            filtradas = lineas;
        }

        return filtradas;
    }

    public boolean addCompra(String nif, String idArticulo, LocalDate fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String nueva = nif + ";" + idArticulo + ";"
                + fecha.format(formatter);

        ComprasDao dao = new ComprasDao();
        return dao.addCompra(nueva);
    }

    public boolean borrarCompra(String linea) {
        ComprasDao dao = new ComprasDao();
        List<String> compras = dao.getAllCompras();
        compras.remove(linea);
        return dao.guardaAllCompras(compras);
    }
}
