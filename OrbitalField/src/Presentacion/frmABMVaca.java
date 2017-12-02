/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CategoriaLeche;
import Dominio.Cliente;
import Dominio.Empresa;
import Dominio.Vaca;
import static Presentacion.frmABMCliente.instancia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Gian
 */
public class frmABMVaca extends javax.swing.JFrame {

    Empresa empresa;
    static frmABMVaca instancia;
    Vaca vaca;
    private final ModeloTblVaca modeloTblVaca;
    private final ListSelectionModel lsmVacas;
    /**
     * Creates new form frmABMVaca
     * @param e
     * @throws java.sql.SQLException
     */
    public frmABMVaca(Empresa e) throws SQLException {
        initComponents();
        empresa = e;

        modeloTblVaca = new ModeloTblVaca();
        this.tblVacas.setModel(modeloTblVaca);
        this.listarVacas();
        this.rellenarComboBox();
        lsmVacas = tblVacas.getSelectionModel();
        lsmVacas.addListSelectionListener(new frmABMVaca.ListenerVacas());
        tblVacas.setSelectionModel(lsmVacas);
    }
    private void listarVacas() throws SQLException {
        modeloTblVaca.setDatos(empresa.listarVacas());
        modeloTblVaca.fireTableDataChanged();
    }
    private class ListenerVacas implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int select = tblVacas.getSelectedRow();
            if (select != -1) {
                vaca = modeloTblVaca.getVaca(select);
                txtCodigoVaca.setText(String.valueOf(vaca.getCodigoVaca()));
                txtRazaVaca.setText(vaca.getRaza());
                txtPesoVaca.setText(String.valueOf(vaca.getPeso()));
            }
        }
    }

    public static frmABMVaca getInstancia(Empresa e) throws SQLException {
        if (instancia == null) {
            instancia = new frmABMVaca(e);
        }
        return instancia;
    }

    public void limpiar() {
        this.txtCodigoVaca.setText("");
        this.txtPesoVaca.setText("");
        this.txtRazaVaca.setText("");
        this.cmbCategoriaLeche.getItemAt(0);
    }

    private void rellenarComboBox() {
        List<CategoriaLeche> categoria = empresa.listarCategoria();
        cmbCategoriaLeche.removeAllItems();
        for(int i=0;i<categoria.size();i++){
            CategoriaLeche c = categoria.get(i);
            cmbCategoriaLeche.addItem(c.getTipoCategoria());
        }
        this.cmbCategoriaLeche.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardarVaca = new javax.swing.JButton();
        btnModificarVaca = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVacas = new javax.swing.JTable();
        btnEliminarVaca = new javax.swing.JButton();
        cmbCategoriaLeche = new javax.swing.JComboBox<>();
        txtCodigoVaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRazaVaca = new javax.swing.JTextField();
        txtPesoVaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cldNacimientoVaca = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuardarVaca.setText("Guardar");
        btnGuardarVaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVacaActionPerformed(evt);
            }
        });

        btnModificarVaca.setText("Modificar");
        btnModificarVaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVacaActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblVacas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblVacas);

        btnEliminarVaca.setText("Eliminar");
        btnEliminarVaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVacaActionPerformed(evt);
            }
        });

        cmbCategoriaLeche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtCodigoVaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVacaActionPerformed(evt);
            }
        });

        jLabel4.setText("Categoria de Leche");

        jLabel1.setText("Codigo Vaca");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Vacas");

        jLabel2.setText("Raza");

        jLabel3.setText("Peso (kg)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbCategoriaLeche, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigoVaca, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRazaVaca, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPesoVaca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel5))
                        .addGap(0, 0, 0))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cldNacimientoVaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnGuardarVaca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarVaca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarVaca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(btnGuardarVaca)
                            .addComponent(btnModificarVaca)
                            .addComponent(btnEliminarVaca))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoVaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRazaVaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesoVaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCategoriaLeche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cldNacimientoVaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarVacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVacaActionPerformed
        Vaca v = new Vaca();
        v.setCodigoVaca(Integer.parseInt(this.txtCodigoVaca.getText()));
        v.setRaza(this.txtPesoVaca.getText());
        v.setPeso(Integer.parseInt(this.txtRazaVaca.getText()));
        v.setFechaDeNacimiento(this.cldNacimientoVaca.getDate());
        v.setCategoriaDeLeche(empresa.buscarCategoriaXTipo(this.cmbCategoriaLeche.getSelectedItem().toString()));
        try {
            empresa.guardarVaca(v);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMVaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarVacas();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMVaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnGuardarVacaActionPerformed

    private void btnModificarVacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVacaActionPerformed
        Vaca v = new Vaca();
        v.setCodigoVaca(Integer.parseInt(this.txtCodigoVaca.getText()));
        v.setRaza(this.txtPesoVaca.getText());
        v.setPeso(Integer.parseInt(this.txtRazaVaca.getText()));
        v.setFechaDeNacimiento(this.cldNacimientoVaca.getDate());
        v.setCategoriaDeLeche(empresa.buscarCategoriaXTipo(this.cmbCategoriaLeche.getSelectedItem().toString()));
        try {
            empresa.modificarVaca(v);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarVacas();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMVaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnModificarVacaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarVacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVacaActionPerformed
        try {
            empresa.eliminarVaca(this.vaca);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMVaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarVacas();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMVaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnEliminarVacaActionPerformed

    private void txtCodigoVacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVacaActionPerformed

    }//GEN-LAST:event_txtCodigoVacaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarVaca;
    private javax.swing.JButton btnGuardarVaca;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarVaca;
    private com.toedter.calendar.JCalendar cldNacimientoVaca;
    private javax.swing.JComboBox<String> cmbCategoriaLeche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVacas;
    private javax.swing.JTextField txtCodigoVaca;
    private javax.swing.JTextField txtPesoVaca;
    private javax.swing.JTextField txtRazaVaca;
    // End of variables declaration//GEN-END:variables
}
