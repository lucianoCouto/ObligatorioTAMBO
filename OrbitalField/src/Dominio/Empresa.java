/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Servicios.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
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
        this.fachada.getClienteCRUD().guardar(c);
    }
    
    public void modificarCliente (Cliente c) throws SQLException{
        this.fachada.getClienteCRUD().modificar(c);
    }

    public void eliminarCliente (Cliente c) throws SQLException{
        this.fachada.getClienteCRUD().eliminar(c);
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        
        List<Object> lista =  this.fachada.getClienteCRUD().listar();
        
        for(int i = 0; i< lista.size(); i++){
            Cliente c = (Cliente) lista.get(i);
            clientes.add(c);
        }
        return clientes;
    }
    
    public ArrayList<String> listarCiudades(){
        return this.fachada.getCiudadCRUD().listarCiudades();
    }
    
    public void guardarUsuario (Usuario u) throws SQLException{
        this.fachada.getUsuarioCRUD().guardar(u);
    }
    
    public void modificarUsuario (Usuario u) throws SQLException{
        this.fachada.getUsuarioCRUD().modificar(u);
    }

    public void eliminarUsuario (Usuario u) throws SQLException{
        this.fachada.getUsuarioCRUD().eliminar(u);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        List<Object> lista =  this.fachada.getUsuarioCRUD().listar();
        
        for(int i = 0; i< lista.size(); i++){
            Usuario u = (Usuario) lista.get(i);
            usuarios.add(u);
        }
        return usuarios;
    }
    
}
