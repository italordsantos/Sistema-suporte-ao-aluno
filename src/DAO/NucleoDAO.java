/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.Gerenciamento;
import Modelo.MNucleo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author italo
 */
public class NucleoDAO {

    Gerenciamento c;

    public void setControle(Gerenciamento cp) {
        c = cp;
    }

    public boolean bCadastrarNucleo(MNucleo mNucleoRecebido) {
        String sSql = "insert into tabela_nucleo (vcnome, vcpa) values (?, ?)";
        boolean bCadastrou = false;
        String a = null;
        try {
            PreparedStatement psComando = Conexao.getConexao().prepareStatement(sSql);
            psComando.setString(1, mNucleoRecebido.getsNome());
            psComando.setString(2, mNucleoRecebido.getsPermissoesDeAcesso());
            psComando.executeUpdate();
            bCadastrou = true;
            System.out.println("asd");
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar " + ex.getMessage());
        }
        return bCadastrou;
    }

    public int getId(String sNomeRecebido) {
        String sSql = "select * from tabela_nucleo where vcnome like ?";
        int iId = -1;
        try {
            PreparedStatement psComando = Conexao.getConexao().prepareStatement(sSql);
            psComando.setString(1, sNomeRecebido);
            ResultSet resultadoConsulta = psComando.executeQuery();
            if (resultadoConsulta.next()) {
                iId = resultadoConsulta.getInt("seid");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar " + ex.getMessage());
        }
        return iId;
    }

    public String getNomeNucleo(int iIdRecebido) {
        String sSql = "select * from tabela_nucleo where seid = ?",
                sNomeObtido = null;
        try {
            PreparedStatement psComando = Conexao.getConexao().prepareStatement(sSql);
            psComando.setInt(1, iIdRecebido);
            ResultSet resultadoConsulta = psComando.executeQuery();
            if (resultadoConsulta.next()) {
                sNomeObtido = resultadoConsulta.getString("vcnome");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar " + ex.getMessage());
        }
        return sNomeObtido;
    }

    public boolean bValidarNucleoExistente(String sNomeRecebido) {
        String sSql = "select * from tabela_nucleo where vcnome like ?";
        boolean bAchou = false;
        try {
            PreparedStatement psComando = Conexao.getConexao().prepareStatement(sSql);
            psComando.setString(1, sNomeRecebido);
            ResultSet resultadoConsulta = psComando.executeQuery();
            if (resultadoConsulta.next()) {
                bAchou = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return bAchou;
    }

    public void jComboBoxNucleo(JComboBox jcbModel) {
        String sAa = "Assistente de aluno", //1
                sSs = "Serviço social", //2
                sPed = "Pedagogia", //3
                sPsi = "Psicologia", //4
                sN = "NAPNE", //5
                sAc = "Área comum", //6
                sA = "Admin"; //7
        String sNucleoLogado = c.getmUsuarioLogado().getsNucleo();
        try {
            String sSql = "select * from tabela_nucleo where vcnome like " + sNucleoLogado;
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sSql);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void vPreencherTabelaPesquisarNucleoDAO(DefaultTableModel tabela, String sNomeRecebido) {
        try {
            String slkNucleo = "'%" + sNomeRecebido + "%'"; // string like nucleo
            String sSql = "select * from tabela_nucleo where vcnome like " + slkNucleo;
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sSql);
            ResultSet resultadoConsulta = comando.executeQuery();
            while (resultadoConsulta.next()) {
                tabela.addRow(new Object[]{resultadoConsulta.getInt("seid"), resultadoConsulta.getString("vcnome"), resultadoConsulta.getString("vcpa")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean rRemoverAllNucleo() {
        String sql = "delete from tabela_nucleo";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean rRemoverNucleo(String sNomeNucleo) {
        String sql = "delete from tabela_nucleo where " + sNomeNucleo;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public String convertToString(List<String> lRecebido) {
        String sNucleoFormatado = null;
        for (int i = 0; i < lRecebido.size(); i++) {
            if (i > 0) {
                sNucleoFormatado += "," + (String) lRecebido.get(i);
            } else {
                sNucleoFormatado = (String) lRecebido.get(i);
            }
        }
        return sNucleoFormatado;
    }

    public String[] convertToStringString(String sRecebida) {
        return sRecebida.split(",");
    }

    public String getNomes() {
        String sSql = "select * from tabela_nucleo";
        String sDados = null;
        int i = 0;
        System.out.println("1");
        try {
            System.out.println("2");
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sSql);
            System.out.println("3");
            ResultSet resultadoConsulta = comando.executeQuery();
            System.out.println("4");
            while (resultadoConsulta.next()) {
                if (i > 0) {

                } else {

                }
                i++;
                System.out.println("5");
                sDados += resultadoConsulta.getString("vcnome");
            }
            System.out.println("asd");
        } catch (Exception ex) {
            System.out.println(getClass() + " " + ex);
        }
        return sDados;
    }

    public void fillComponent(int iOpcao, DefaultListModel lRecebido) {
        if (iOpcao == 0) {
            lRecebido.addElement("Admin");
        } else {
            String sSql = "select vcnome from tabela_nucleo";
            try {
                PreparedStatement psComando = Conexao.getConexao().prepareStatement(sSql);
                ResultSet resultadoConsulta = psComando.executeQuery();
                while (resultadoConsulta.next()) {
                    lRecebido.addElement(resultadoConsulta.getString("vcnome"));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
