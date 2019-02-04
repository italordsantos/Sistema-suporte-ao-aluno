/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ítalo
 */
public class Executa {

    public static void main(String[] args) throws ClassNotFoundException {
        Properties props = new Properties();
        Gerenciamento a = new Gerenciamento();
        props.put("logoString", "");
        com.jtattoo.plaf.texture.TextureLookAndFeel.setTheme(props);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            a.vInicalizarSistema();
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Executa.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        Gerenciamento a = new Gerenciamento();
        a.vInicalizarSistema();*/
    }

}
