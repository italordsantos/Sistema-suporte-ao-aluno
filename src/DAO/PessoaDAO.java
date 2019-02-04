/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author italo
 */
public class PessoaDAO {

    public String sGetPessoaAleatoria() {
        String sPessoa = null;
        String sql = "SELECT nome FROM tabela_pessoa ORDER BY RANDOM() LIMIT 1";
        try {
            PreparedStatement comando = Conexao.getConexao().prepareStatement(sql);
            ResultSet resultadoConsulta = comando.executeQuery();
            if(resultadoConsulta.next()){
                sPessoa = resultadoConsulta.getString("nome");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return sPessoa;
    }
}
