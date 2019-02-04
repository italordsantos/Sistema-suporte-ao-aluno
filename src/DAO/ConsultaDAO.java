/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.MConsulta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author italo
 */
public class ConsultaDAO {

    public boolean inserir(MConsulta consulta) {
        /*String sql = "insert into cadastrar_consulta "
                + "(nome, matricula, id, textoConsulta, atendente, siape, "
                + "dataInicio, horaInicio, dataFinal, horaFinal, tituloConsulta, quemPodeVisualizar, quemPodeEditar, estadoDaConsulta, ultimaEdicaoData, "
                + "ultimaEdicaoHora)"
                + "values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.setString(1, consulta.getNome());
            comando.setString(2, consulta.getMatricula());
            comando.setInt(3, consulta.getId());
            comando.setString(4, consulta.getTextoConsulta());
            comando.setString(5, consulta.getAtendente());
            comando.setString(6, consulta.getSiape());
            comando.setString(7, consulta.getDataInicio());
            comando.setString(8, consulta.getHoraInicio());
            comando.setString(9, consulta.getDataFinal());
            comando.setString(10, consulta.getHoraFinal());
            comando.setString(11, consulta.getTituloConsulta());
            comando.setString(12, consulta.getQuemPodeVisualizar());
            comando.setString(13, consulta.getQuemPodeEditar());
            comando.setString(14, consulta.getEstadoDaConsulta());
            comando.setString(15, consulta.getUltimaEdicaoData());
            comando.setString(16, consulta.getUltimaEdicaoHora());

            comando.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
            return false;
        }*/
        return false;
    }

    public boolean alterar(MConsulta consulta) {
/*
        String sql = "update cadastrar_aluno set "
                + "(nome = ?, id = ?, textoConsulta = ?, atendente = ?, siape = ?, "
                + "dataInicio = ?, horaInicio = ?, dataFinal = ?, horaFinal = ?, tituloConsulta = ?, quemPodeVisualizar = ?, quemPodeEditar = ?, estadoDaConsulta = ?, ultimaEdicaoData = ?, "
                + "ultimaEdicaoHora = ?)"
                + "where matricula = ?";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.setString(1, consulta.getNome());
            comando.setInt(2, consulta.getId());
            comando.setString(3, consulta.getTextoConsulta());
            comando.setString(4, consulta.getAtendente());
            comando.setString(5, consulta.getSiape());
            comando.setString(6, consulta.getDataInicio());
            comando.setString(7, consulta.getHoraInicio());
            comando.setString(8, consulta.getDataFinal());
            comando.setString(9, consulta.getHoraFinal());
            comando.setString(10, consulta.getTituloConsulta());
            comando.setString(11, consulta.getQuemPodeVisualizar());
            comando.setString(12, consulta.getQuemPodeEditar());
            comando.setString(13, consulta.getEstadoDaConsulta());
            comando.setString(14, consulta.getUltimaEdicaoData());
            comando.setString(15, consulta.getUltimaEdicaoHora());
            comando.setString(16, consulta.getMatricula());

            comando.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao alterar: " + ex.getMessage());
        }*/
        return false;
    }

    public void preencherTabelaPesquisaConsulta(int t, DefaultTableModel tabela, String nome, String matricula, String tituloDaConsulta) {
        try {
            String sql_NnotN = "select * "
                    + "from cadastrar_consulta " // notNull
                    + "where nome like ?";

            String sql_Null = "select * "
                    + "from cadastrar_consulta "; // null

            String sql_MnotN = "select * "
                    + "from cadastrar_consulta " // notNull
                    + "where matricula like ?";

            String sql_TnotN = "select * "
                    + "from cadastrar_consulta " // notNull
                    + "where tituloconsulta like ?";

            String matric = "%" + matricula + "%";
            String nom = "%" + nome + "%";
            String tituloCons = "%" + tituloDaConsulta + "%";

            try {
                switch (t) {
                    case 0:
                        // nome
                        if (nome.trim().isEmpty()) {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("tituloconsulta")});
                            }
                        } else {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_NnotN);
                            comando.setString(1, nom);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("tituloconsulta")});
                            }
                        }
                        break;
                    case 1:
                        // matricula
                        if (matricula.trim().isEmpty()) {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("tituloconsulta")});
                            }
                        } else {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_MnotN);
                            comando.setString(1, matric);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("tituloconsulta")});
                            }
                        }
                        break;
                    case 2:
                        // titulo da consulta
                        if (tituloDaConsulta.trim().isEmpty()) {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("tituloconsulta")});
                            }
                        } else {
                            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_TnotN);
                            comando.setString(1, tituloCons);
                            ResultSet resultadoConsulta = comando.executeQuery();
                            while (resultadoConsulta.next()) {
                                tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("matricula"), resultadoConsulta.getString("tituloconsulta")});
                            }
                        }
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Erro PreparedStatement ~~");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removerConsulta(DefaultTableModel tabela, String nome, String tituloDaConsulta) {
        String sql = "delete from cadastrar_consulta where tituloconsulta = '" + tituloDaConsulta + "'";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AtendenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
