/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Persistencia.ClienteMysql;
import Persistencia.UsuarioMysql;

/**
 *
 * @author Luciano
 */
public class Fachada {

    private static Fachada instancia;
    private final IObjetoCRUD clienteCRUD;
    private final ICiudadCRUD ciudadCRUD;
    private final IObjetoCRUD usuarioCRUD;

    private Fachada() {
        this.clienteCRUD = new ClienteMysql();
        this.ciudadCRUD = new ClienteMysql();
        this.usuarioCRUD = new UsuarioMysql();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public IObjetoCRUD getClienteCRUD() {
        return clienteCRUD;
    }

    public ICiudadCRUD getCiudadCRUD() {
        return ciudadCRUD;
    }
    public IObjetoCRUD getUsuarioCRUD(){
        return usuarioCRUD;
    }
}
