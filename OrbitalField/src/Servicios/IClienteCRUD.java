/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Cliente;

/**
 *
 * @author Luciano
 */
public interface IClienteCRUD {
    public Cliente buscar(int id);
}
