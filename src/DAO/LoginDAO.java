/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author italo
 */
import Controle.Gerenciamento;
import java.sql.PreparedStatement;
import Modelo.MLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class LoginDAO {

    Gerenciamento c;
    MLogin mLoginPublic;
    UsuarioDAO uDAO;
    boolean bAchou = false;

    public void setControle(Gerenciamento cp) {
        c = cp;
    }

    public boolean bCadastrarLoginDAO(MLogin mLogin) {
        String sql = "insert into tabela_login "
                + "(vcsiape, vcusuario, vcsenha) "
                + "values "
                + "(?, ?, ?)";

        try {
            PreparedStatement psComando = Conexao.getConexao().prepareStatement(sql);
            psComando.setString(1, mLogin.getsSiape());
            psComando.setString(2, mLogin.getsUsuario());
            psComando.setString(3, mLogin.getsSenha());
            psComando.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar " + ex.getMessage());
            return false;
        }
    }

    public boolean bValidarAcesso(String sUsuario, String sSenha) {
        String sql = "select * "
                + "from tabela_login "
                + "where vcusuario like ? and vcsenha like ?";
        mLoginPublic = new MLogin();
        uDAO = new UsuarioDAO();
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, sUsuario);
            comando.setString(2, sSenha);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                bAchou = true;
                mLoginPublic.setsUsuario(resultadoConsulta.getString("vcusuario"));
                mLoginPublic.setsSenha(resultadoConsulta.getString("vcsenha"));
                mLoginPublic.setsSiape(resultadoConsulta.getString("vcsiape"));
                mLoginPublic.setiId(resultadoConsulta.getInt("seid"));
                System.out.println("Serial id: " + mLoginPublic.getiId());
                System.out.println("Siape banco: " + mLoginPublic.getsSiape());
                c.setmUsuarioLogado(uDAO.muGetUsuarioDAO(resultadoConsulta.getInt("seid")));
                System.out.println(c.getmUsuarioLogado().getsNucleo());
                c.setmLoginLogado(mLoginPublic);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return bAchou;
    }

    public boolean bValidarLoginExistente(String sUsuario) {
        String sql = "select * "
                + "from tabela_login "
                + "where vcusuario like ?";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, sUsuario);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                bAchou = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return bAchou;
    }

    public boolean bValidarSiapeEEmail(String sSiape, String sEmail) {
        String sql = "select * "
                + "from tabela_usuario "
                + "where vcemail like ? and vcsiape like ?";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, sEmail);
            comando.setString(2, sSiape);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                bAchou = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return bAchou;
    }

    public boolean bAlterarLogin(int iOQueFazer, MLogin mLoginRecebido, String sEmail) {
        String sqlAlterarSenha = "update tabela_login set "
                + "vcsenha = ? "
                + "where vcusuario = ? ",
                sqlAlterarUsuario = "update tabela_login set "
                + "vcusuario = ?"
                + "where vcsiape = ?",
                sqlAlterarUsuarioESenha = "update tabela_login set "
                + "vcusuario = ?, vcsenha = ? "
                + "where seid = ? ";

        try {
            /*
             * 1 - esqueci a senha
             * 2 - esqueci o usuario (um unico usuario com o email)
             * 3 - alterar usuario e senha
             */
            switch (iOQueFazer) {
                case 1:
                    PreparedStatement psSenha = Conexao.getConexao().prepareStatement(sqlAlterarSenha);
                    psSenha.setString(1, mLoginRecebido.getsSenha());
                    psSenha.setString(2, mLoginRecebido.getsUsuario());
                    psSenha.executeUpdate();
                    break;
                case 2:
                    PreparedStatement psUsuarioComSiape = Conexao.getConexao().prepareStatement(sqlAlterarUsuario);
                    psUsuarioComSiape.setString(1, mLoginRecebido.getsUsuario());
                    psUsuarioComSiape.setString(2, mLoginRecebido.getsSiape());
                    psUsuarioComSiape.executeUpdate();
                    break;
                case 3:
                    System.out.println(mLoginRecebido.getiId());
                    PreparedStatement psUsuarioESenha = Conexao.getConexao().prepareStatement(sqlAlterarUsuarioESenha);
                    psUsuarioESenha.setString(1, mLoginRecebido.getsUsuario());
                    psUsuarioESenha.setString(2, mLoginRecebido.getsSenha());
                    psUsuarioESenha.setInt(3, mLoginRecebido.getiId());
                    psUsuarioESenha.executeUpdate();
                    break;
                default:
                    break;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void bRecriarLoginDAO(MLogin mLogin) {
        String sql = "delete from tabela_login where vcsiape = '" + mLogin.getsSiape() + "'";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possível removê-lo");
        }
        bCadastrarLoginDAO(mLogin);
    }

    public boolean rRemoverAllLogin() {
        String sql = "delete from tabela_login";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void vPreencherTabelaPesquisarUsuarioHueHueDAO(DefaultTableModel tabela) {
        try {
            String sSqlSN = "select tl.* from tabela_login tl ";
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sSqlSN);
            ResultSet resultadoConsulta = comando.executeQuery();
            uDAO = new UsuarioDAO();
            while (resultadoConsulta.next()) {
                tabela.addRow(new Object[]{resultadoConsulta.getInt("seid"), resultadoConsulta.getString("vcsiape"), resultadoConsulta.getString("vcusuario"), resultadoConsulta.getString("vcsenha"), uDAO.muGetUsuarioDAO(resultadoConsulta.getInt("seid")).getsNucleo()});
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
