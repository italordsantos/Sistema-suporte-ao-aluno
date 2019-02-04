/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author italo
 */
public class MAtendente implements Serializable{
    String nome;
    String cidade;
    String bairro;
    String siape;
    String dataNascimento;
    String celular;
    String telefone;
    String cpf;
    String rg;
    String situacao;
    String email;
    String informacoesAdicionais;
    String sexo;
    String uf;
    String numerocasa;
    String nucleo;
    String endereco;
    String usuario;
    String senha;
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getNucleo() {
        return this.nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getSiape() {
        return this.siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformacoesAdicionais() {
        return this.informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumerocasa() {
        return this.numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
        this.numerocasa = numerocasa;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public MAtendente(String nome, String cidade, String bairro, String siape, String dataNascimento, String celular, String telefone, String cpf, String rg, String situacao, String email, String informacoesAdicionais, String sexo, String uf, String numerocasa, String nucleo, String endereco, String usuario, String senha) {
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.siape = siape;
        this.dataNascimento = dataNascimento;
        this.celular = celular;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.situacao = situacao;
        this.email = email;
        this.informacoesAdicionais = informacoesAdicionais;
        this.sexo = sexo;
        this.uf = uf;       
        this.numerocasa = numerocasa;
        this.nucleo = nucleo;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }
    
}
