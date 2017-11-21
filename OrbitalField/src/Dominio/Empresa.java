/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Servicios.Fachada;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class Empresa {
    
    private final Fachada fachada;
    
    public Empresa() {
        fachada = Fachada.getInstancia();
    }
    
    public void guardarCliente (Cliente c) throws SQLException{
        this.fachada.getObjetoCRUD().guardar(c);
        //Clientemysql no implementado
    }
    public void modificarCliente (Cliente c) throws SQLException{
        this.fachada.getObjetoCRUD().modificar(c);
        //Clientemysql no implementado
    }
    public void eliminarSocio (Cliente c) throws SQLException{
        this.fachada.getObjetoCRUD().eliminar(c);
        //Clientemysql no implementado
    }

    public List<Cliente> listarClientes() {
        //returnthis.fachada.getObjetoCRUD().listar();
    }
    
}
