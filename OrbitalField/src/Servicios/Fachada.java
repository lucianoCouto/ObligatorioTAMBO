/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Persistencia.TanqueMysql;

/**
 *
 * @author Luciano
 */
public class Fachada {
    private static Fachada instancia;
    private final IObjetoCRUD objetoCRUD;

    private Fachada() {
        this.objetoCRUD = new TanqueMysql();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }
   
    public IObjetoCRUD getObjetoCRUD() {
        return objetoCRUD;
    }
}
