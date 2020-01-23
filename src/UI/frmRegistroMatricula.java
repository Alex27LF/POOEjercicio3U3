package UI;

import BEU.Curso;
import BEU.Estudiante;
import BLL.GestionCurso;
import BLL.GestionEstudiante;
import BLL.GestionMatricula;
import Pachacama.Util;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class frmRegistroMatricula extends javax.swing.JInternalFrame {

    private final String titulo = "Registro de Matrícula";
    //Servicio - Bll
    private GestionCurso cursoBll = new GestionCurso();
    private List<Curso> curso;
    private GestionEstudiante estudianteBll = new GestionEstudiante();
    private List<Estudiante> estudiante;
    private GestionMatricula matriculaBll = new GestionMatricula();

    private boolean validar() {
        Curso cr = (Curso) this.cmbCursos.getSelectedItem();
        Estudiante est = (Estudiante) this.cmbEstudiantes.getSelectedItem();
        if (cr.getTitulo().equals("-Seleccione-")) {
            vtnPrincipal.verMensaje("Curso no Valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (est.getNombre().equals("-Seleccione-")) {
            vtnPrincipal.verMensaje("Estudiante no Valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void leerCurso() {
        try {
            Curso ficticio = new Curso("-Seleccione-", 0.0f, "");
            this.cmbCursos.addItem(ficticio);
            curso = cursoBll.getCursos();
            //Expresion lambda  
            curso.forEach((c) -> {
                this.cmbCursos.addItem(c);
            });
        } catch (IOException e) {
            Util.imprimir("ERROR. " + e.toString());
            vtnPrincipal.verMensaje("Error al Cargar los Cursos", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void leerEstudiante() {
        try {
            Estudiante ficticio = new Estudiante();
            ficticio.setNombre("-Seleccione-");
            ficticio.setApellido("");
            this.cmbEstudiantes.addItem(ficticio);
            estudiante = estudianteBll.leerEstudiantes();
            //Expresion lambda  
            estudiante.forEach((est) -> {
                this.cmbEstudiantes.addItem(est);
            });
        } catch (IOException e) {
            Util.imprimir("ERROR. " + e.toString());
            vtnPrincipal.verMensaje("Error al Cargar los Estudiantes", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void crearMatricula() throws IOException {
        Curso cr = (Curso) this.cmbCursos.getSelectedItem();
        Estudiante est = (Estudiante) this.cmbEstudiantes.getSelectedItem();
        matriculaBll.crear();
        matriculaBll.configurar(cr, est);
        matriculaBll.archivar();
    }

    public frmRegistroMatricula() {
        initComponents();
        leerCurso();
        leerEstudiante();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegistroMatricula = new javax.swing.JPanel();
        lblEstudiante = new javax.swing.JLabel();
        cmbEstudiantes = new javax.swing.JComboBox<>();
        lblCurso = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Matrícula");

        pnlRegistroMatricula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro de Matrícula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Condensed", 3, 18))); // NOI18N

        lblEstudiante.setFont(new java.awt.Font("Ubuntu Condensed", 3, 15)); // NOI18N
        lblEstudiante.setText("Estudiante:");

        cmbEstudiantes.setFont(new java.awt.Font("Ubuntu Condensed", 3, 15)); // NOI18N

        lblCurso.setFont(new java.awt.Font("Ubuntu Condensed", 3, 15)); // NOI18N
        lblCurso.setText("Curso:");

        cmbCursos.setFont(new java.awt.Font("Ubuntu Condensed", 3, 15)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Ubuntu Condensed", 3, 15)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon("/home/labctr/Documentos/Programacion II/iconos/save.png")); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistroMatriculaLayout = new javax.swing.GroupLayout(pnlRegistroMatricula);
        pnlRegistroMatricula.setLayout(pnlRegistroMatriculaLayout);
        pnlRegistroMatriculaLayout.setHorizontalGroup(
            pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstudiante)
                            .addComponent(lblCurso))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCursos, 0, 272, Short.MAX_VALUE)
                            .addComponent(cmbEstudiantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroMatriculaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        pnlRegistroMatriculaLayout.setVerticalGroup(
            pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroMatriculaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstudiante)
                    .addComponent(cmbEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegistroMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlRegistroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlRegistroMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (validar()) {
                crearMatricula();
                vtnPrincipal.verMensaje("Matricula Guardada correctamente", titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Util.imprimir("ERROR. " + e.toString());
            vtnPrincipal.verMensaje("Error al Guardar la Matrícula", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Curso> cmbCursos;
    private javax.swing.JComboBox<Estudiante> cmbEstudiantes;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JPanel pnlRegistroMatricula;
    // End of variables declaration//GEN-END:variables
}
