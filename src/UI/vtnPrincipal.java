/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JOptionPane;

/**
 *
 * @author labctr
 */
public class vtnPrincipal extends javax.swing.JFrame {

    public static void verMensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
    }

    public vtnPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        mnbMatricula = new javax.swing.JMenuBar();
        mnuMatricula = new javax.swing.JMenu();
        mniNueva = new javax.swing.JMenuItem();
        mniCalificar = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();
        mnuEstudiante = new javax.swing.JMenu();
        mniNuevo = new javax.swing.JMenuItem();
        mniReporte = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuMatricula.setMnemonic('f');
        mnuMatricula.setText("Matricula");

        mniNueva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniNueva.setMnemonic('o');
        mniNueva.setText("Nueva");
        mniNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNuevaActionPerformed(evt);
            }
        });
        mnuMatricula.add(mniNueva);

        mniCalificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniCalificar.setMnemonic('s');
        mniCalificar.setText("Calificar");
        mniCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCalificarActionPerformed(evt);
            }
        });
        mnuMatricula.add(mniCalificar);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        mnuMatricula.add(saveAsMenuItem);

        mniSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniSalir.setMnemonic('x');
        mniSalir.setText("Salir");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        mnuMatricula.add(mniSalir);

        mnbMatricula.add(mnuMatricula);

        mnuEstudiante.setMnemonic('e');
        mnuEstudiante.setText("Estudiante");

        mniNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mniNuevo.setMnemonic('t');
        mniNuevo.setText("Nuevo");
        mniNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNuevoActionPerformed(evt);
            }
        });
        mnuEstudiante.add(mniNuevo);

        mniReporte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniReporte.setMnemonic('r');
        mniReporte.setText("Reporte");
        mniReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniReporteActionPerformed(evt);
            }
        });
        mnuEstudiante.add(mniReporte);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        mnuEstudiante.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        mnuEstudiante.add(deleteMenuItem);

        mnbMatricula.add(mnuEstudiante);

        setJMenuBar(mnbMatricula);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSalirActionPerformed

    private void mniNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNuevaActionPerformed
        frmRegistroMatricula miFrmMatricula = new frmRegistroMatricula();
        this.desktopPane.add(miFrmMatricula);
        miFrmMatricula.show();
    }//GEN-LAST:event_mniNuevaActionPerformed

    private void mniCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCalificarActionPerformed
        frmRegistroCalificaciones miFrmCalificacion = new frmRegistroCalificaciones();
        this.desktopPane.add(miFrmCalificacion);
        miFrmCalificacion.show();
    }//GEN-LAST:event_mniCalificarActionPerformed

    private void mniNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNuevoActionPerformed
        frmRegistroEstudiante miFrmEstudiante = new frmRegistroEstudiante();
        this.desktopPane.add(miFrmEstudiante);
        miFrmEstudiante.show();
    }//GEN-LAST:event_mniNuevoActionPerformed

    private void mniReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniReporteActionPerformed
        frmReporteCalificaciones miFrmCalificaciones = new frmReporteCalificaciones();
        this.desktopPane.add(miFrmCalificaciones);
        miFrmCalificaciones.show();
    }//GEN-LAST:event_mniReporteActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vtnPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar mnbMatricula;
    private javax.swing.JMenuItem mniCalificar;
    private javax.swing.JMenuItem mniNueva;
    private javax.swing.JMenuItem mniNuevo;
    private javax.swing.JMenuItem mniReporte;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenu mnuEstudiante;
    private javax.swing.JMenu mnuMatricula;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables

}
