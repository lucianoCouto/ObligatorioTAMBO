package Presentacion;

import Dominio.Empresa;
import Dominio.Vaca;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class frmDetalleVaca extends javax.swing.JFrame {

    Empresa empresa;
    private static frmDetalleVaca instancia;
    static Vaca vaca;
    
    
    public frmDetalleVaca(Empresa e , Vaca v) {
        initComponents();
        empresa = e;
        vaca = v;
        cargarDatos();
    }

    public static frmDetalleVaca getInstancia(Empresa e, Vaca v) throws SQLException {
        if (instancia == null) {
            instancia = new frmDetalleVaca(e, v);
        }
        return instancia;
    }

    private void cargarDatos() {
        this.lblCaravana.setText(String.valueOf(vaca.getCodigoVaca()));
        this.lblCategoria.setText(vaca.getCategoriaDeLeche().toString());
        this.lblFecha.setText(vaca.getFechaDeNacimiento());
        this.lblPeso.setText(String.valueOf(vaca.getPeso()));
        this.lblRaza.setText(vaca.getRaza());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCaravana = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblRaza = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Detalle vaca");

        jLabel2.setText("Caravana:");

        lblCaravana.setText("[19]");

        jLabel3.setText("Raza:");

        jLabel4.setText("Peso: ");

        jLabel5.setText("Fecha de nacimiento:");

        jLabel6.setText("Categoria de Leche:");

        lblFecha.setText("[1/12/1999]");

        lblRaza.setText("[Hereford]");

        lblPeso.setText("[200]");

        lblCategoria.setText("[B]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCategoria))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPeso)
                            .addComponent(lblRaza)
                            .addComponent(lblCaravana)
                            .addComponent(lblFecha))))
                .addContainerGap(481, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblCaravana))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblRaza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPeso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblCategoria))
                .addGap(0, 109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCaravana;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblRaza;
    // End of variables declaration//GEN-END:variables
}
