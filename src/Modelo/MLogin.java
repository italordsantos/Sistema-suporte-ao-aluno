/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author italo
 */
public class MLogin {
    String sUsuario,
            sSenha,
            sSiape;
    int iId;

    public String getsUsuario() {
        return sUsuario;
    }

    public void setsUsuario(String sUsuario) {
        this.sUsuario = sUsuario;
    }

    public String getsSenha() {
        return sSenha;
    }

    public void setsSenha(String sSenha) {
        this.sSenha = sSenha;
    }

    public String getsSiape() {
        return sSiape;
    }

    public void setsSiape(String sSiape) {
        this.sSiape = sSiape;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }
    
}
