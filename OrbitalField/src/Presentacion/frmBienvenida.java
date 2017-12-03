/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Empresa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luciano
 */
public class frmBienvenida extends javax.swing.JFrame {

    Empresa empresa;
    static frmBienvenida instancia;
    /**
     * Creates new form frmBienvenida
     */
    public frmBienvenida(Empresa e) {
        initComponents();
        empresa = e;
        this.lblUsuario.setText(empresa.usuarioIniciado.getTipo());
    }
    
    public static frmBienvenida getInstancia(Empresa e) throws SQLException{
        if(instancia == null){
            instancia = new frmBienvenida(e);
        }
        return instancia;
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
        lblUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnABMCliente = new javax.swing.JMenuItem();
        btnABMVaca = new javax.swing.JMenuItem();
        btnABMUsuario = new javax.swing.JMenuItem();
        btnABMTanque = new javax.swing.JMenuItem();
        btnVenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Bienvenido, has ingresado como");

        lblUsuario.setText("[Usuario]");

        jLabel3.setText("recuerda tus permisos");

        jMenu1.setText("Administracion");

        btnABMCliente.setText("Cliente");
        btnABMCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnABMClienteActionPerformed(evt);
            }
        });
        jMenu1.add(btnABMCliente);

        btnABMVaca.setText("Vaca");
        btnABMVaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnABMVacaActionPerformed(evt);
            }
        });
        jMenu1.add(btnABMVaca);

        btnABMUsuario.setText("Usuario");
        btnABMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnABMUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(btnABMUsuario);

        btnABMTanque.setText("Tanque");
        btnABMTanque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnABMTanqueActionPerformed(evt);
            }
        });
        jMenu1.add(btnABMTanque);

        btnVenta.setText("Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        jMenu1.add(btnVenta);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuario)
                    .addComponent(jLabel3))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnABMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnABMUsuarioActionPerformed
        frmABMUsuario frmU;
        try {
            frmU = frmABMUsuario.getInstancia(empresa);
            frmU.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnABMUsuarioActionPerformed

    private void btnABMClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnABMClienteActionPerformed
        frmABMCliente frmC;
        try {
            frmC = frmABMCliente.getInstancia(empresa);
            frmC.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnABMClienteActionPerformed

    private void btnABMVacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnABMVacaActionPerformed
        frmABMVaca frmV;
        try {
            frmV = frmABMVaca.getInstancia(empresa);
            frmV.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnABMVacaActionPerformed

    private void btnABMTanqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnABMTanqueActionPerformed
        frmABMTanque frmT;
        try {
            frmT = frmABMTanque.getInstancia(empresa);
            frmT.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnABMTanqueActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        frmVenta frmV;
        try {
            frmV = frmVenta.getInstancia(empresa);
            frmV.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVentaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnABMCliente;
    private javax.swing.JMenuItem btnABMTanque;
    private javax.swing.JMenuItem btnABMUsuario;
    private javax.swing.JMenuItem btnABMVaca;
    private javax.swing.JMenuItem btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
