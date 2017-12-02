/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luciano
 */
public class ModeloTblUsuario extends AbstractTableModel{

    //Utilizamos Modelos para poder cargar datos a JTable, personalizando los datos que se muestran
    
    private static final int CANT_COLS = 3;
    private static final String [] NOM_COLS = {"Nombre", "Usuario", "tipo"};
    private List<Usuario> Usuarios;
    
    @Override
    public int getRowCount() {
        return Usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return CANT_COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = Usuarios.get(rowIndex);
        switch (columnIndex){
            case 0:
                return usuario.getNombre();
            case 1:
                return usuario.getNombreDeUsuario();
            case 2:
                return usuario.getTipo();
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
    
    public void setDatos(List<Usuario> lista){
        Usuarios = lista;
    }
    
    public Usuario getUsuario(int row){
        return Usuarios.get(row);
    } 
}
