/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author italo
 */
public class MNucleo {

    String sNome,
            sPermissoesDeAcesso;
    List<String> lPermissoesDeAcesso;
    int iId;

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public List<String> getlPermissoesDeAcesso() {
        return lPermissoesDeAcesso;
    }

    public void setlPermissoesDeAcesso(List<String> lPermissoesDeAcesso) {
        this.lPermissoesDeAcesso = lPermissoesDeAcesso;
    }

    public String getsPermissoesDeAcesso() {
        return sPermissoesDeAcesso;
    }

    public void setsPermissoesDeAcesso(String sPermissoesDeAcesso) {
        this.sPermissoesDeAcesso = sPermissoesDeAcesso;
    }
    
    
}
