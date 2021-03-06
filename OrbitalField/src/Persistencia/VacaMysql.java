/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Vaca;
import Servicios.IObjetoCRUD;
import Servicios.IVacaCRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class VacaMysql extends MySql implements IObjetoCRUD, IVacaCRUD {

    private final CategoriaMysql categoriaMysql = new CategoriaMysql();

    @Override
    public void guardar(Object o) throws SQLException {
        Vaca v = (Vaca) o;
        strSQL = "INSERT INTO vacas (codigo, raza, peso, fechaN, estaActiva, idCategoria) VALUES "
                + "('" + v.getCodigoVaca() + "', '" + v.getRaza() + "', '" + v.getPeso() + "', '" + v.getFechaDeNacimiento() + "', " + v.getEstaActiva() + ", '" + v.getCategoriaDeLeche().getIdCategoria() + "')";
        update(strSQL);
    }

    @Override
    public void modificar(Object o) {
        Vaca v = (Vaca) o;
        strSQL = "UPDATE vacas SET codigo = " + v.getCodigoVaca() + ", raza = '" + v.getRaza() + "', peso = " + v.getPeso() + ", fechaN = '" + v.getFechaDeNacimiento() + "', estaActiva = " + v.getEstaActiva() + " , idCategoria = " + v.getCategoriaDeLeche().getIdCategoria();
        update(strSQL);
    }

    @Override
    public void eliminar(Object o) {
        Vaca v = (Vaca) o;
        strSQL = "UPDATE vacas SET estaActiva = " + false + " WHERE idVaca = " + v.getIdVaca();
        update(strSQL);
    }

    @Override
    public List<Object> listar() {
        List<Object> objetos = new ArrayList<>();
        this.seleccionar("SELECT * FROM vacas WHERE estaActiva <>" + false);
        try {
            while (rs.next()) {
                Vaca v = new Vaca();
                v.setIdVaca(rs.getInt("idVaca"));
                v.setCodigoVaca(rs.getInt("codigo"));
                v.setRaza(rs.getString("raza"));
                v.setPeso(rs.getInt("peso"));
                v.setFechaDeNacimiento(rs.getString("fechaN"));
                v.setEstaActiva(rs.getBoolean("estaActiva"));
                v.setCategoriaDeLeche(categoriaMysql.buscar(rs.getInt("idCategoria")));
                objetos.add(v);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return objetos;
    }

    @Override
    public int pesoPromedioDeUltimas5VacasOrdeñadas(String tipoCategoria) {
        int pesoPromedio = 0;
        String cadena = "SELECT AVG(vacas.peso) as pesoPromedio FROM ordeñe, vacas, categorialeche WHERE ordeñe.idVaca = vacas.idVaca AND vacas.idCategoria = categorialeche.idCategoria AND categorialeche.tipoCategoria = '" + tipoCategoria + "' LIMIT 0,5 ";
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                pesoPromedio = rs.getInt("pesoPromedio");
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return pesoPromedio;
    }

    @Override
    public Vaca buscarVacaXCaravana(int caravana) {
        Vaca v = new Vaca();
        String cadena = "SELECT * FROM vacas WHERE codigo = " + caravana;
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                v.setIdVaca(rs.getInt("idVaca"));
                v.setCodigoVaca(rs.getInt("codigo"));
                v.setRaza(rs.getString("raza"));
                v.setPeso(rs.getInt("peso"));
                v.setFechaDeNacimiento(rs.getString("fechaN"));
                v.setEstaActiva(rs.getBoolean("estaActiva"));
                v.setCategoriaDeLeche(categoriaMysql.buscar(rs.getInt("idCategoria")));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return v;
    }

    @Override
    public List<Vaca> listarVacasFiltradas(String filtro) {
        List<Vaca> lasVacas = new ArrayList<>();
        String cadena = "SELECT * FROM vacas WHERE estaActiva <> 0 ORDER BY " + filtro;
        this.seleccionar(cadena);
        try {
            while (rs.next()) {
                Vaca v = new Vaca();
                v.setIdVaca(rs.getInt("idVaca"));
                v.setCodigoVaca(rs.getInt("codigo"));
                v.setRaza(rs.getString("raza"));
                v.setPeso(rs.getInt("peso"));
                v.setFechaDeNacimiento(rs.getString("fechaN"));
                v.setEstaActiva(rs.getBoolean("estaActiva"));
                v.setCategoriaDeLeche(categoriaMysql.buscar(rs.getInt("idCategoria")));
                lasVacas.add(v);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return lasVacas;
    }

}
