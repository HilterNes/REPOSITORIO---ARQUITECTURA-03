/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

public class Claseingreso extends javax.swing.JFrame {

    Productocontado vistaContado;
    Productocredito vistaCredito;

    public Claseingreso() {
        initComponents();
        vistaContado = new Productocontado();
        vistaCredito = new Productocredito();
        setTitle("VENTA DE PRODUCTOS");
        setSize(480, 280);
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btn_creditos = new javax.swing.JButton();
        btn_contado = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("VENTA DE PRODUCTOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 471, 52));

        btn_creditos.setBackground(new java.awt.Color(51, 255, 204));
        btn_creditos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_creditos.setText("VENTA AL CREDITO");
        btn_creditos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_creditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_creditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 170, 40));

        btn_contado.setBackground(new java.awt.Color(51, 255, 204));
        btn_contado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_contado.setText("VENTA AL CONTADO");
        btn_contado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_contado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_contado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_contadoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_contado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 180, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("VENTA AL CREDITO");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("VENTA AL CONTADO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_creditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creditosActionPerformed
        btn_creditos.addActionListener(e -> {
        Productocredito credito = new Productocredito();
        credito.setVisible(true);
       });
    }//GEN-LAST:event_btn_creditosActionPerformed

    private void btn_contadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_contadoActionPerformed
        btn_contado.addActionListener(e -> {
        Productocontado contado = new Productocontado();
        contado.setVisible(true);
      });
    }//GEN-LAST:event_btn_contadoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Claseingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Claseingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Claseingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Claseingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Claseingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_contado;
    private javax.swing.JButton btn_creditos;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
