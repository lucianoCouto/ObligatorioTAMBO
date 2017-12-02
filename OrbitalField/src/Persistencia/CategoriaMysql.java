/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.CategoriaLeche;
import Servicios.ICategoriaCRUD;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class CategoriaMysql extends MySql implements ICategoriaCRUD {

    @Override
    public void modificar(Object o) {
        CategoriaLeche c = (CategoriaLeche) o;
        strSQL = "UPDATE categorias SET nombre = '" + u.getNombre() + "', nombreUsuario = '" + u.getNombreDeUsuario() + "', contrasena = " + u.getContrasena() + "', tipo = " + u.getTipo() + " WHERE idUsuario = " + u.getIdUsuario();
        update(strSQL);
    }

    @Override
    public List<CategoriaLeche> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaLeche buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
