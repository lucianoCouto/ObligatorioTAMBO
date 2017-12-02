/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Luciano
 */
public class LineaDeVenta {

    private int idLineaDeVenta;
    private CategoriaLeche categoria;
    private int cantidadDeLitros;

    public int getIdLineaDeVenta() {
        return idLineaDeVenta;
    }

    public void setIdLineaDeVenta(int idLineaDeVenta) {
        this.idLineaDeVenta = idLineaDeVenta;
    }

    public CategoriaLeche getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLeche categoria) {
        this.categoria = categoria;
    }

    public int getCantidadDeLitros() {
        return cantidadDeLitros;
    }

    public void setCantidadDeLitros(int cantidadDeLitros) {
        this.cantidadDeLitros = cantidadDeLitros;
    }
}
