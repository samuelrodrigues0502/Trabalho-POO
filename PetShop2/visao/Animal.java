package visao;

import visao.servAnimal.InsertAnimal;
import visao.servAnimal.AlteraAnimal;
import visao.servAnimal.RemoveAnimal;
import service.AnimalService;

/**
 *
 * @author Samuel
 */
public class Animal extends javax.swing.JDialog {

    private AnimalService aniServ;

    /**
     * Creates new form Animal
     */
    public Animal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        aniServ = new AnimalService();

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
        InserirAnimal = new javax.swing.JButton();
        AlterarAnimal = new javax.swing.JButton();
        RemoverAnimal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de animal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Malgun Gothic", 1, 18)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1))); // NOI18N
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        InserirAnimal.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        InserirAnimal.setText("Inserir animal");
        InserirAnimal.setToolTipText("");
        InserirAnimal.setAlignmentY(0.0F);
        InserirAnimal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        InserirAnimal.setFocusable(false);
        InserirAnimal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        InserirAnimal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        InserirAnimal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        InserirAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirAnimalActionPerformed(evt);
            }
        });

        AlterarAnimal.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        AlterarAnimal.setText("Alterar animal");
        AlterarAnimal.setToolTipText("");
        AlterarAnimal.setAlignmentY(0.0F);
        AlterarAnimal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AlterarAnimal.setFocusable(false);
        AlterarAnimal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AlterarAnimal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AlterarAnimal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AlterarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarAnimalActionPerformed(evt);
            }
        });

        RemoverAnimal.setFont(new java.awt.Font("Malgun Gothic", 1, 12)); // NOI18N
        RemoverAnimal.setText("Remover animal");
        RemoverAnimal.setToolTipText("");
        RemoverAnimal.setAlignmentY(0.0F);
        RemoverAnimal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RemoverAnimal.setFocusable(false);
        RemoverAnimal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RemoverAnimal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        RemoverAnimal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RemoverAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverAnimalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AlterarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoverAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InserirAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(InserirAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RemoverAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(AlterarAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InserirAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirAnimalActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
                dispose();//mata a janela
                InsertAnimal dialog = new InsertAnimal(new javax.swing.JFrame(), true, aniServ);
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

    }//GEN-LAST:event_InserirAnimalActionPerformed

    private void AlterarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarAnimalActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
                dispose();//mata a janela
                AlteraAnimal dialog = new AlteraAnimal(new javax.swing.JFrame(), true, aniServ);
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

    }//GEN-LAST:event_AlterarAnimalActionPerformed

    private void RemoverAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverAnimalActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(false);
                dispose();//mata a janela
                RemoveAnimal dialog = new RemoveAnimal(new javax.swing.JFrame(), true, aniServ);
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
    }//GEN-LAST:event_RemoverAnimalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlterarAnimal;
    private javax.swing.JButton InserirAnimal;
    private javax.swing.JButton RemoverAnimal;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
