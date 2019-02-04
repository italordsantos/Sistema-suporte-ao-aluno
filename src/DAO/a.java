/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.Gerenciamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.MAluno;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class a {

    Gerenciamento c;

    /*
    public boolean inserir(MAluno aluno) {

        String sql = "insert into cadastrar_aluno "
                + "(nome, cidade, bairro, matricula, curso, datanascimento, "
                + "celular, telefone, cpf, rg, situacao, email, ne, nomeResponsavel1, celularresponsavel1, "
                + "telefoneresponsavel1, nomeresponsavel2, celularresponsavel2, telefoneresponsavel2, informacoesadicionais, "
                + "sexo, uf, numerocasa,  endereco) "
                + "values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.setString(1, aluno.getNome());
            comando.setString(2, aluno.getCidade());
            comando.setString(3, aluno.getBairro());
            comando.setString(4, aluno.getMatricula());
            comando.setString(5, aluno.getCurso());
            comando.setString(6, aluno.getDataNascimento());
            comando.setString(7, aluno.getCelular());
            comando.setString(8, aluno.getTelefone());
            comando.setString(9, aluno.getCpf());
            comando.setString(10, aluno.getRg());
            comando.setString(11, aluno.getSituacao());
            comando.setString(12, aluno.getEmail());
            comando.setString(13, aluno.getNe());
            comando.setString(14, aluno.getNomeResponsavel1());
            comando.setString(15, aluno.getCelularResponsavel1());
            comando.setString(16, aluno.getTelefoneResponsavel1());
            comando.setString(17, aluno.getNomeResponsavel2());
            comando.setString(18, aluno.getCelularResponsavel2());
            comando.setString(19, aluno.getTelefoneResponsavel2());
            comando.setString(20, aluno.getInformacoesAdicionais());
            comando.setString(21, aluno.getSexo());
            comando.setString(22, aluno.getUf());
            comando.setString(23, aluno.getNumerocasa());
            comando.setString(24, aluno.getEndereco());

            comando.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterar(MAluno aluno) {

        String sql = "update cadastrar_aluno set "
                + "nome = ?, cidade = ?, bairro = ?, curso = ?, datanascimento = ?, "
                + "celular = ?, telefone = ?, cpf = ?, rg = ?, situacao = ?, email = ?, ne = ?, nomeResponsavel1 = ?, celularresponsavel1 = ?, "
                + "telefoneresponsavel1 = ?, nomeresponsavel2 = ?, celularresponsavel2 = ?, telefoneresponsavel2 = ?, informacoesadicionais = ?, "
                + "sexo = ?, uf = ?, numerocasa = ?,  endereco = ? "
                + "where matricula = ?";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.setString(1, aluno.getNome());
            comando.setString(2, aluno.getCidade());
            comando.setString(3, aluno.getBairro());
            comando.setString(4, aluno.getCurso());
            comando.setString(5, aluno.getDataNascimento());
            comando.setString(6, aluno.getCelular());
            comando.setString(7, aluno.getTelefone());
            comando.setString(8, aluno.getCpf());
            comando.setString(9, aluno.getRg());
            comando.setString(10, aluno.getSituacao());
            comando.setString(11, aluno.getEmail());
            comando.setString(12, aluno.getNe());
            comando.setString(13, aluno.getNomeResponsavel1());
            comando.setString(14, aluno.getCelularResponsavel1());
            comando.setString(15, aluno.getTelefoneResponsavel1());
            comando.setString(16, aluno.getNomeResponsavel2());
            comando.setString(17, aluno.getCelularResponsavel2());
            comando.setString(18, aluno.getTelefoneResponsavel2());
            comando.setString(19, aluno.getInformacoesAdicionais());
            comando.setString(20, aluno.getSexo());
            comando.setString(21, aluno.getUf());
            comando.setString(22, aluno.getNumerocasa());
            comando.setString(23, aluno.getEndereco());
            comando.setString(24, aluno.getMatricula());

            comando.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao alterar: " + ex.getMessage());
        }
        return false;
    }

    public boolean validarMatriculaExistente(String matricula) {
        String sql = "select * "
                + "from cadastrar_aluno "
                + "where matricula like ?";
        boolean achou = false;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, matricula);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                achou = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return achou;
    }

    public void removeAll() {
        String sql = "delete from cadastrar_aluno";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.executeUpdate();
            System.out.println("Removidos todos os dados da tabela: " + sql);
        } catch (SQLException ex) {
            Logger.getLogger(AtendenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removerAluno(DefaultTableModel tabela, String nome, String matricula) {
        String sql = "delete from cadastrar_aluno where matricula = '" + matricula + "'";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AtendenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MAluno pesquisarAluno(String nome, String matricula, String curso) { // não busca os dados
        String sql = "select * "
                + "from cadastrar_aluno "
                + "where nome like ?";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, nome);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                MAluno aluno = new MAluno(
                        resultadoConsulta.getString("nome"),
                        resultadoConsulta.getString("cidade"),
                        resultadoConsulta.getString("bairro"),
                        resultadoConsulta.getString("matricula"),
                        resultadoConsulta.getString("curso"),
                        resultadoConsulta.getString("datanascimento"),
                        resultadoConsulta.getString("celular"),
                        resultadoConsulta.getString("telefone"),
                        resultadoConsulta.getString("cpf"),
                        resultadoConsulta.getString("rg"),
                        resultadoConsulta.getString("situacao"),
                        resultadoConsulta.getString("email"),
                        resultadoConsulta.getString("ne"),
                        resultadoConsulta.getString("nomeResponsavel1"),
                        resultadoConsulta.getString("celularresponsavel1"),
                        resultadoConsulta.getString("telefoneresponsavel1"),
                        resultadoConsulta.getString("nomeresponsavel2"),
                        resultadoConsulta.getString("celularresponsavel1"),
                        resultadoConsulta.getString("telefoneresponsavel2"),
                        resultadoConsulta.getString("informacoesadicionais"),
                        resultadoConsulta.getString("sexo"),
                        resultadoConsulta.getString("uf"),
                        resultadoConsulta.getString("numerocasa"),
                        resultadoConsulta.getString("endereco")
                );

                return aluno;
            }
        } catch (Exception ex) {
            System.out.println(
                    "Erro ao pesquisar por id: "
                    + ex.getMessage());
        }

        return null;
    }

    public MAluno getAluno(String matricula) {
        String sql = "select * "
                + "from cadastrar_aluno "
                + "where matricula like ?";
        MAluno aluno = null;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, matricula);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                aluno = new MAluno(
                        resultadoConsulta.getString("nome"),
                        resultadoConsulta.getString("cidade"),
                        resultadoConsulta.getString("bairro"),
                        resultadoConsulta.getString("matricula"),
                        resultadoConsulta.getString("curso"),
                        resultadoConsulta.getString("datanascimento"),
                        resultadoConsulta.getString("celular"),
                        resultadoConsulta.getString("telefone"),
                        resultadoConsulta.getString("cpf"),
                        resultadoConsulta.getString("rg"),
                        resultadoConsulta.getString("situacao"),
                        resultadoConsulta.getString("email"),
                        resultadoConsulta.getString("ne"),
                        resultadoConsulta.getString("nomeResponsavel1"),
                        resultadoConsulta.getString("celularresponsavel1"),
                        resultadoConsulta.getString("telefoneresponsavel1"),
                        resultadoConsulta.getString("nomeresponsavel2"),
                        resultadoConsulta.getString("celularresponsavel1"),
                        resultadoConsulta.getString("telefoneresponsavel2"),
                        resultadoConsulta.getString("informacoesadicionais"),
                        resultadoConsulta.getString("sexo"),
                        resultadoConsulta.getString("uf"),
                        resultadoConsulta.getString("numerocasa"),
                        resultadoConsulta.getString("endereco")
                );
                return aluno;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return aluno;
    }

    public void preencherTabelaPesquisaAluno(int t, DefaultTableModel tabela, String nome, String matricula) {
        try {
            String sql_NnotN = "select * "
                    + "from cadastrar_aluno " // notNull
                    + "where nome like ?";

            String sql_Null = "select * "
                    + "from cadastrar_aluno "; // null

            String sql_MnotN = "select * "
                    + "from cadastrar_aluno " // notNull
                    + "where matricula like ?";

            String matric = "%" + matricula + "%";
            String nom = "%" + nome + "%";
            try {
                switch (t) {
                    case 0:
                        // nome
                        if (nome.trim().isEmpty()) {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("curso")});
                            }
                        } else {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_NnotN);
                            comando.setString(1, nom);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("curso")});
                            }
                        }
                        break;
                        
                    case 1:
                        // matricula
                        if (matricula.trim().isEmpty()) {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("curso")});
                            }
                        } else {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_MnotN);
                            comando.setString(1, matric);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("curso")});
                            }
                        }
                        break;
                        
                    case 2:
                        // null
                        PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                        ResultSet resultadoConsulta = comando.executeQuery();
                        while (resultadoConsulta.next()) {
                            tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("curso")});
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Trágico :/");
                        break;
                }
            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
                System.out.println("~~ Erro PreparedStatement ~~");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     */
}
