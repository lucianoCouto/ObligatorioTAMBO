/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Usuario;
import Servicios.IObjetoCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class UsuarioMysql extends MySql implements IObjetoCRUD{

    @Override
    public void guardar(Object o) throws SQLException {
        Usuario u = (Usuario) o;
        strSQL = "INSERT INTO usuarios (nombre, nombreUsuario, contrasena, tipo) VALUES "
                + "('" + u.getNombre() + "', '" + u.getNombreDeUsuario() + "', '" + u.getContrasena() + "', '" + u.getTipo() + "')";
        update(strSQL);
    }

    @Override
    public void modificar(Object o) {
        Usuario u = (Usuario) o;
        strSQL = "UPDATE usuarios SET nombre = '" + u.getNombre() + "', nombreUsuario = '" + u.getNombreDeUsuario() + "', contrasena = " + u.getContrasena() + "', tipo = " + u.getTipo() + " WHERE idUsuario = " + u.getIdUsuario();
        update(strSQL);
    }

    @Override
    public void eliminar(Object o) {
        Usuario u = (Usuario) o;
        strSQL = "DELETE FROM usuarios WHERE idUsuario = " + u.getIdUsuario();
        update(strSQL);
    }

    @Override
    public List<Object> listar() {
        List<Object> objetos = new ArrayList<>();
        this.seleccionar("SELECT * FROM usuarios");
        try {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setNombreDeUsuario(rs.getString("nombreUsuario"));
                u.setContrasena(rs.getString("contrasena"));
                u.setTipo(rs.getString("tipo"));
                objetos.add(u);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return objetos;
    }
    
}
