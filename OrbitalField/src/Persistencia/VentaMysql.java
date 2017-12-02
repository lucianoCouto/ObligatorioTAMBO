/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.LineaDeVenta;
import Dominio.Venta;
import Servicios.Fachada;
import Servicios.IVentaCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class VentaMysql extends MySql implements IVentaCRUD {

    private final Fachada fachada = Fachada.getInstancia();

    @Override
    public void guardar(Venta v) {
        strSQL = "INSERT INTO venta (precioTotal, idCliente) VALUES "
                + "('" + v.getPrecioTotal() + "', '" + v.getCliente().getIdCliente() + "')";
        update(strSQL);
        v.getLineas().forEach((linea) -> {
            this.guardarLineas(v.getIdVenta(), linea);
        });
    }

    @Override
    public void guardarLineas(int idVenta, LineaDeVenta linea) {
        strSQL = "INSERT INTO lineaVenta (idVenta, idCategoria, cantidad) VALUES "
                + "('" + idVenta + "', '" + linea.getCategoria().getIdCategoria() + "', '" + linea.getCantidadDeLitros() + "')";
        update(strSQL);
    }

    @Override
    public List<Venta> listar() {
        List<Venta> ventas = new ArrayList<>();
        this.seleccionar("SELECT * FROM venta");
        try {
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("idVenta"));
                v.setCliente(fachada.getClienteCRUD().buscar(rs.getInt("idCliente")));
                v.setPrecioTotal(rs.getFloat("precioTotal"));
                v.setLineas(this.buscarLineasDeVenta(rs.getInt("idVenta")));
                ventas.add(v);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return ventas;
    }

    private ArrayList<LineaDeVenta> buscarLineasDeVenta(int idVenta) {
        ArrayList<LineaDeVenta> lineas = new ArrayList<>();
        this.seleccionar("SELECT * FROM lineaventa WHERE idVenta = " + idVenta);
        try {
            while (rs.next()) {
                LineaDeVenta l = new LineaDeVenta();
                l.setIdLineaDeVenta(rs.getInt("idLineaVenta"));
                l.setCantidadDeLitros(rs.getInt("cantidad"));
                l.setCategoria(fachada.getCategoriaCRUD().buscar(rs.getInt("idCategoria")));
                lineas.add(l);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return lineas;
    }

}
