/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Gerenciamento;
import DAO.NucleoDAO;
import Modelo.MNucleo;
import javax.swing.DefaultListModel;

/**
 *
 * @author italo
 */
public class TCadastrarEditarNucleo extends javax.swing.JFrame {

    /**
     * Creates new form TRedefinirLogin
     */
    public TCadastrarEditarNucleo() {
        initComponents();
        jlNucleos.setModel(new DefaultListModel<>());
    }

    Gerenciamento c;
    MNucleo mNucleo;
    NucleoDAO ndao;
    boolean bInserirOsDadosNaTela = true;
    int iCadastrarOuEditar;

    public void setControle(Gerenciamento cg) {
        c = cg;
    }

    public void setCadastrarOuEditar(int i) {
        iCadastrarOuEditar = i;
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
        jLabel1 = new javax.swing.JLabel();
        jtfNucleo = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jlbCadastrarEditar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlNucleos = new javax.swing.JList<>();
        jlbPermissoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nome do núcleo:");

        jtfNucleo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfNucleo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNucleoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNucleoKeyTyped(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        jlbCadastrarEditar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlbCadastrarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Add32x32.png"))); // NOI18N
        jlbCadastrarEditar.setText("Cadastrar");
        jlbCadastrarEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCadastrarEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbCadastrarEditarMouseEntered(evt);
            }
        });
        jToolBar1.add(jlbCadastrarEditar);

        jlNucleos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlNucleos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "item1", "item2", "item3", "item4" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlNucleos.setToolTipText("Obs: pressione Ctrl para selecionar mais de um núcleo");
        jScrollPane1.setViewportView(jlNucleos);

        jlbPermissoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbPermissoes.setText("Selecione os núcleo que terá acesso as informações:");
        jlbPermissoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbPermissoesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbPermissoes)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNucleo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNucleo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jlbPermissoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        c.vAbrirTelaPrincipal(7, -1);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        c.inicializaTela(iCadastrarOuEditar, (DefaultListModel) jlNucleos.getModel(), jlbCadastrarEditar.getIcon());
    }//GEN-LAST:event_formWindowActivated

    private void jlbCadastrarEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCadastrarEditarMouseClicked
        // TODO add your handling code here:
        /*mNucleo = new MNucleo();
        String sNomeDigitado = jtfNucleo.getText(),
                sNucleos;
        sNucleos = ndao.convertToString(jlNucleos.getSelectedValuesList());
        mNucleo.setsPermissoesDeAcesso(sNucleos);
        System.out.println(sNucleos);
        mNucleo.setsNome(sNomeDigitado);
        c.bCadastrarNucleo(mNucleo, iCadastrarOuEditar);*/
        c.vAdicionarAPorraDoElemento((DefaultListModel) jlNucleos.getModel());
    }//GEN-LAST:event_jlbCadastrarEditarMouseClicked

    private void jlbPermissoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbPermissoesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbPermissoesMouseClicked

    private void jtfNucleoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNucleoKeyTyped
        // TODO add your handling code here:
        String letra = evt.getKeyChar() + "";
        if (c.bIsLetter(letra)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNucleoKeyTyped

    private void jtfNucleoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNucleoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNucleoKeyReleased

    private void jlbCadastrarEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCadastrarEditarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbCadastrarEditarMouseEntered

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TCadastrarEditarNucleo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TCadastrarEditarNucleo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList<String> jlNucleos;
    private javax.swing.JLabel jlbCadastrarEditar;
    private javax.swing.JLabel jlbPermissoes;
    private javax.swing.JTextField jtfNucleo;
    // End of variables declaration//GEN-END:variables
}