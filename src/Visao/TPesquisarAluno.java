/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Gerenciamento;
import DAO.AlunoDAO;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author italo
 */
public class TPesquisarAluno extends javax.swing.JFrame {

    /**
     * Creates new form TPesquisarConsulta
     */
    public TPesquisarAluno() {
        initComponents();
    }

    Gerenciamento c;
    int veioDeQualTela;

    public void setControle(Gerenciamento cp) {
        c = cp;
    }

    public void setVeioDeQualTela(int t) {
        veioDeQualTela = t;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgOrdenarNome = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jlbPesquisarPor = new javax.swing.JLabel();
        jlbNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jtfMatricula = new javax.swing.JTextField();
        jlbSiape = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jtbPesquisarAlunoConsulta = new javax.swing.JToolBar();
        jlbPesquisarNome = new javax.swing.JLabel();
        js1 = new javax.swing.JToolBar.Separator();
        jlbPesquisarPorMatricula = new javax.swing.JLabel();
        js2 = new javax.swing.JToolBar.Separator();
        jlbNovaConsulta = new javax.swing.JLabel();
        jtbPesquisarAlunoAluno = new javax.swing.JToolBar();
        js3 = new javax.swing.JToolBar.Separator();
        jlbEditarAluno = new javax.swing.JLabel();
        js4 = new javax.swing.JToolBar.Separator();
        jlbExcluirAluno = new javax.swing.JLabel();
        js5 = new javax.swing.JToolBar.Separator();
        jlbGerarFicha = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDadoAluno = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar aluno");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jlbPesquisarPor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlbPesquisarPor.setText("Pesquisar por:");

        jlbNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlbNome.setText("Nome:");

        jtfNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jtfMatricula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtfMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMatriculaActionPerformed(evt);
            }
        });
        jtfMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMatriculaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMatriculaKeyTyped(evt);
            }
        });

        jlbSiape.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jlbSiape.setText("Matrícula:");

        jToolBar2.setFloatable(false);
        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);

        jtbPesquisarAlunoConsulta.setFloatable(false);
        jtbPesquisarAlunoConsulta.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jtbPesquisarAlunoConsulta.setRollover(true);

        jlbPesquisarNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbPesquisarNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/user/User_Search32x32.png"))); // NOI18N
        jlbPesquisarNome.setText("Pesquisar por nome");
        jlbPesquisarNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbPesquisarNomeMouseClicked(evt);
            }
        });
        jtbPesquisarAlunoConsulta.add(jlbPesquisarNome);
        jtbPesquisarAlunoConsulta.add(js1);

        jlbPesquisarPorMatricula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbPesquisarPorMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/user/User_Search32x32.png"))); // NOI18N
        jlbPesquisarPorMatricula.setText("Pesquisar por matricula");
        jlbPesquisarPorMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbPesquisarPorMatriculaMouseClicked(evt);
            }
        });
        jtbPesquisarAlunoConsulta.add(jlbPesquisarPorMatricula);
        jtbPesquisarAlunoConsulta.add(js2);

        jlbNovaConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbNovaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/note/Note_Add32x32.png"))); // NOI18N
        jlbNovaConsulta.setText("Nova consulta");
        jlbNovaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbNovaConsultaMouseClicked(evt);
            }
        });
        jtbPesquisarAlunoConsulta.add(jlbNovaConsulta);

        jToolBar2.add(jtbPesquisarAlunoConsulta);

        jtbPesquisarAlunoAluno.setFloatable(false);
        jtbPesquisarAlunoAluno.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jtbPesquisarAlunoAluno.add(js3);

        jlbEditarAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbEditarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/user/User_Edit32x32.png"))); // NOI18N
        jlbEditarAluno.setText("Editar aluno");
        jlbEditarAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbEditarAlunoMouseClicked(evt);
            }
        });
        jtbPesquisarAlunoAluno.add(jlbEditarAluno);
        jtbPesquisarAlunoAluno.add(js4);

        jlbExcluirAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbExcluirAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/user/User_Trash32x32.png"))); // NOI18N
        jlbExcluirAluno.setText("Excluir aluno");
        jlbExcluirAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbExcluirAlunoMouseClicked(evt);
            }
        });
        jtbPesquisarAlunoAluno.add(jlbExcluirAluno);
        jtbPesquisarAlunoAluno.add(js5);

        jlbGerarFicha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbGerarFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icone/user/User_Note32x32.png"))); // NOI18N
        jlbGerarFicha.setText("Gerar ficha");
        jlbGerarFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbGerarFichaMouseClicked(evt);
            }
        });
        jtbPesquisarAlunoAluno.add(jlbGerarFicha);

        jToolBar2.add(jtbPesquisarAlunoAluno);

        jtDadoAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Matrícula", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDadoAluno.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtDadoAluno.getTableHeader().setReorderingAllowed(false);
        jtDadoAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtDadoAlunoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtDadoAluno);
        jtDadoAluno.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbPesquisarPor)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbNome)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbSiape)
                            .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbPesquisarPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jlbSiape)
                                    .addComponent(jlbNome, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        /*if (veioDeQualTela == 0){
            c.vFecharTelaPesquisarAluno(1);
        } else {
            c.vFecharTelaPesquisarAluno(0);
        }*/
        
    }//GEN-LAST:event_formWindowClosing

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jtfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyPressed
        // TODO add your handling code here:
       /* if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nome = jtfNome.getText(), matricula = jtfMatricula.getText();
            DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
            c.vLimparTabela(tabela);
            AlunoDAO aluno = new AlunoDAO();
            aluno.preencherTabelaPesquisaAluno(0, tabela, nome, matricula);
        }*/
    }//GEN-LAST:event_jtfNomeKeyPressed

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        String letra = evt.getKeyChar() + "";
        if (c.bIsLetter(letra)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jtfMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMatriculaActionPerformed

    private void jtfMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMatriculaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String nome = jtfNome.getText(), matricula = jtfMatricula.getText();
            DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
            c.vLimparTabela(tabela);
            AlunoDAO aluno = new AlunoDAO();
            aluno.vPreencherTabelaPesquisaAlunoDAO(1, tabela, nome, matricula);
        }
    }//GEN-LAST:event_jtfMatriculaKeyPressed

    private void jtfMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMatriculaKeyTyped
        // TODO add your handling code here:
        String numero = evt.getKeyChar() + "";
        if (c.bIsNumber(numero)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfMatriculaKeyTyped

    private void jlbPesquisarPorMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbPesquisarPorMatriculaMouseClicked
        // TODO add your handling code here:
        String nome = jtfNome.getText(), matricula = jtfMatricula.getText();
        DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
        c.vLimparTabela(tabela);
        AlunoDAO aluno = new AlunoDAO();
       // aluno.preencherTabelaPesquisaAluno(1, tabela, nome, matricula);
    }//GEN-LAST:event_jlbPesquisarPorMatriculaMouseClicked

    private void jlbEditarAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbEditarAlunoMouseClicked
        // TODO add your handling code here:
        /*boolean a = false;
        DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
        if (jtDadoAluno.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Faça uma pesquisa para selecionar o aluno que deseja editar");
        } else {
            for (int i = 0; i < jtDadoAluno.getRowCount(); i++) {
                if (jtDadoAluno.isRowSelected(i)) {
                    a = true;
                }
            }
            if (a) {
                int linha = jtDadoAluno.getSelectedRow(), colunaMatricula = 1, tipo = 1;
                String matricula = jtDadoAluno.getValueAt(linha, colunaMatricula).toString();
                AlunoDAO alunoDao = new AlunoDAO();
        //        MAluno aluno = alunoDao.getAluno(matricula);
                if (aluno != null) {
                    c.vAbrirTelaCadastrarEditarAluno(tipo, aluno, tabela);
                    c.vLimparTabela(tabela);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível editar o aluno selecionado, faça uma nova pesquisa e tente novamente");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Favor selecionar um atendente antes de editar");
            }
        }*/
    }//GEN-LAST:event_jlbEditarAlunoMouseClicked

    private void jlbExcluirAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbExcluirAlunoMouseClicked
        // TODO add your handling code here:
        /*boolean a = false;
        if (jtDadoAluno.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Faça uma pesquisa para selecionar o aluno que deseja excluir");
        } else {
            for (int i = 0; i < jtDadoAluno.getRowCount(); i++) {
                if (jtDadoAluno.isRowSelected(i)) {
                    a = true;
                }
            }
            if (a) {
                int linha = jtDadoAluno.getSelectedRow(), colunaCurso = 2, colunaMatricula = 1, colunaNome = 0, tipo = 1;
                String matriculaTabela = jtDadoAluno.getValueAt(linha, colunaMatricula).toString();
                String nomeTabela = jtDadoAluno.getValueAt(linha, colunaNome).toString();
                String cursoTabela = jtDadoAluno.getValueAt(linha, colunaCurso).toString();
                DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
                AlunoDAO alunoDao = new AlunoDAO();
                MAluno aluno = alunoDao.getAluno(matriculaTabela);
                if (aluno != null) {
                    System.out.println("entrou");
                    alunoDao.removerAluno(tabela, nomeTabela, matriculaTabela);
                    c.vLimparTabela(tabela);
                    alunoDao.preencherTabelaPesquisaAluno(0, tabela, "", "");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível remover o aluno selecionado, faça uma nova pesquisa e tente novamente");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Favor selecionar um aluno antes de excluir");
            }
        }*/
    }//GEN-LAST:event_jlbExcluirAlunoMouseClicked

    private void jlbGerarFichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbGerarFichaMouseClicked
        // TODO add your handling code here:
       /* boolean a = false;
        if (jtDadoAluno.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Faça uma pesquisa para selecionar o aluno que deseja gerar uma ficha com os dados");
        } else {
            for (int i = 0; i < jtDadoAluno.getRowCount(); i++) {
                if (jtDadoAluno.isRowSelected(i)) {
                    a = true;
                }
            }
            if (a) {
                int linha = jtDadoAluno.getSelectedRow(), colunaMatricula = 1, colunaNome = 0;
                String matricula = jtDadoAluno.getValueAt(linha, colunaMatricula).toString();
                String nome = jtDadoAluno.getValueAt(linha, colunaNome).toString();
                AlunoDAO alunoDao = new AlunoDAO();
                try {
                    c.vRelatorioAluno(alunoDao.getAluno(matricula));
                } catch (IOException | BadElementException ex) {
                    Logger.getLogger(TPesquisarAluno.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Favor selecionar um aluno");
            }
        }*/
    }//GEN-LAST:event_jlbGerarFichaMouseClicked

    private void jtDadoAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDadoAlunoKeyPressed
        // TODO add your handling code here:
        /*if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            boolean a = false;
            if (jtDadoAluno.getRowCount() < 1) {
                JOptionPane.showMessageDialog(this, "Faça uma pesquisa para selecionar o aluno que deseja excluir");
            } else {
                for (int i = 0; i < jtDadoAluno.getRowCount(); i++) {
                    if (jtDadoAluno.isRowSelected(i)) {
                        a = true;
                    }
                }
                if (a) {
                    int linha = jtDadoAluno.getSelectedRow(), colunaMatricula = 1, colunaNome = 0, tipo = 1;
                    String matriculaTabela = jtDadoAluno.getValueAt(linha, colunaMatricula).toString();
                    String nomeTabela = jtDadoAluno.getValueAt(linha, colunaNome).toString();
                    DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
                    AlunoDAO alunoDao = new AlunoDAO();
                    MAluno aluno = alunoDao.getAluno(matriculaTabela);
                    if (aluno != null) {
                        System.out.println("aheooo");
                        alunoDao.removerAluno(tabela, nomeTabela, matriculaTabela);
                        c.vLimparTabela(tabela);
                        alunoDao.preencherTabelaPesquisaAluno(2, tabela, " ", " ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível remover o aluno selecionado, faça uma nova pesquisa e tente novamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Favor selecionar um aluno antes de excluir");
                }
            }
        }*/
    }//GEN-LAST:event_jtDadoAlunoKeyPressed

    private void jtfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if (veioDeQualTela == 0) { // tela cadastrar consulta
            jlbEditarAluno.setVisible(false);
            jlbExcluirAluno.setVisible(false);
            jlbGerarFicha.setVisible(false);
        } else {
            jlbNovaConsulta.setVisible(false);
        }
    }//GEN-LAST:event_formWindowActivated

    private void jlbNovaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbNovaConsultaMouseClicked
        // TODO add your handling code here:
       /* boolean a = false;
        if (jtDadoAluno.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Faça uma pesquisa para selecionar o aluno que deseja realizar uma nova consulta");
        } else {
            for (int i = 0; i < jtDadoAluno.getRowCount(); i++) {
                if (jtDadoAluno.isRowSelected(i)) {
                    a = true;
                }
            }
            if (a) {
                DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
                int linha = jtDadoAluno.getSelectedRow(), colunaMatricula = 1;
                String matricula = jtDadoAluno.getValueAt(linha, colunaMatricula).toString();
                AlunoDAO alunoDAO = new AlunoDAO();
                c.vAbrirTelaCadastrarEditarConsulta(alunoDAO.getAluno(matricula), 0, tabela);
            } else {
                JOptionPane.showMessageDialog(this, "Favor selecionar um aluno");
            }
        }*/
    }//GEN-LAST:event_jlbNovaConsultaMouseClicked

    private void jlbPesquisarNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbPesquisarNomeMouseClicked
        // TODO add your handling code here:
        /*String nome = jtfNome.getText(), matricula = jtfMatricula.getText();
        DefaultTableModel tabela = (DefaultTableModel) jtDadoAluno.getModel();
        c.vLimparTabela(tabela);
        AlunoDAO aluno = new AlunoDAO();
        aluno.preencherTabelaPesquisaAluno(1, tabela, nome, matricula);*/
    }//GEN-LAST:event_jlbPesquisarNomeMouseClicked
    
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
            java.util.logging.Logger.getLogger(TPesquisarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPesquisarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgOrdenarNome;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel jlbEditarAluno;
    private javax.swing.JLabel jlbExcluirAluno;
    private javax.swing.JLabel jlbGerarFicha;
    private javax.swing.JLabel jlbNome;
    private javax.swing.JLabel jlbNovaConsulta;
    private javax.swing.JLabel jlbPesquisarNome;
    private javax.swing.JLabel jlbPesquisarPor;
    private javax.swing.JLabel jlbPesquisarPorMatricula;
    private javax.swing.JLabel jlbSiape;
    private javax.swing.JToolBar.Separator js1;
    private javax.swing.JToolBar.Separator js2;
    private javax.swing.JToolBar.Separator js3;
    private javax.swing.JToolBar.Separator js4;
    private javax.swing.JToolBar.Separator js5;
    private javax.swing.JTable jtDadoAluno;
    private javax.swing.JToolBar jtbPesquisarAlunoAluno;
    private javax.swing.JToolBar jtbPesquisarAlunoConsulta;
    private javax.swing.JTextField jtfMatricula;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}