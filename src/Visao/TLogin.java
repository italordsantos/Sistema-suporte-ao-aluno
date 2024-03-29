/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Gerenciamento;
import DAO.LoginDAO;
import DAO.UsuarioDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Ítalo
 */
public class TLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    Gerenciamento c;
    LoginDAO loginDAO;
    UsuarioDAO usuarioDAO;

    public void setControle(Gerenciamento g) {
        c = g;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlbEsqueciMinhaSenha = new javax.swing.JLabel();
        btnAcessar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jlbEsqueciMeuUsuario = new javax.swing.JLabel();
        jlbCriarUmLogin = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Lock128x128.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jlbEsqueciMinhaSenha.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jlbEsqueciMinhaSenha.setForeground(new java.awt.Color(0, 0, 255));
        jlbEsqueciMinhaSenha.setText("Esqueci minha senha");
        jlbEsqueciMinhaSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbEsqueciMinhaSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbEsqueciMinhaSenhaMouseClicked(evt);
            }
        });

        btnAcessar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Accept32x32.png"))); // NOI18N
        btnAcessar.setText("Acessar");
        btnAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Deny32x32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Usuário:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Senha:");

        jtfUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/Key2_48x48.png"))); // NOI18N
        jLabel3.setText("Bem-Vindo ao Sistema de Suporte ao Aluno");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jpfSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpfSenhaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpfSenhaKeyTyped(evt);
            }
        });

        jlbEsqueciMeuUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jlbEsqueciMeuUsuario.setForeground(new java.awt.Color(0, 0, 255));
        jlbEsqueciMeuUsuario.setText("Esqueci meu usuário");
        jlbEsqueciMeuUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbEsqueciMeuUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbEsqueciMeuUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbEsqueciMeuUsuarioMouseEntered(evt);
            }
        });

        jlbCriarUmLogin.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jlbCriarUmLogin.setForeground(new java.awt.Color(0, 0, 255));
        jlbCriarUmLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCriarUmLogin.setText("Ainda não possuo um login no sistema");
        jlbCriarUmLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbCriarUmLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCriarUmLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbEsqueciMinhaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addGap(25, 25, 25)
                                .addComponent(jlbEsqueciMeuUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                            .addComponent(jpfSenha)
                            .addComponent(jtfUsuario)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(196, 196, 196))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(188, 188, 188)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbCriarUmLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAcessar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbEsqueciMinhaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbEsqueciMeuUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCriarUmLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAcessar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarActionPerformed
        String sUsuarioDigitado = jtfUsuario.getText(), sSenhaDigitada = String.valueOf(jpfSenha.getPassword());
        loginDAO = new LoginDAO();
        usuarioDAO = new UsuarioDAO();
        loginDAO.setControle(c);
        usuarioDAO.setControle(c);
        if (sUsuarioDigitado.trim().isEmpty() || sSenhaDigitada.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar em branco");

        } else if (/*loginDAO.bValidarAcesso(sUsuarioDigitado, sSenhaDigitada)*/ true) {
            c.vAbrirTelaPrincipal(0, -1);

        } else {
            System.out.println(sSenhaDigitada);
            JOptionPane.showMessageDialog(null, "Usuário/senha incorreto(s)");
        }
    }//GEN-LAST:event_btnAcessarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        c.vEncerrarSistema();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String sTeste1 = "batata,asd,123",
                st[] = sTeste1.split(",");
        for (String st1 : st) {
            System.out.println(st1);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        c.vEncerrarSistema();
    }//GEN-LAST:event_formWindowClosing

    private void jpfSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfSenhaKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAcessarActionPerformed(null);
        }

    }//GEN-LAST:event_jpfSenhaKeyReleased

    private void jtfUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_jtfUsuarioKeyReleased

    private void jtfUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jtfUsuarioKeyTyped

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jlbEsqueciMinhaSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbEsqueciMinhaSenhaMouseClicked
        // TODO add your handling code here:
        String sUsuarioDigitadoJOP = jtfUsuario.getText();
        c.vEsqueciSenha(sUsuarioDigitadoJOP);
    }//GEN-LAST:event_jlbEsqueciMinhaSenhaMouseClicked

    private void jlbEsqueciMeuUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbEsqueciMeuUsuarioMouseClicked
        // TODO add your handling code here:
        c.vEsqueciUsuario();
    }//GEN-LAST:event_jlbEsqueciMeuUsuarioMouseClicked

    private void jlbCriarUmLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCriarUmLoginMouseClicked
        // TODO add your handling code here:
        c.vCriarUmLogin();
    }//GEN-LAST:event_jlbCriarUmLoginMouseClicked

    private void jpfSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfSenhaKeyTyped

    }//GEN-LAST:event_jpfSenhaKeyTyped

    private void jlbEsqueciMeuUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbEsqueciMeuUsuarioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbEsqueciMeuUsuarioMouseEntered

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(TLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbCriarUmLogin;
    private javax.swing.JLabel jlbEsqueciMeuUsuario;
    private javax.swing.JLabel jlbEsqueciMinhaSenha;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
