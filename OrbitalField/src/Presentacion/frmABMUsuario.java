/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Empresa;
import Dominio.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Luciano
 */
public class frmABMUsuario extends javax.swing.JFrame {

    Empresa empresa;
    static frmABMUsuario instancia;
    Usuario usuario;
    private final ModeloTblUsuario modeloTblUsuario;
    private final ListSelectionModel lsmUsuarios;

    public frmABMUsuario(Empresa e) throws SQLException {
        initComponents();
        empresa = e;

        modeloTblUsuario = new ModeloTblUsuario();
        this.tblUsuario.setModel(modeloTblUsuario);
        rellenarComboBox();
        this.listarUsuarios();
        lsmUsuarios = tblUsuario.getSelectionModel();
        lsmUsuarios.addListSelectionListener(new ListenerUsuario());
        tblUsuario.setSelectionModel(lsmUsuarios);
    }

    public static frmABMUsuario getInstancia(Empresa e) throws SQLException {
        if (instancia == null) {
            instancia = new frmABMUsuario(e);
        }
        return instancia;
    }

    private void listarUsuarios() throws SQLException {
        if ("master".equals(empresa.usuarioIniciado.getTipo())) {
            modeloTblUsuario.setDatos(empresa.listarUsuariosParaMaster());
            modeloTblUsuario.fireTableDataChanged();

        } else if ("administrador".equals(empresa.usuarioIniciado.getTipo())) {
            modeloTblUsuario.setDatos(empresa.listarUsuariosParaAdmin());
            modeloTblUsuario.fireTableDataChanged();
        }

    }

    private class ListenerUsuario implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int select = tblUsuario.getSelectedRow();
            if (select != -1) {
                usuario = modeloTblUsuario.getUsuario(select);
                txtNombre.setText(usuario.getNombre());
                txtUsuario.setText(usuario.getNombreDeUsuario());
            }
        }
    }

    public void limpiar() {
        this.txtNombre.setText("");
        this.txtUsuario.setText("");
        this.txtContrasena.setText("");
        this.cmbTipo.getItemAt(0);
    }

    private void rellenarComboBox() {
        cmbTipo.removeAllItems();

        if ("master".equals(empresa.usuarioIniciado.getTipo())) {
            cmbTipo.addItem("administrador");
            cmbTipo.addItem("Encargado de Planta");

        } else if ("administrador".equals(empresa.usuarioIniciado.getTipo())) {
            cmbTipo.addItem("Encargado de Planta");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnGuardarCliente = new javax.swing.JButton();
        btnModificarCliente = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnEliminarCliente = new javax.swing.JButton();
        cmbTipo = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Contraseña");

        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnModificarCliente.setText("Modificar");
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblUsuario);

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo");

        jLabel1.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("USUARIOS");

        jLabel2.setText("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnGuardarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTipo, 0, 119, Short.MAX_VALUE)
                            .addComponent(txtContrasena)
                            .addComponent(txtUsuario)
                            .addComponent(txtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addComponent(btnGuardarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarCliente)
                .addGap(9, 9, 9)
                .addComponent(btnEliminarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        Usuario u = new Usuario();
        u.setNombre(this.txtNombre.getText());
        u.setNombreDeUsuario(this.txtUsuario.getText());
        char[] contrasena = this.txtContrasena.getPassword();
        u.setContrasena(String.valueOf(contrasena));
        u.setTipo(String.valueOf(this.cmbTipo.getSelectedItem()));
        try {
            empresa.guardarUsuario(u);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed
        Usuario u = new Usuario();
        u.setIdUsuario(usuario.getIdUsuario());
        u.setNombre(this.txtNombre.getText());
        u.setNombreDeUsuario(this.txtUsuario.getText());
        char[] contrasena = this.txtContrasena.getPassword();
        u.setContrasena(String.valueOf(contrasena));
        u.setTipo(String.valueOf(this.cmbTipo.getSelectedItem()));

        try {
            empresa.modificarUsuario(u);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        try {
            empresa.eliminarUsuario(this.usuario);
        } catch (SQLException ex) {
            Logger.getLogger(frmABMUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.listarUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(frmABMUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.limpiar();
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
