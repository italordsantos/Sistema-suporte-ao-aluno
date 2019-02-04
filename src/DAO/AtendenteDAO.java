/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.Gerenciamento;
import java.sql.PreparedStatement;
import Modelo.MAtendente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael
 */
public class AtendenteDAO {

    Gerenciamento c;
    MAtendente atendenteLogado;

    public MAtendente getAtendenteLogado(MAtendente atendente) {
        return atendenteLogado = atendente;
    }

    public void setControle(Gerenciamento cp) {
        c = cp;
    }

    public boolean inserir(MAtendente atendente) {
        String sql = "insert into cadastrar_atendente "
                + "(nome, cidade, bairro, siape, datanascimento, celular, telefone, cpf, rg, situacao, email, "
                + "informacoesadicionais, sexo, uf, numerocasa, nucleo, endereco, usuario, senha) "
                + "values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.setString(1, atendente.getNome());
            comando.setString(2, atendente.getCidade());
            comando.setString(3, atendente.getBairro());
            comando.setString(4, atendente.getSiape());
            comando.setString(5, atendente.getDataNascimento());
            comando.setString(6, atendente.getCelular());
            comando.setString(7, atendente.getTelefone());
            comando.setString(8, atendente.getCpf());
            comando.setString(9, atendente.getRg());
            comando.setString(10, atendente.getSituacao());
            comando.setString(11, atendente.getEmail());
            comando.setString(12, atendente.getInformacoesAdicionais());
            comando.setString(13, atendente.getSexo());
            comando.setString(14, atendente.getUf());
            comando.setString(15, atendente.getNumerocasa());
            comando.setString(16, atendente.getNucleo());
            comando.setString(17, atendente.getEndereco());
            comando.setString(18, atendente.getUsuario());
            comando.setString(19, atendente.getSenha());

            comando.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao inserir: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterar(MAtendente atendente) {
        String sql = "update cadastrar_atendente set "
                + "nome = ?, cidade = ?, bairro = ?, datanascimento = ?, celular = ?, telefone = ?, cpf = ?, rg = ?, situacao = ?, email = ?, "
                + "informacoesadicionais = ?, sexo = ?, uf = ?, numerocasa = ?, nucleo = ?, endereco = ?, usuario = ?, senha = ?"
                + "where siape = ? ";

        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.setString(1, atendente.getNome());
            comando.setString(2, atendente.getCidade());
            comando.setString(3, atendente.getBairro());
            comando.setString(4, atendente.getDataNascimento());
            comando.setString(5, atendente.getCelular());
            comando.setString(6, atendente.getTelefone());
            comando.setString(7, atendente.getCpf());
            comando.setString(8, atendente.getRg());
            comando.setString(9, atendente.getSituacao());
            comando.setString(10, atendente.getEmail());
            comando.setString(11, atendente.getInformacoesAdicionais());
            comando.setString(12, atendente.getSexo());
            comando.setString(13, atendente.getUf());
            comando.setString(14, atendente.getNumerocasa());
            comando.setString(15, atendente.getNucleo());
            comando.setString(16, atendente.getEndereco());
            comando.setString(17, atendente.getUsuario());
            comando.setString(18, atendente.getSenha());
            comando.setString(19, atendente.getSiape());

            comando.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("Erro ao alterar: " + ex.getMessage());
        }
        return false;
    }

    public boolean removeAll() {
        String sql = "delete from cadastrar_atendente";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);

            comando.executeUpdate();
            System.out.println("Removidos todos os dados da tabela: " + sql);
        } catch (SQLException ex) {
            Logger.getLogger(AtendenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void removerAtendente(String siape) {
        String sql = "delete from cadastro_aluno where siape = " + siape;
    } 

    public boolean validarSiapeExistente(String siape) {
        String sql = "select * "
                + "from cadastrar_atendente "
                + "where siape like ?";
        boolean achou = false;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, siape);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                achou = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return achou;
    }

    public boolean validarAcesso(String usuario, String senha) {
        String sql = "select * "
                + "from cadastrar_atendente "
                + "where usuario like ? and senha like ?";
        boolean achou = false;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, usuario);
            comando.setString(2, senha);

            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                achou = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return achou;
    }

    public void preencherTabelaPesquisaAtendente(int t, DefaultTableModel tabela, String nome, String siape) {
        try {
            String sql_NnotN = "select * "
                    + "from cadastrar_atendente " // notNull
                    + "where nome like ?";

            String sql_Null = "select * "
                    + "from cadastrar_atendente "; // null

            String sql_SnotN = "select * "
                    + "from cadastrar_atendente " // notNull
                    + "where siape like ?";

            String siap = "%" + siape + "%";
            String nom = "%" + nome + "%";

            try {
                if (t == 0) { // nome
                    if (nome.trim().isEmpty()) {
                        PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                        ResultSet resultadoConsulta = comando.executeQuery();
                        while (resultadoConsulta.next()) {
                            tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("siape"), resultadoConsulta.getString("nucleo")});
                        }
                    } else {
                        PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_NnotN);
                        comando.setString(1, nom);
                        ResultSet resultadoConsulta = comando.executeQuery();
                        while (resultadoConsulta.next()) {
                            tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("siape"), resultadoConsulta.getString("nucleo")});
                        }
                    }
                } else // siape
                 if (siape.trim().isEmpty()) {
                        PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_Null);
                        ResultSet resultadoConsulta = comando.executeQuery();
                        while (resultadoConsulta.next()) {
                            tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("siape"), resultadoConsulta.getString("nucleo")});
                        }
                    } else {
                        PreparedStatement comando = Conexao.getConexao().prepareStatement(sql_SnotN);
                        comando.setString(1, siap);
                        ResultSet resultadoConsulta = comando.executeQuery();
                        while (resultadoConsulta.next()) {
                            tabela.addRow(new Object[]{resultadoConsulta.getString("nome"), resultadoConsulta.getString("siape"), resultadoConsulta.getString("nucleo")});
                        }
                    }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Erro PreparedStatement ~~");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public MAtendente getAtendente(String siape) {
        String sql = "select * "
                + "from cadastrar_atendente "
                + "where siape like ?";
        MAtendente atendente = null;
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            comando.setString(1, siape);
            ResultSet resultadoConsulta = comando.executeQuery();
            if (resultadoConsulta.next()) {
                atendente = new MAtendente(
                        resultadoConsulta.getString("nome"),
                        resultadoConsulta.getString("cidade"),
                        resultadoConsulta.getString("bairro"),
                        resultadoConsulta.getString("siape"),
                        resultadoConsulta.getString("datanascimento"),
                        resultadoConsulta.getString("celular"),
                        resultadoConsulta.getString("telefone"),
                        resultadoConsulta.getString("cpf"),
                        resultadoConsulta.getString("rg"),
                        resultadoConsulta.getString("situacao"),
                        resultadoConsulta.getString("email"),
                        resultadoConsulta.getString("informacoesadicionais"),
                        resultadoConsulta.getString("sexo"),
                        resultadoConsulta.getString("uf"),
                        resultadoConsulta.getString("numerocasa"),
                        resultadoConsulta.getString("nucleo"),
                        resultadoConsulta.getString("endereco"),
                        resultadoConsulta.getString("usuario"),
                        resultadoConsulta.getString("senha")
                );
                return atendente;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return atendente;
    }

}
