/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class Conexao {

    private static Connection conexao;

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                //Conecta com o banco de dados
                conexao = DriverManager.getConnection(
                        //        localização do banco de dados             usuario     senha
                        "jdbc:postgresql://localhost:5432/sistemadesuporteaoaluno", "postgres", "postgres");
                JOptionPane.showMessageDialog(null, "<3 Conexão estabelecida <3");
                
            } catch (SQLException ex) {
                System.out.println("Falha na conexão com o BD: "+
                        ex.getMessage());
            }
        }
              
        return conexao;
    }

}
