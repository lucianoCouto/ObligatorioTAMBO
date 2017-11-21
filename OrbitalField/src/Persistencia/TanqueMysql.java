/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Servicios.IObjetoCRUD;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class TanqueMysql extends MySql implements IObjetoCRUD{

    @Override
    public void guardar(Object o) throws SQLException {
        throw new UnsupportedOperationException("No implementado"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Object o) {
        throw new UnsupportedOperationException("No implementado."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object o) {
        throw new UnsupportedOperationException("No implementado."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
