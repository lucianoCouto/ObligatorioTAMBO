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
    public Usuario usuarioIniciado; 
    
    public Empresa() {
        fachada = Fachada.getInstancia();
    }
    
    public void guardarCliente (Cliente c) throws SQLException{
        this.fachada.getClienteObjectCRUD().guardar(c);
    }
    
    public void modificarCliente (Cliente c) throws SQLException{
        this.fachada.getClienteObjectCRUD().modificar(c);
    }

    public void eliminarCliente (Cliente c) throws SQLException{
        this.fachada.getClienteObjectCRUD().eliminar(c);
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        
        List<Object> lista =  this.fachada.getClienteObjectCRUD().listar();
        
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
        this.fachada.getUsuarioObjectCRUD().guardar(u);
    }
    
    public void modificarUsuario (Usuario u) throws SQLException{
        this.fachada.getUsuarioObjectCRUD().modificar(u);
    }

    public void eliminarUsuario (Usuario u) throws SQLException{
        this.fachada.getUsuarioObjectCRUD().eliminar(u);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        List<Object> lista =  this.fachada.getUsuarioObjectCRUD().listar();
        
        for(int i = 0; i< lista.size(); i++){
            Usuario u = (Usuario) lista.get(i);
            usuarios.add(u);
        }
        return usuarios;
    }
    
    public Usuario buscarUsuarioXNombreYContrasena(String usuario, String contrasena){
        return fachada.getUsuarioCRUD().buscarUsuarioXNombreYContrasena(usuario, contrasena);
    }
    
    public List<Usuario> listarUsuariosParaMaster(){
        return this.fachada.getUsuarioCRUD().listarUsuariosParaMaster();
    }
    
    public List<Usuario> listarUsuariosParaAdmin(){
        return this.fachada.getUsuarioCRUD().listarUsuariosParaAdmin();
    }   
}
