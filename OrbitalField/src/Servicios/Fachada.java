/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Persistencia.CategoriaMysql;
import Persistencia.ClienteMysql;
import Persistencia.UsuarioMysql;
import Persistencia.VacaMysql;

/**
 *
 * @author Luciano
 */
public class Fachada {

    private static Fachada instancia;
    private final IObjetoCRUD clienteObjectCRUD;
    private final ICiudadCRUD ciudadCRUD;
    private final IObjetoCRUD usuarioObjectCRUD;
    private final IUsuarioCRUD usuarioCRUD;
    private final IObjetoCRUD vacasObjectCRUD;
    private final ICategoriaCRUD categoriaCRUD;
    private Fachada() {
        this.clienteObjectCRUD = new ClienteMysql();
        this.ciudadCRUD = new ClienteMysql();
        this.usuarioObjectCRUD = new UsuarioMysql();
        this.usuarioCRUD = new UsuarioMysql();
        this.vacasObjectCRUD = new VacaMysql();
        this.categoriaCRUD = new CategoriaMysql();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public IObjetoCRUD getClienteObjectCRUD() {
        return clienteObjectCRUD;
    }

    public ICiudadCRUD getCiudadCRUD() {
        return ciudadCRUD;
    }
    
    public IObjetoCRUD getUsuarioObjectCRUD(){
        return usuarioObjectCRUD;
    }
    
    public IUsuarioCRUD getUsuarioCRUD(){
        return usuarioCRUD;
    }
    
    public IObjetoCRUD getVacaObjectCRUD(){
        return vacasObjectCRUD;
    }
    
    public ICategoriaCRUD getCategoriaCRUD(){
        return categoriaCRUD;
    }
}
