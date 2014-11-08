/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import apresentacao.FormCadastroMateria;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import apresentacao.FormCadastroProfessor;
import apresentacao.FormSelectHorario;

/**
 *
 * @author matheus
 */
public class mainGui extends javax.swing.JFrame {

    /**
     * Creates new form mainGui
     */
    public mainGui() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNovoProfessor = new javax.swing.JButton();
        jButtonHorario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonUltimosHorarios = new javax.swing.JButton();
        jButtonNovaMateria = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JDesktopMDI = new javax.swing.JDesktopPane();
        jButtonSelectHoras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonNovoProfessor.setText("Professores");
        jButtonNovoProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoProfessorActionPerformed(evt);
            }
        });

        jButtonHorario.setText("Gerar Horario");
        jButtonHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHorarioActionPerformed(evt);
            }
        });

        jLabel1.setText("ÍCONE  © 2015");

        jButtonUltimosHorarios.setText("Horarios Antigos");
        jButtonUltimosHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimosHorariosActionPerformed(evt);
            }
        });

        jButtonNovaMateria.setText("Materias");
        jButtonNovaMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaMateriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Por Nome do Programa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel2)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButtonSelectHoras.setText("Selecionar Horas");
        jButtonSelectHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectHorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jButtonNovoProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNovaMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUltimosHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jButtonSelectHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addComponent(JDesktopMDI)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNovoProfessor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSelectHoras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonNovaMateria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonHorario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUltimosHorarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(JDesktopMDI))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void theButton() {
        JDesktopMDI.removeAll();
        JDesktopMDI.repaint();
        jButtonNovoProfessor.setEnabled(true);
        jButtonHorario.setEnabled(true);
        jButtonUltimosHorarios.setEnabled(true);
        jButtonNovaMateria.setEnabled(true);
        jButtonSelectHoras.setEnabled(true);

    }
    private void jButtonNovoProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoProfessorActionPerformed
        // TODO add your handling code here:
        theButton();
        FormCadastroProfessor newProf = null;
        theButton();
        try{
            newProf = new FormCadastroProfessor();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(mainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        newProf.setVisible(true);
        JDesktopMDI.add(newProf);
        try{
            newProf.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(mainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButtonNovoProfessor.setEnabled(false);

    }//GEN-LAST:event_jButtonNovoProfessorActionPerformed

    private void jButtonHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHorarioActionPerformed
        // TODO add your handling code here:
        theButton();
        jButtonHorario.setEnabled(false);
    }//GEN-LAST:event_jButtonHorarioActionPerformed

    private void jButtonUltimosHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimosHorariosActionPerformed
        // TODO add your handling code here:
        theButton();
        jButtonUltimosHorarios.setEnabled(false);
    }//GEN-LAST:event_jButtonUltimosHorariosActionPerformed

    private void jButtonNovaMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaMateriaActionPerformed
        // TODO add your handling code here:
        FormCadastroMateria newMateria = null ;
        theButton();
        try{
            newMateria = new FormCadastroMateria();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(mainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        newMateria.setVisible(true);
        jButtonNovaMateria.setEnabled(false);
        JDesktopMDI.add(newMateria);
        try{
            newMateria.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(mainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonNovaMateriaActionPerformed

    private void jButtonSelectHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectHorasActionPerformed
        // TODO add your handling code here:
        FormSelectHorario horas = null;
        theButton();
        horas = new FormSelectHorario();
        horas.setVisible(true);
        jButtonSelectHoras.setEnabled(false);
        JDesktopMDI.add(horas);
        try{
            horas.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(mainGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSelectHorasActionPerformed

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
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopMDI;
    private javax.swing.JButton jButtonHorario;
    private javax.swing.JButton jButtonNovaMateria;
    private javax.swing.JButton jButtonNovoProfessor;
    private javax.swing.JButton jButtonSelectHoras;
    private javax.swing.JButton jButtonUltimosHorarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
