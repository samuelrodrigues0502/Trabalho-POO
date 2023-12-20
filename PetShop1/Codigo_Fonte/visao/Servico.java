/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package visao;

import service.ServicoService;
import visao.servServico.InsertServico;
import visao.servServico.AlteraServico;
import visao.servServico.RemoveServico;

/**
 *
 * @author Samuel
 */
public class Servico extends javax.swing.JDialog {

    private ServicoService servServ;

    /**
     * Creates new form Servico
     */
    public Servico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        servServ = new ServicoService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RemoverServico = new javax.swing.JButton();
        AlterarServico = new javax.swing.JButton();
        InserirServico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de serviço", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Malgun Gothic", 1, 18)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1))); // NOI18N
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        RemoverServico.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        RemoverServico.setText("Remover serviço");
        RemoverServico.setToolTipText("");
        RemoverServico.setAlignmentY(0.0F);
        RemoverServico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RemoverServico.setFocusable(false);
        RemoverServico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RemoverServico.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        RemoverServico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RemoverServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverServicoActionPerformed(evt);
            }
        });

        AlterarServico.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        AlterarServico.setText("Alterar serviço");
        AlterarServico.setToolTipText("");
        AlterarServico.setAlignmentY(0.0F);
        AlterarServico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AlterarServico.setFocusable(false);
        AlterarServico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AlterarServico.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AlterarServico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AlterarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarServicoActionPerformed(evt);
            }
        });

        InserirServico.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        InserirServico.setText("Inserir serviço");
        InserirServico.setToolTipText("");
        InserirServico.setAlignmentY(0.0F);
        InserirServico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InserirServico.setFocusable(false);
        InserirServico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InserirServico.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        InserirServico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        InserirServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InserirServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RemoverServico, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(AlterarServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(InserirServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(RemoverServico)
                .addGap(18, 18, 18)
                .addComponent(AlterarServico)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InserirServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirServicoActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
                dispose();//mata a janela
                InsertServico dialog = new InsertServico(new javax.swing.JFrame(), true, servServ);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();//mata a janela

                    }
                });
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_InserirServicoActionPerformed

    private void RemoverServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverServicoActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
                dispose();//mata a janela
                RemoveServico dialog = new RemoveServico(new javax.swing.JFrame(), true, servServ);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();//mata a janela
                    }
                });
                dialog.setVisible(true);
            }
        });

    }//GEN-LAST:event_RemoverServicoActionPerformed

    private void AlterarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarServicoActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
                dispose();//mata a janela
                AlteraServico dialog = new AlteraServico(new javax.swing.JFrame(), true, servServ);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.setVisible(false);
                        dialog.dispose();//mata a janela
                    }
                });
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_AlterarServicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarServico;
    private javax.swing.JButton InserirServico;
    private javax.swing.JButton RemoverServico;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
