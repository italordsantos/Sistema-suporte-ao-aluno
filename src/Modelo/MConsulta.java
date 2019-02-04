/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author italo
 */
public class MConsulta implements Serializable {

    MAluno mAluno;
    MUsuario mUsuario;
    int iId;
    String sTextoDaConsulta;
    Date dDataInicioDaConsulta;
    Date dHoraInicioDaConsulta;
    Date dDataFinalDaConsulta;
    Date dHoraFinalDaConsulta;
    String sTituloDaConsulta;
    String sQuemPodeVisualizar;
    String sQuemPodeEditar;
    String sEstadoDaConsulta;
    Date dDataUltimaEdicao;
    Date dHoraUltimaEdicao;

    public MAluno getmAluno() {
        return mAluno;
    }

    public void setmAluno(MAluno mAluno) {
        this.mAluno = mAluno;
    }

    public MUsuario getmUsuario() {
        return mUsuario;
    }

    public void setmUsuario(MUsuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getsTextoDaConsulta() {
        return sTextoDaConsulta;
    }

    public void setsTextoDaConsulta(String sTextoDaConsulta) {
        this.sTextoDaConsulta = sTextoDaConsulta;
    }

    public Date getdDataInicioDaConsulta() {
        return dDataInicioDaConsulta;
    }

    public void setdDataInicioDaConsulta(Date dDataInicioDaConsulta) {
        this.dDataInicioDaConsulta = dDataInicioDaConsulta;
    }

    public Date getdHoraInicioDaConsulta() {
        return dHoraInicioDaConsulta;
    }

    public void setdHoraInicioDaConsulta(Date dHoraInicioDaConsulta) {
        this.dHoraInicioDaConsulta = dHoraInicioDaConsulta;
    }

    public Date getdDataFinalDaConsulta() {
        return dDataFinalDaConsulta;
    }

    public void setdDataFinalDaConsulta(Date dDataFinalDaConsulta) {
        this.dDataFinalDaConsulta = dDataFinalDaConsulta;
    }

    public Date getdHoraFinalDaConsulta() {
        return dHoraFinalDaConsulta;
    }

    public void setdHoraFinalDaConsulta(Date dHoraFinalDaConsulta) {
        this.dHoraFinalDaConsulta = dHoraFinalDaConsulta;
    }

    public String getsTituloDaConsulta() {
        return sTituloDaConsulta;
    }

    public void setsTituloDaConsulta(String sTituloDaConsulta) {
        this.sTituloDaConsulta = sTituloDaConsulta;
    }

    public String getsQuemPodeVisualizar() {
        return sQuemPodeVisualizar;
    }

    public void setsQuemPodeVisualizar(String sQuemPodeVisualizar) {
        this.sQuemPodeVisualizar = sQuemPodeVisualizar;
    }

    public String getsQuemPodeEditar() {
        return sQuemPodeEditar;
    }

    public void setsQuemPodeEditar(String sQuemPodeEditar) {
        this.sQuemPodeEditar = sQuemPodeEditar;
    }

    public String getsEstadoDaConsulta() {
        return sEstadoDaConsulta;
    }

    public void setsEstadoDaConsulta(String sEstadoDaConsulta) {
        this.sEstadoDaConsulta = sEstadoDaConsulta;
    }

    public Date getdDataUltimaEdicao() {
        return dDataUltimaEdicao;
    }

    public void setdDataUltimaEdicao(Date dDataUltimaEdicao) {
        this.dDataUltimaEdicao = dDataUltimaEdicao;
    }

    public Date getdHoraUltimaEdicao() {
        return dHoraUltimaEdicao;
    }

    public void setdHoraUltimaEdicao(Date dHoraUltimaEdicao) {
        this.dHoraUltimaEdicao = dHoraUltimaEdicao;
    }

}
