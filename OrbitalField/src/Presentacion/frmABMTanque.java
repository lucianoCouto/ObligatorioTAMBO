/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CategoriaLeche;
import Dominio.Empresa;
import Dominio.Tanque;
import java.sql.SQLException;
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
public class frmABMTanque extends javax.swing.JFrame {

    Empresa empresa;
    static frmABMTanque instancia;
    Tanque tanque;
    private final ModeloTblTanque modeloTblTanque;
    private final ListSelectionModel lsmTanques;
    
    public frmABMTanque(Empresa e) throws SQLException {
        initComponents();
        empresa = e;

        modeloTblTanque = new ModeloTblTanque();
        this.tblTanques.setModel(modeloTblTanque);
        this.listarTanques();
        this.rellenarComboBox();
        lsmTanques = tblTanques.getSelectionModel();
        lsmTanques.addListSelectionListener(new frmABMTanque.ListenerTanques());
        tblTanques.setSelectionModel(lsmTanques);
    }
    private void listarTanques() throws SQLException {
        modeloTblTanque.setDatos(empresa.listarTanques());
        modeloTblTanque.fireTableDataChanged();
    }
    private class ListenerTanques implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int select = tblTanques.getSelectedRow();
            if (select != -1) {
                tanque = modeloTblTanque.getTanque(select);
                txtNumeroTanque.setText(String.valueOf(tanque.getNumero()));
                txtCantidadLitros.setText(String.valueOf(tanque.getCantLitros()));
                txtTopeDeLitros.setText(String.valueOf(tanque.getTopeDeLitros()));
            }
        }
    }

    public static frmABMTanque getInstancia(Empresa e) throws SQLException {
        if (instancia == null) {
            instancia = new frmABMTanque(e);
        }
        return instancia;
    }

    public void limpiar() {
        this.txtNumeroTanque.setText("");
        this.txtCantidadLitros.setText("");
        this.txtTopeDeLitros.setText("");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidadLitros = new javax.swing.JTextField();
        txtTopeDeLitros = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnGuardarTanque = new javax.swing.JButton();
        btnModificarTanque = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTanques = new javax.swing.JTable();
        btnEliminarTanque = new javax.swing.JButton();
        cmbCategoriaLeche = new javax.swing.JComboBox<>();
        txtNumeroTanque = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero Tanque");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("CLIENTES");

        jLabel2.setText("Stock en Litros");

        jLabel3.setText("Tope de Litros");

        btnGuardarTanque.setText("Guardar");
        btnGuardarTanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTanqueActionPerformed(evt);
            }
        });

        btnModificarTanque.setText("Modificar");
        btnModificarTanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTanqueActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblTanques.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblTanques);

        btnEliminarTanque.setText("Eliminar");
        btnEliminarTanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTanqueActionPerformed(evt);
            }
        });

        cmbCategoriaLeche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNumeroTanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroTanqueActionPerformed(evt);
            }
        });

        jLabel4.setText("Categoria Leche");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGuardarTanque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarTanque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbCategoriaLeche, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroTanque, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadLitros, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTopeDeLitros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)))
                    .addComponent(btnEliminarTanque, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroTanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadLitros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTopeDeLitros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoriaLeche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarTanque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarTanque)
                .addGap(9, 9, 9)
                .addComponent(btnEliminarTanque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarTanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTanqueActionPerformed
        Tanque t = new Tanque();
        t.setNumero(Integer.parseInt(this.txtNumeroTanque.getText()));
        t.setCantLitros(Integer.parseInt(this.txtCantidadLitros.getText()));
        t.setTopeDeLitros(Integer.parseInt(this.txtTopeDeLitros.getText()));
        t.setCategoria(empresa.buscarCategoriaXTipo(this.cmbCategoriaLeche.getSelectedItem().toString()));
        try {
            empresa.guardarTanque(t);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMTanque.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarTanques();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMTanque.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnGuardarTanqueActionPerformed

    private void btnModificarTanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTanqueActionPerformed
        Tanque t = new Tanque();
        t.setNumero(Integer.parseInt(this.txtNumeroTanque.getText()));
        t.setCantLitros(Integer.parseInt(this.txtCantidadLitros.getText()));
        t.setTopeDeLitros(Integer.parseInt(this.txtTopeDeLitros.getText()));
        t.setCategoria(empresa.buscarCategoriaXTipo(this.cmbCategoriaLeche.getSelectedItem().toString()));
        try {
            empresa.eliminarTanque(t);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarTanques();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMTanque.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnModificarTanqueActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarTanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTanqueActionPerformed
        try {
            empresa.eliminarTanque(this.tanque);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMTanque.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarTanques();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMTanque.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnEliminarTanqueActionPerformed

    private void txtNumeroTanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroTanqueActionPerformed

    }//GEN-LAST:event_txtNumeroTanqueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarTanque;
    private javax.swing.JButton btnGuardarTanque;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarTanque;
    private javax.swing.JComboBox<String> cmbCategoriaLeche;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTanques;
    private javax.swing.JTextField txtCantidadLitros;
    private javax.swing.JTextField txtNumeroTanque;
    private javax.swing.JTextField txtTopeDeLitros;
    // End of variables declaration//GEN-END:variables
}
