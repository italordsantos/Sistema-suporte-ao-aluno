/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Ítalo
 */
public class MAluno implements Serializable {

    String sNome;
    String sCidade;
    String sBairro;
    String sMatricula;
    String sCurso;
    String sDataNascimento;
    String sCelular;
    String sTelefone;
    String sCpf;
    String sRg;
    String sSituacao;
    String sEmail;
    boolean bNecessidadesEspecificas = false;
    String sInformacoesAdicionais;
    String sSexo;
    String sUf;
    String sNumeroCasa;
    String sEndereco;
    boolean bAlunoAtivo = true;
    String sMatriculaFilho;

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public String getsCidade() {
        return sCidade;
    }

    public void setsCidade(String sCidade) {
        this.sCidade = sCidade;
    }

    public String getsBairro() {
        return sBairro;
    }

    public void setsBairro(String sBairro) {
        this.sBairro = sBairro;
    }

    public String getsMatricula() {
        return sMatricula;
    }

    public void setsMatricula(String sMatricula) {
        this.sMatricula = sMatricula;
    }

    public String getsCurso() {
        return sCurso;
    }

    public void setsCurso(String sCurso) {
        this.sCurso = sCurso;
    }

    public String getsDataNascimento() {
        return sDataNascimento;
    }

    public void setsDataNascimento(String sDataNascimento) {
        this.sDataNascimento = sDataNascimento;
    }

    public String getsCelular() {
        return sCelular;
    }

    public void setsCelular(String sCelular) {
        this.sCelular = sCelular;
    }

    public String getsTelefone() {
        return sTelefone;
    }

    public void setsTelefone(String sTelefone) {
        this.sTelefone = sTelefone;
    }

    public String getsCpf() {
        return sCpf;
    }

    public void setsCpf(String sCpf) {
        this.sCpf = sCpf;
    }

    public String getsRg() {
        return sRg;
    }

    public void setsRg(String sRg) {
        this.sRg = sRg;
    }

    public String getsSituacao() {
        return sSituacao;
    }

    public void setsSituacao(String sSituacao) {
        this.sSituacao = sSituacao;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsInformacoesAdicionais() {
        return sInformacoesAdicionais;
    }

    public void setsInformacoesAdicionais(String sInformacoesAdicionais) {
        this.sInformacoesAdicionais = sInformacoesAdicionais;
    }

    public String getsSexo() {
        return sSexo;
    }

    public void setsSexo(String sSexo) {
        this.sSexo = sSexo;
    }

    public String getsUf() {
        return sUf;
    }

    public void setsUf(String sUf) {
        this.sUf = sUf;
    }

    public String getsNumeroCasa() {
        return sNumeroCasa;
    }

    public void setsNumeroCasa(String sNumeroCasa) {
        this.sNumeroCasa = sNumeroCasa;
    }

    public String getsEndereco() {
        return sEndereco;
    }

    public void setsEndereco(String sEndereco) {
        this.sEndereco = sEndereco;
    }

    public boolean isbNecessidadesEspecificas() {
        return bNecessidadesEspecificas;
    }

    public void setbNecessidadesEspecificas(boolean bNecessidadesEspecificas) {
        this.bNecessidadesEspecificas = bNecessidadesEspecificas;
    }

    public boolean isbAlunoAtivo() {
        return bAlunoAtivo;
    }

    public void setbAlunoAtivo(boolean bAlunoAtivo) {
        this.bAlunoAtivo = bAlunoAtivo;
    }
    
    public String getsMatriculaFilho() {
        return sMatriculaFilho;
    }

    public void setsMatriculaFilho(String sMatriculaFilho) {
        this.sMatriculaFilho = sMatriculaFilho;
    }
    
}
