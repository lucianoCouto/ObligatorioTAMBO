/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Vaca;
import java.util.List;

/**
 *
 * @author Luciano
 */
public interface IVacaCRUD {

    public int pesoPromedioDeUltimas5VacasOrdeñadas(String tipoCategoria);

    public Vaca buscarVacaXCaravana(int caravana);

    public List<Vaca> listarVacasFiltradas(String filtro);
}
