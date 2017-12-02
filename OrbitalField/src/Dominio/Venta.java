/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author Luciano
 */
public class Venta {
    private int idVenta;
    private float precioTotal;
    private Cliente cliente;
    private ArrayList<LineaDeVenta> lineas;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaDeVenta> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaDeVenta> lineas) {
        this.lineas = lineas;
    }
    
    
}
