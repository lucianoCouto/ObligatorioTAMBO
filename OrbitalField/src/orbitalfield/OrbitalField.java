/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbitalfield;

import Dominio.Empresa;
import Presentacion.frmInicio;

/**
 *
 * @author Luciano
 */
public class OrbitalField {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa e = new Empresa();
        frmInicio inicio = new frmInicio(e);
        inicio.setVisible(true);
    }
    
}
