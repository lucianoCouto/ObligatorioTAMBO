/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Persistencia.CategoriaMysql;
import Persistencia.ClienteMysql;
import Persistencia.TanqueMysql;
import Persistencia.UsuarioMysql;
import Persistencia.VacaMysql;
import Persistencia.VentaMysql;

/**
 *
 * @author Luciano
 */
public class Fachada {

    private static Fachada instancia;
    private final IObjetoCRUD clienteObjectCRUD;
    private final IClienteCRUD clienteCRUD;
    private final ICiudadCRUD ciudadCRUD;
    private final IObjetoCRUD usuarioObjectCRUD;
    private final IUsuarioCRUD usuarioCRUD;
    private final IObjetoCRUD vacaObjectCRUD;
    private final IVacaCRUD vacaCRUD;
    private final ICategoriaCRUD categoriaCRUD;
    private final IObjetoCRUD tanqueObjectCRUD;
    private final IVentaCRUD ventaCRUD;
    private Fachada() {
        this.clienteObjectCRUD = new ClienteMysql();
        this.clienteCRUD = new ClienteMysql();
        this.ciudadCRUD = new ClienteMysql();
        this.usuarioObjectCRUD = new UsuarioMysql();
        this.usuarioCRUD = new UsuarioMysql();
        this.vacaObjectCRUD = new VacaMysql();
        this.categoriaCRUD = new CategoriaMysql();
        this.tanqueObjectCRUD = new TanqueMysql();
        this.ventaCRUD = new VentaMysql();
        this.vacaCRUD = new VacaMysql();
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
        return vacaObjectCRUD;
    }
    
    public ICategoriaCRUD getCategoriaCRUD(){
        return categoriaCRUD;
    }
    public IObjetoCRUD getTanqueObjectCRUD() {
        return tanqueObjectCRUD;
    }

    public IClienteCRUD getClienteCRUD() {
        return clienteCRUD;
    }

    public IVentaCRUD getVentaCRUD() {
        return ventaCRUD;
    }

    public IVacaCRUD getVacaCRUD() {
        return vacaCRUD;
    }
}
