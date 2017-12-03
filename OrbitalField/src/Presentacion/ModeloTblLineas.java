/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CategoriaLeche;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Dominio.LineaDeVenta;
/**
 *
 * @author Luciano
 */
public class ModeloTblLineas extends AbstractTableModel{

    private static final int CANT_COLS = 2;
    private static final String [] NOM_COLS = {"Categoria", "Litros"};
    private List<LineaDeVenta> Lineas;
    
    @Override
    public int getRowCount() {
        return Lineas.size();
    }

    @Override
    public int getColumnCount() {
        return CANT_COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LineaDeVenta linea = Lineas.get(rowIndex);
        switch (columnIndex){
            case 0:
                return linea.getCategoria();
            case 1:
                return linea.getCantidadDeLitros();
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return CategoriaLeche.class;
            case 1:
                return Integer.class;
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column){
        return NOM_COLS[column];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    public void setDatos(List<LineaDeVenta> lista){
        Lineas = lista;
    }
    
    public LineaDeVenta getLinea(int row){
        return Lineas.get(row);
    } 
    
}
