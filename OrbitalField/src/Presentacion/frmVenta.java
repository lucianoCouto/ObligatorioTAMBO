/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Empresa;
import Dominio.LineaDeVenta;
import Dominio.Tanque;
import Dominio.Venta;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Luciano
 */
public class frmVenta extends javax.swing.JFrame {

    Empresa empresa;
    static frmVenta instancia;
    LineaDeVenta linea;
    private final ModeloTblLineas modeloTblLineas;
    private final ListSelectionModel lsmLineas;
    Venta venta = new Venta();

    public frmVenta(Empresa e) throws SQLException {
        initComponents();
        empresa = e;

        modeloTblLineas = new ModeloTblLineas();
        this.tblLineas.setModel(modeloTblLineas);
        rellenarComboBox();
        venta.setIdVenta(empresa.buscarUltimoIdVenta());
        this.listarLineasDeVenta(venta.getIdVenta());
        lsmLineas = tblLineas.getSelectionModel();
        lsmLineas.addListSelectionListener(new frmVenta.ListenerLineas());
        tblLineas.setSelectionModel(lsmLineas);
    }

    public static frmVenta getInstancia(Empresa e) throws SQLException {
        if (instancia == null) {
            instancia = new frmVenta(e);
        }
        return instancia;
    }

    private void listarLineasDeVenta(int idVenta) throws SQLException {
        modeloTblLineas.setDatos(empresa.listarLineasDeVenta(idVenta));
        modeloTblLineas.fireTableDataChanged();
    }

    private class ListenerLineas implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            int select = tblLineas.getSelectedRow();
            if (select != -1) {
                linea = modeloTblLineas.getLinea(select);
                txtCantidadDeLitros.setText(String.valueOf(linea.getCantidadDeLitros()));
            }
        }
    }

    private void rellenarComboBox() {
        List<Tanque> tanques = empresa.listarTanques();
        cmbTanques.removeAllItems();
        for (int i = 0; i < tanques.size(); i++) {
            Tanque t = tanques.get(i);
            cmbTanques.addItem(t.toString());
        }
        this.cmbTanques.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        cmbTanques = new javax.swing.JComboBox<>();
        txtCantidadDeLitros = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLineas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregarLinea = new javax.swing.JButton();
        btnAltaVenta = new javax.swing.JButton();
        lblMensajeVenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbTanques.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("VENTA");

        tblLineas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblLineas);

        jLabel2.setText("Tanque");

        jLabel4.setText("Litros de leche");

        btnAgregarLinea.setText("Agregar");
        btnAgregarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLineaActionPerformed(evt);
            }
        });

        btnAltaVenta.setText("Confirmar compra");
        btnAltaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaVentaActionPerformed(evt);
            }
        });

        lblMensajeVenta.setText("[Mensaje]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAltaVenta)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidadDeLitros)
                                    .addComponent(cmbTanques, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)))
                            .addComponent(btnAgregarLinea))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblMensajeVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadDeLitros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTanques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarLinea)
                        .addGap(32, 32, 32))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(btnAltaVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblMensajeVenta)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLineaActionPerformed
        
    }//GEN-LAST:event_btnAgregarLineaActionPerformed

    private void btnAltaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaVentaActionPerformed
        JFrame frame = new JFrame("Introduce el rut del cliente.");
        String rut = JOptionPane.showInputDialog(frame, "Introduzca el rut del cliente.", "Cliente.", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnAltaVentaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLinea;
    private javax.swing.JButton btnAltaVenta;
    private javax.swing.JComboBox<String> cmbTanques;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensajeVenta;
    private javax.swing.JTable tblLineas;
    private javax.swing.JTextField txtCantidadDeLitros;
    // End of variables declaration//GEN-END:variables
}
