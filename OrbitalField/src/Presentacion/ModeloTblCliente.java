/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luciano
 */
public class ModeloTblCliente extends AbstractTableModel{

    //Utilizamos Modelos para poder cargar datos a JTable, personalizando los datos que se muestran
    
    private static final int CANT_COLS = 4;
    private static final String [] NOM_COLS = {"Nombre", "Razon Social", "Rut", "Ciudad"};
    private List<Cliente> Clientes;
    
    @Override
    public int getRowCount() {
        return Clientes.size();
    }

    @Override
    public int getColumnCount() {
        return CANT_COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = Clientes.get(rowIndex);
        switch (columnIndex){
            case 0:
                return cliente.getNombreCliente();
            case 1:
                return cliente.getRazonSocial();
            case 2:
                return cliente.getRut();
            case 3:
                return cliente.getCiudad();
        }
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
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
    
    public void setDatos(List<Cliente> lista){
        Clientes = lista;
    }
    
    public Cliente getCliente(int row){
        return Clientes.get(row);
    } 
}
