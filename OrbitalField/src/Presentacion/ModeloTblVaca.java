/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CategoriaLeche;
import Dominio.Vaca;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gian
 */
class ModeloTblVaca extends AbstractTableModel{

    //Utilizamos Modelos para poder cargar datos a JTable, personalizando los datos que se muestran
    
    private static final int CANT_COLS = 5;
    private static final String [] NOM_COLS = {"Codigo Vaca", "Raza", "Peso", "Fecha de Nacimiento", "Categoria de Leche"};
    private List<Vaca> Vacas;
    
    @Override
    public int getRowCount() {
        return Vacas.size();
    }

    @Override
    public int getColumnCount() {
        return CANT_COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vaca vaca = Vacas.get(rowIndex);
        switch (columnIndex){
            case 0:
                return vaca.getCodigoVaca();
            case 1:
                return vaca.getRaza();
            case 2:
                return vaca.getPeso();
            case 3:
                return vaca.getFechaDeNacimiento();
            case 4:
                return vaca.getCategoriaDeLeche();
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return Date.class;
            case 4: 
                return CategoriaLeche.class;
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
    
    public void setDatos(List<Vaca> lista){
        Vacas = lista;
    }
    
    public Vaca getVaca(int row){
        return Vacas.get(row);
    } 
}