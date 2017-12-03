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
public class CategoriaLeche {

    private int idCategoria;
    private float precioCategoria;
    private String tipoCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public float getPrecioCategoria() {
        return precioCategoria;
    }

    public void setPrecioCategoria(float precioCategoria) {
        this.precioCategoria = precioCategoria;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    @Override
    public String toString() {
        return tipoCategoria;
    }

    public float calcularA(int promedioDePeso) {
        float cuidados = this.precioCategoria * 5 / 100;
        float alimentacion = this.precioCategoria * 15 / 100;
        float pesoPromedio = promedioDePeso * 2 / 100;

        return this.precioCategoria + cuidados + alimentacion + pesoPromedio;
    }

    public float calcularB(int promedioDePeso) {
        float cuidados = this.precioCategoria * 3 / 100;
        float alimentacion = this.precioCategoria * 10 / 100;
        float pesoPromedio = promedioDePeso * 1 / 100;

        float total = cuidados + alimentacion + pesoPromedio;

        if (promedioDePeso > 600) {
            return total;
        }
        return total - total * 5 / 100;
    }

    public float calcularC(int promedioDePeso) {
        float cuidadosYAlimentacion = this.precioCategoria * 3 / 100;
        float total = this.precioCategoria + cuidadosYAlimentacion;
        if (promedioDePeso > 650) {
            return total;
        }
        return total - total * 5 / 100;
    }

}
