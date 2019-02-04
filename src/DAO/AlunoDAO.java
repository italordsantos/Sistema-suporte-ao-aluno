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
 * @author Ítalo
 */
public class AlunoDAO {

    Gerenciamento c;

    public boolean bCadastrarAlunoDAO(MAluno mAluno) {
        String sql = "insert into tabela_aluno "
                + "(vcNome, vcCidade, vcBairro, vcMatricula, vcCurso, vcDataNascimento, vcCelular, vcTelefone, vcCpf,"
                + "vcRg, vcSituacao, vcEmail, bNecessidadesEspecificas, tInformacoesAdicionais, vcSexo, vcUf,"
                + "vcNumeroCasa, vcEndereco, bAlunoAtivo, vcMatriculaFilho)"
                + "values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement psComando = Conexao.getConexao().prepareStatement(sql);
            psComando.setString(1, mAluno.getsNome());
            psComando.setString(2, mAluno.getsCidade());
            psComando.setString(3, mAluno.getsBairro());
            psComando.setString(4, mAluno.getsMatricula());
            psComando.setString(5, mAluno.getsCurso());
            psComando.setString(6, mAluno.getsDataNascimento());
            psComando.setString(7, mAluno.getsCelular());
            psComando.setString(8, mAluno.getsTelefone());
            psComando.setString(9, mAluno.getsCpf());
            psComando.setString(10, mAluno.getsRg());
            psComando.setString(11, mAluno.getsSituacao());
            psComando.setString(12, mAluno.getsEmail());
            psComando.setBoolean(13, mAluno.isbNecessidadesEspecificas());
            psComando.setString(14, mAluno.getsInformacoesAdicionais());
            psComando.setString(15, mAluno.getsSexo());
            psComando.setString(16, mAluno.getsUf());
            psComando.setString(17, mAluno.getsNumeroCasa());
            psComando.setString(18, mAluno.getsEndereco());
            psComando.setBoolean(19, mAluno.isbAlunoAtivo());
            psComando.setString(20, mAluno.getsMatriculaFilho());
            psComando.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar aluno: " + ex.getMessage());
            return false;
        }
    }

    public boolean bAlterarCadastroAlunoDAO(MAluno mAluno) {

        String sql = "update tabela_aluno set "
                + "vcNome = ?, vcCidade = ?, vcBairro = ?, vcCurso = ?, vcDataNascimento = ?, vcCelular = ?,"
                + "vcTelefone = ?, vcCpf = ?, vcRg = ?, vcSituacao = ?, vcEmail = ?, bNecessidadesEspecificas = ?,"
                + "tInformacoesAdicionais = ?, vcSexo = ?, vcUf = ?, vcNumeroCasa = ?, vcEndereco = ?, "
                + "bAlunoAtivo = ?, vcMatriculaFilho = ?"
                + "where vcMatricula = ?";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, mAluno.getsNome());
            comando.setString(2, mAluno.getsCidade());
            comando.setString(3, mAluno.getsBairro());
            comando.setString(4, mAluno.getsCurso());
            comando.setString(5, mAluno.getsDataNascimento());
            comando.setString(6, mAluno.getsCelular());
            comando.setString(7, mAluno.getsTelefone());
            comando.setString(8, mAluno.getsCpf());
            comando.setString(9, mAluno.getsRg());
            comando.setString(10, mAluno.getsSituacao());
            comando.setString(11, mAluno.getsEmail());
            comando.setBoolean(12, mAluno.isbNecessidadesEspecificas());
            comando.setString(13, mAluno.getsInformacoesAdicionais());
            comando.setString(14, mAluno.getsSexo());
            comando.setString(15, mAluno.getsUf());
            comando.setString(16, mAluno.getsNumeroCasa());
            comando.setString(17, mAluno.getsEndereco());
            comando.setString(18, mAluno.getsMatriculaFilho());
            comando.setBoolean(19, mAluno.isbAlunoAtivo());
            comando.setString(20, mAluno.getsMatricula());
            comando.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao alterar: " + ex.getMessage());
        }
        return false;
    }

    public boolean bValidarMatriculaExistenteDAO(String sMatricula) {
        String sql = "select * "
                + "from tabela_aluno "
                + "where vcMatricula like ?";
        boolean achou = false;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, sMatricula);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                achou = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return achou;
    }

    public void bRemoverAllAlunoDAO() {
        String sql = "delete from tabela_aluno";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
            System.out.println("Todos os dados da tabela " + sql + " foram removidos");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bRemoverAlunoDAO(String sNomeAluno, String sMatricula) {
        String sql = "delete from tabela_aluno where vcMatricula = '" + sMatricula + "'";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
            System.out.println("O aluno: " + sNomeAluno + " foi removido com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possível removê-lo");
        }
    }

    public MAluno maGetAlunoDAO(String sMatricula) {
        String sql = "select * "
                + "from tabela_aluno "
                + "where vcMatricula like ?";
        MAluno mAluno = null;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, sMatricula);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                mAluno.setsNome(resultadoConsulta.getString("vcNome"));
                mAluno.setsCidade(resultadoConsulta.getString("vcCidade"));
                mAluno.setsBairro(resultadoConsulta.getString("vcBairro"));
                mAluno.setsMatricula(resultadoConsulta.getString("vcMatricula"));
                mAluno.setsCurso(resultadoConsulta.getString("vcCurso"));
                mAluno.setsDataNascimento(resultadoConsulta.getString("vcDataNascimento"));
                mAluno.setsCelular(resultadoConsulta.getString("vcCelular"));
                mAluno.setsTelefone(resultadoConsulta.getString("vcTelefone"));
                mAluno.setsCpf(resultadoConsulta.getString("vcCpf"));
                mAluno.setsRg(resultadoConsulta.getString("vcRg"));
                mAluno.setsSituacao(resultadoConsulta.getString("vcSituacao"));
                mAluno.setsEmail(resultadoConsulta.getString("vcEmail"));
                mAluno.setbNecessidadesEspecificas(resultadoConsulta.getBoolean("bNecessidadesEspecificas"));
                mAluno.setsInformacoesAdicionais(resultadoConsulta.getString("tInformacoesAdicionais"));
                mAluno.setsSexo(resultadoConsulta.getString("vcSexo"));
                mAluno.setsUf(resultadoConsulta.getString("vcUf"));
                mAluno.setsNumeroCasa(resultadoConsulta.getString("vcNumeroCasa"));
                mAluno.setsEndereco(resultadoConsulta.getString("vcEndereco"));
                mAluno.setsMatriculaFilho(resultadoConsulta.getString("vcMatriculaFilho"));
                mAluno.setbAlunoAtivo(resultadoConsulta.getBoolean("bAlunoAtivo"));
                return mAluno;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mAluno;
    }

    public void vPreencherTabelaPesquisaAlunoDAO(int iTipoDePesquisar, DefaultTableModel dtmTabela, String sNome, String sMatricula) {
        try {
            String sql_NnotN = "select * "
                    + "from tabela_aluno " // notNull
                    + "where vcNome like ?";

            String sql_Null = "select * "
                    + "from tabela_aluno "; // null

            String sql_MnotN = "select * "
                    + "from tabela_aluno " // notNull
                    + "where vcMatricula like ?";

            String sMatriculaSql = "%" + sMatricula + "%";
            String sNomeSql = "%" + sNome + "%";
            try {
                switch (iTipoDePesquisar) {
                    case 0:
                        // nome
                        if (sNome.trim().isEmpty()) {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                dtmTabela.addRow(new Object[]{resultadoConsulta.getString("vcNome"), resultadoConsulta.getString("vcMatricula"), resultadoConsulta.getString("vcCurso")});
                            }
                        } else {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_NnotN);
                            comando.setString(1, sNomeSql);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                dtmTabela.addRow(new Object[]{resultadoConsulta.getString("vcNome"), resultadoConsulta.getString("vcMatricula"), resultadoConsulta.getString("vcCurso")});
                            }
                        }
                        break;

                    case 1:
                        // matricula
                        if (sMatricula.trim().isEmpty()) {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                dtmTabela.addRow(new Object[]{resultadoConsulta.getString("vcNome"), resultadoConsulta.getString("vcMatricula"), resultadoConsulta.getString("vcCurso")});
                            }
                        } else {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_MnotN);
                            comando.setString(1, sMatriculaSql);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                dtmTabela.addRow(new Object[]{resultadoConsulta.getString("vcNome"), resultadoConsulta.getString("vcMatricula"), resultadoConsulta.getString("vcCurso")});
                            }
                        }
                        break;

                    case 2:
                        // null
                        PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                        ResultSet resultadoConsulta = comando.executeQuery();
                        while (resultadoConsulta.next()) {
                            dtmTabela.addRow(new Object[]{resultadoConsulta.getString("vcNome"), resultadoConsulta.getString("vcMatricula"), resultadoConsulta.getString("vcCurso")});
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
}
