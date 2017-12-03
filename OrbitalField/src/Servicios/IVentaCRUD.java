/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Venta;
import Dominio.LineaDeVenta;
import java.util.List;

/**
 *
 * @author Luciano
 */
public interface IVentaCRUD {

    public void guardar(Venta v);

    public void guardarLineas(int idVenta, LineaDeVenta linea);
    
    public List<Venta> listar();
    
    public List<LineaDeVenta> listarLineasDeVenta(int idVenta);
    
    public int buscarUltimoIdVenta();
}
