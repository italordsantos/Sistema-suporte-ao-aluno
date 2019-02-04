/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.Gerenciamento;
import Modelo.MLogin;
import java.sql.PreparedStatement;
import Modelo.MUsuario;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class UsuarioDAO {

    Gerenciamento c;
    MUsuario mUsuario;
    LoginDAO lDAO;
    MLogin mLogin;
    boolean bAchou = false;

    public void setControle(Gerenciamento cp) {
        c = cp;
    }

    public boolean bCadastrarUsuarioDAO(MUsuario mUsuario) {
        String sql = "insert into tabela_usuario "
                + "(vcnome, vccidade, vcbairro, vcsiape, vcdatanascimento, vccelular, vctelefone, vccpf, vcrg, "
                + "vcsituacao, vcemail, vcinformacoesadicionais, vcsexo, vcuf, vcnumerocasa, vcnucleo, vcendereco, "
                + "busuarioativo) "
                + "values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, mUsuario.getsNome());
            comando.setString(2, mUsuario.getsCidade());
            comando.setString(3, mUsuario.getsBairro());
            comando.setString(4, mUsuario.getsSiape());
            comando.setString(5, mUsuario.getsDataNascimento());
            comando.setString(6, mUsuario.getsCelular());
            comando.setString(7, mUsuario.getsTelefone());
            comando.setString(8, mUsuario.getsCpf());
            comando.setString(9, mUsuario.getsRg());
            comando.setString(10, mUsuario.getsSituacao());
            comando.setString(11, mUsuario.getsEmail());
            comando.setString(12, mUsuario.getsInformacoesAdicionais());
            comando.setString(13, mUsuario.getsSexo());
            comando.setString(14, mUsuario.getsUf());
            comando.setString(15, mUsuario.getsNumeroCasa());
            comando.setString(16, mUsuario.getsNucleo());
            comando.setString(17, mUsuario.getsEndereco());
            comando.setBoolean(18, mUsuario.isbUsuarioAtivo());
            comando.executeUpdate();
            return true;
        } catch (SQLException | HeadlessException ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
            return false;
        }
    }

    public boolean bAlterarUsuarioDAO(MUsuario mUsuarioEditado) {
        String sql = "update tabela_usuario set "
                + "vcnome = ?, vccidade = ?, vcuf = ?, vcbairro = ?, vcendereco = ?, vcnumerocasa = ?, vcsiape = ?, "
                + "vcdatanascimento = ?, vccelular = ?, vctelefone = ?, vccpf = ?, vcrg = ?, vcsituacao = ?, "
                + "vcemail = ?, vcinformacoesadicionais = ?, vcsexo = ?, vcnucleo = ?, busuarioativo = ? "
                + "where seid = ? ";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, mUsuarioEditado.getsNome());
            comando.setString(2, mUsuarioEditado.getsCidade());
            comando.setString(3, mUsuarioEditado.getsUf());
            comando.setString(4, mUsuarioEditado.getsBairro());
            comando.setString(5, mUsuarioEditado.getsEndereco());
            comando.setString(6, mUsuarioEditado.getsNumeroCasa());
            comando.setString(7, mUsuarioEditado.getsSiape());
            comando.setString(8, mUsuarioEditado.getsDataNascimento());
            comando.setString(9, mUsuarioEditado.getsCelular());
            comando.setString(10, mUsuarioEditado.getsTelefone());
            comando.setString(11, mUsuarioEditado.getsCpf());
            comando.setString(12, mUsuarioEditado.getsRg());
            comando.setString(13, mUsuarioEditado.getsSituacao());
            comando.setString(14, mUsuarioEditado.getsEmail());
            comando.setString(15, mUsuarioEditado.getsInformacoesAdicionais());
            comando.setString(16, mUsuarioEditado.getsSexo());
            comando.setString(17, mUsuarioEditado.getsNucleo());
            comando.setBoolean(18, mUsuarioEditado.isbUsuarioAtivo());
            comando.setInt(19, mUsuarioEditado.getiId());
            comando.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao alterar: " + ex.getMessage());
        }
        return false;
    }

    public boolean rRemoverAllUsuarioDAO() {
        String sql = "delete from tabela_usuario";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean bRemoverUsuarioDAO(int iSeId) {
        String sql = "update tabela_usuario set busuarioativo = ? where seid = ?";
        boolean bRemoveu = false;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setBoolean(1, true);
            comando.setInt(2, iSeId);
            bRemoveu = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possível removê-lo");
        }
        return bRemoveu;
    }

    public boolean bValidarSiapeExistenteDAO(String sSiape) {
        String sql = "select * "
                + "from tabela_usuario "
                + "where vcsiape like ?";
        boolean achou = false;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, sSiape);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                achou = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return achou;
    }

    public int iValidarEmailUsuarioDAO(String sEmail) {
        /*
         *0 - não tem  1 - tem um email 2 - mais de um
         */
        String sql = "select * "
                + "from tabela_usuario "
                + "where vcemail like ?";
        boolean bAchou = false;
        int iAchou = 0, iResult = 0;
        System.out.println("login --");
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, sEmail);
            ResultSet resultadoConsulta = comando.executeQuery();
            while (resultadoConsulta.next()) {
                bAchou = true;
                iAchou++;
                System.out.println("email encontrado até agora: " + iAchou);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (bAchou) {
            System.out.println("a");
            if (iAchou == 1) {
                System.out.println("b");
                iResult = 1;
            } else {
                System.out.println("c");
                iResult = 2;
            }
        }
        System.out.println("-- login");
        return iResult;
    }

    public void vPreencherTabelaPesquisaAtendenteDAO(DefaultTableModel tabela, MUsuario mUsuarioTabela) {
        try {
            String sSiape = "'%" + mUsuarioTabela.getsSiape() + "%'";
            String sNome = "'%" + mUsuarioTabela.getsNome() + "%'";
            String sNucleo = "'" + mUsuarioTabela.getsNucleo() + "'";
            String teste = "select * from tabela_login";
            if (sPermissãoDeAcesso(c.getmUsuarioLogado(), 3) != null) {
                String sSqlSN = "select tu.* from tabela_usuario tu where "
                        + "tu.vcnome like " + sNome + " and tu.vcsiape like " + sSiape + " and tu.busuarioativo = true"
                        + sPermissãoDeAcesso(c.getmUsuarioLogado(), 3),
                        sSqlCN = "select tu.* from tabela_usuario tu where "
                        + "tu.vcnome like " + sNome + " and tu.vcsiape like " + sSiape + " and tu.vcnucleo like " + sNucleo
                        + " and tu.busuarioativo = true " + sPermissãoDeAcesso(c.getmUsuarioLogado(), 3);

                if (mUsuarioTabela.getsNucleo().equals("Todos")) {
                    PreparedStatement comando = Conexao.getConexao().prepareStatement(sSqlSN);
                    ResultSet resultadoConsulta = comando.executeQuery();

                    while (resultadoConsulta.next()) {
                        tabela.addRow(new Object[]{resultadoConsulta.getInt("seid"), resultadoConsulta.getString("vcnome"), resultadoConsulta.getString("vcsiape"), resultadoConsulta.getString("vcnucleo")});
                    }
                } else {
                    PreparedStatement comando = Conexao.getConexao().prepareStatement(sSqlCN);
                    ResultSet resultadoConsulta = comando.executeQuery();
                    while (resultadoConsulta.next()) {
                        tabela.addRow(new Object[]{resultadoConsulta.getInt("seid"), resultadoConsulta.getString("vcnome"), resultadoConsulta.getString("vcsiape"), resultadoConsulta.getString("vcnucleo")});
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public MUsuario muGetUsuarioDAO(int iSeId) {
        String sql = "select * "
                + "from tabela_usuario "
                + "where seid = ?";
        mUsuario = new MUsuario();
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setInt(1, iSeId);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                mUsuario.setsNome(resultadoConsulta.getString("vcnome"));
                mUsuario.setsSiape(resultadoConsulta.getString("vcsiape"));
                mUsuario.setsCidade(resultadoConsulta.getString("vccidade"));
                mUsuario.setsBairro(resultadoConsulta.getString("vcbairro"));
                mUsuario.setsDataNascimento(resultadoConsulta.getString("vcdatanascimento"));
                mUsuario.setsCelular(resultadoConsulta.getString("vccelular"));
                mUsuario.setsTelefone(resultadoConsulta.getString("vctelefone"));
                mUsuario.setsCpf(resultadoConsulta.getString("vccpf"));
                mUsuario.setsRg(resultadoConsulta.getString("vcrg"));
                mUsuario.setsSituacao(resultadoConsulta.getString("vcsituacao"));
                mUsuario.setsEmail(resultadoConsulta.getString("vcemail"));
                mUsuario.setsInformacoesAdicionais(resultadoConsulta.getString("vcinformacoesadicionais"));
                mUsuario.setsSexo(resultadoConsulta.getString("vcsexo"));
                mUsuario.setsUf(resultadoConsulta.getString("vcuf"));
                mUsuario.setsNumeroCasa(resultadoConsulta.getString("vcnumerocasa"));
                mUsuario.setsNucleo(resultadoConsulta.getString("vcnucleo"));
                mUsuario.setsEndereco(resultadoConsulta.getString("vcendereco"));
                mUsuario.setbUsuarioAtivo(resultadoConsulta.getBoolean("busuarioativo"));
                mUsuario.setiId(resultadoConsulta.getInt("seid"));
                System.out.println("Acesso permitido");
                return mUsuario;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mUsuario;
    }

    public String sPermissãoDeAcesso(MUsuario mUsuarioRecebido, int iAcao) {
        /* Dados que cada núcleo pode visualizar do outro
         * 1 - Assistente de Aluno 1, 6
	 * 2 - Serviço Social 1, 2, 5, 6
	 * 3 - Pedagogia 1, 3, 5, 6
	 * 4 - Psicologia 1, 4, 5, 6
	 * 5 - NAPNE 5 / Núcleo de apoio a pessoas com necessidades específicas \
	 * 6 - Área Comum 6
	 * -------------------------------- *
         * 0 - Cadastrar
         * 1 - Editar
         * 2 - Excluir
         * 3 - Pesquisar
         * 4 - Relatório
         */
        
        String sSqlFormatada = null,
                sAa = "Assistente de aluno", //1
                sSs = "Serviço social", //2
                sPed = "Pedagogia", //3
                sPsi = "Psicologia", //4
                sN = "NAPNE", //5
                sAc = "Área comum", //6
                sA = "Admin"; //7

        switch (iAcao) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                switch (mUsuarioRecebido.getsNucleo()) {
                    case "Assistente de aluno":
                        sSqlFormatada = " and tu.vcnucleo like '" + sAa + "'"
                                + " or tu.vcnucleo like '" + sAc + "' ";
                        break;
                    case "Serviço social":
                        sSqlFormatada = " and tu.vcnucleo like '" + sAa + "'"
                                + " or tu.vcnucleo like '" + sSs + "'"
                                + " or tu.vcnucleo like '" + sN + "'"
                                + " or tu.vcnucleo like '" + sAc + "' ";
                        break;
                    case "Pedagogia":
                        sSqlFormatada = " and tu.vcnucleo like '" + sAa + "'"
                                + " or tu.vcnucleo like '" + sPed + "'"
                                + " or tu.vcnucleo like '" + sN + "'"
                                + " or tu.vcnucleo like '" + sAc + "' ";
                        break;
                    case "Psicologia":
                        sSqlFormatada = " and tu.vcnucleo like '" + sAa + "'"
                                + " or tu.vcnucleo like '" + sPsi + "'"
                                + " or tu.vcnucleo like '" + sN + "'"
                                + " or tu.vcnucleo like '" + sAc + "' ";
                        break;
                    case "NAPNE":
                        sSqlFormatada = " and tu.vcnucleo like '" + sN + "' ";
                        break;
                    case "Área comum":
                        sSqlFormatada = " and tu.vcnucleo like '" + sAc + "' ";
                        break;
                    case "Admin":
                        sSqlFormatada = " and tu.vcnucleo like '" + sAa + "'"
                                + " or tu.vcnucleo like '" + sSs + "'"
                                + " or tu.vcnucleo like '" + sPed + "'"
                                + " or tu.vcnucleo like '" + sPsi + "'"
                                + " or tu.vcnucleo like '" + sN + "'"
                                + " or tu.vcnucleo like '" + sAc + "'"
                                + " or tu.vcnucleo like '" + sA + "' ";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Você não tem permissão para realizar esta ação");
                }
                break;
            case 4:
                break;
        }
        return sSqlFormatada;
    }
}
