/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Cliente;
import Servicios.ICiudadCRUD;
import Servicios.IObjetoCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class ClienteMysql extends MySql implements IObjetoCRUD, ICiudadCRUD {

    @Override
    public void guardar(Object o) throws SQLException {
        Cliente c = (Cliente) o;
        strSQL = "INSERT INTO clientes (razonSocial, nombre, rut, nombreCiudad) VALUES "
                + "('" + c.getRazonSocial() + "', '" + c.getNombreCliente() + "', '" + c.getRut() + "', '" + c.getCiudad() + "')";
        update(strSQL);
    }

    @Override
    public void modificar(Object o) {
        Cliente c = (Cliente) o;
        strSQL = "UPDATE clientes SET razonSocial = '" + c.getRazonSocial() + "', nombre = '" + c.getNombreCliente() + "', rut = " + c.getRut() + "', nombreCiudad = " + c.getCiudad() + " WHERE idCliente = " + c.getIdCliente();
        update(strSQL);
    }

    @Override
    public void eliminar(Object o) {
        Cliente c = (Cliente) o;
        strSQL = "DELETE FROM clientes WHERE idCliente = " + c.getIdCliente();
        update(strSQL);
    }

    @Override
    public List<Object> listar() {

        List<Object> objetos = new ArrayList<>();
        this.seleccionar("SELECT * FROM clientes");
        try {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setRazonSocial(rs.getString("razonSocial"));
                c.setNombreCliente(rs.getString("nombre"));
                c.setRut(rs.getInt("rut"));
                c.setCiudad(rs.getString("nombreCiudad"));
                objetos.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return objetos;
    }

    @Override
    public ArrayList<String> listarCiudades() {

        ArrayList<String> ciudades = new ArrayList<>();
        this.seleccionar("SELECT nombreCiudad FROM ciudades");
        try {
            while (rs.next()) {
                String ciudad = (rs.getString("nombreCiudad"));
                ciudades.add(ciudad);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return ciudades;
    }

}
