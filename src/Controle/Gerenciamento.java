/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.AlunoDAO;
import DAO.UsuarioDAO;
import DAO.LoginDAO;
import DAO.NucleoDAO;
import Modelo.MAluno;
import Modelo.MConsulta;
import Modelo.MLogin;
import Modelo.MNucleo;
import Modelo.MUsuario;
import Visao.TCadastrarEditarUsuario;
import Visao.TLogin;
import Visao.TPrincipal;
import Visao.TCadastrarEditarAluno;
import Visao.TPesquisarAluno;
import Visao.TPesquisarUsuario;
import Visao.TCadastrarEditarConsulta;
import Visao.TCadastrarEditarNucleo;
import Visao.TPesquisarConsulta;
import Visao.TPesquisarLOGIN;
import Visao.TPesquisarNucleo;
import Visao.TRedefinirLogin;
import Visao.TRelatorioAluno;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JTextField;

/**
 *
 * @author Ítalo
 */
public class Gerenciamento {

    /*
     * Área de variáveis e seus contrutores:
     */
    TCadastrarEditarAluno tCadastrarEditarAluno;
    TCadastrarEditarUsuario tCadastrarEditarUsuario;
    TLogin tLogin;
    TPrincipal tPrincipal;
    TRedefinirLogin tRedefineLogin;
    TPesquisarAluno tPesquisarAluno;
    TCadastrarEditarConsulta tCadastrarEditarConsulta;
    TPesquisarConsulta tPesquisarConsulta;
    TPesquisarUsuario tPesquisarUsuario;
    TRelatorioAluno tRelatorioAluno;
    TCadastrarEditarNucleo tCadastrarEditarNucleo;
    TPesquisarLOGIN tPesquisarLOGIN;
    TPesquisarNucleo tPesquisarNucleo;
    MLogin mLoginLogado;
    LoginDAO loginDAO;
    UsuarioDAO usuarioDAO;
    MUsuario mUsuario,
            mUsuarioLogado;
    MLogin mLogin;
    MNucleo mNucleo;
    NucleoDAO ndao;
    String stNCAluno = "Cadastrar aluno",
            stNEAluno = "Editar aluno",
            stNCUsuario = "Cadastrar usuário",
            stNEUsuario = "Editar usuário",
            stNRUsuario = "Redefinir dados",
            stNPUsuario = "Pesquisar usuário",
            stNCConsulta = "Cadastrar consulta",
            stNEConsulta = "Editar consulta",
            stNPAluno = "Pesquisar aluno",
            stNRedefiniLogin = "Redefinir login";
    boolean bAchou = false,
            bTeste = true;

    public MLogin getmLoginLogado() {
        return this.mLoginLogado;
    }

    public void setmLoginLogado(MLogin mLoginLogado) {
        this.mLoginLogado = mLoginLogado;
    }

    public MUsuario getmUsuarioLogado() {
        return mUsuarioLogado;
    }

    public void setmUsuarioLogado(MUsuario mUsuarioLogado) {
        this.mUsuarioLogado = mUsuarioLogado;
    }

    /*
     * Funções do sistema
     */
    public void vInicalizarSistema() {
        vCadastrarUsuarioDefault();
        vAbrirTelaLogin(0);
    }

    public void vEncerrarSistema() {
        System.exit(0);
    }

    /*
     * Abertura e encerramento de telas
     */
    //-------------------------------------------------------------------------------------------------
    public void vAbrirTelaPesquisarLOGIN() {
        tPesquisarLOGIN = new TPesquisarLOGIN();
        tPesquisarLOGIN.setControle(this);
        tPesquisarLOGIN.setVisible(true);
    }

    public void vAbrirTelaLogin(int iDeOndeVeio) {
        //1 == tPrincipal
        tLogin = new TLogin();
        tLogin.setControle(this);
        tLogin.setVisible(true);
        if (iDeOndeVeio == 1) {
            tPrincipal.dispose();
        }
    }

    public void vAbrirTelaPrincipal(int iDeOndeVeio, int iOpcaoDaTela) {
        /* 0 = tLogin
         * 1 = tCadastrarEditarAluno
         * 2 = tPesquisarAluno
         * 3 = tPesquisarConsulta
         * 4 = tRedefinirLogin
         * 5 = tPesquisarUsuario
         * 6 = tCadastrarEditarUsuario
         * 7 = tCadastrarEditarNucleo
         * 8 = tPesquisarNucleo
         */
        tPrincipal = new TPrincipal();
        tPrincipal.setVisible(true);
        tPrincipal.setControle(this);
        switch (iDeOndeVeio) {
            case 0:
                tLogin.dispose();
                break;
            case 1:
                tCadastrarEditarAluno.dispose();
                break;
            case 2:
                tPesquisarAluno.dispose();
                break;
            case 3:
                tPesquisarConsulta.dispose();
                break;
            case 4:
                tRedefineLogin.dispose();
                break;
            case 5:
                tPesquisarUsuario.dispose();
                break;
            case 6:
                tCadastrarEditarUsuario.dispose();
                break;
            case 7:
                tCadastrarEditarNucleo.dispose();
                break;
            case 8:
                tPesquisarNucleo.dispose();
            default:
                break;
        }
    }

    public void vAbrirTelaRedefinirLogin() {
        tRedefineLogin = new TRedefinirLogin();
        tRedefineLogin.setVisible(true);
        tRedefineLogin.setControle(this);
        tRedefineLogin.setTitle(stNRedefiniLogin);
        tPrincipal.dispose();
    }

    public void vAbrirTelaCadastrarEditarUsuario(int iDeOndeVeio, DefaultTableModel dtmTabela, MUsuario mUsuarioRecebido) {
        /* 0 - tPrincipal -> Usuario -> Cadastrar
         * 1 - tPrincipal -> Gerenciar -> redefinir meus dados (editar)  
         * 2 - tPesquisarUsuario -> Editar
         */
        tCadastrarEditarUsuario = new TCadastrarEditarUsuario();
        tCadastrarEditarUsuario.setContole(this);
        tCadastrarEditarUsuario.setTipo(iDeOndeVeio);
        tCadastrarEditarUsuario.setUsuarioLogado(mUsuarioRecebido);
        tCadastrarEditarUsuario.setTabela(dtmTabela);
        tCadastrarEditarUsuario.setVisible(true);
        switch (iDeOndeVeio) {
            case 0:
                tPrincipal.dispose();
                tCadastrarEditarUsuario.setTitle(stNCUsuario);
                break;
            case 1:
                tPrincipal.dispose();
                tCadastrarEditarUsuario.setTitle(stNRUsuario);
                break;
            case 2:
                tPesquisarUsuario.dispose();
                tCadastrarEditarUsuario.setTitle(stNEUsuario);
                break;
            default:
                break;
        }
    }

    public void vAbrirTelaPesquisarUsuario(int iDeOndeVeio) {
        tPesquisarUsuario = new TPesquisarUsuario();
        tPesquisarUsuario.setControle(this);
        tPesquisarUsuario.setVisible(true);
        tPesquisarUsuario.setTitle(stNPUsuario);
        if (iDeOndeVeio == 0) {
            tPrincipal.dispose();
        } else {
            tCadastrarEditarUsuario.dispose();
        }
    }

    public void vAbrirTelaCadastrarEditarNucleo(int iFuncao) {
        tCadastrarEditarNucleo = new TCadastrarEditarNucleo();
        tCadastrarEditarNucleo.setControle(this);
        tCadastrarEditarNucleo.setVisible(true);
        tCadastrarEditarNucleo.setCadastrarOuEditar(iFuncao);
        tPrincipal.dispose();
    }

    public void vAbrirTelaPesquisarNucleo() {
        tPesquisarNucleo = new TPesquisarNucleo();
        tPesquisarNucleo.setControle(this);
        tPesquisarNucleo.setVisible(true);
        tPrincipal.dispose();
    }

    /*
     * Funcionalidade das telas
     */
    public boolean bCadastrarAluno(MAluno mAluno) {
        try {
            AlunoDAO alunoDAO = new AlunoDAO();
            boolean inseriu = alunoDAO.bCadastrarAlunoDAO(mAluno);
            boolean cadastrou = false;
            if (inseriu) {
                cadastrou = true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Tente novamente.");
            }
            return cadastrou;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar");
            return false;
        }
    }

    public boolean bCadastrarAtendente(MUsuario mUsuario) {
        try {
            UsuarioDAO atendenteDAO = new UsuarioDAO();
            boolean inseriu = atendenteDAO.bCadastrarUsuarioDAO(mUsuario);
            boolean cadastrou = false;
            if (inseriu) {
                cadastrou = true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Tente novamente.");
            }
            return cadastrou;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar atendente");
            return false;
        }
    }

    public boolean bCadastrarConsulta(MConsulta consulta) {
        /*try {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            boolean inseriu = consultaDAO.inserir(consulta);
            boolean cadastrou = false;
            if (inseriu) {
                cadastrou = true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir! Tente novamente.");
            }
            return cadastrou;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a consulta");
            return false;
        }*/
        return false;
    }

    public boolean bEditarAluno(MAluno aluno) { // Editar aluno com banco
        /*AlunoDAO dao = new AlunoDAO();
        boolean editou = dao.alterar(aluno);
        boolean cadastrou = false;

        if (editou) {
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
            tCadastrarEditarAluno.setContole(this);
            tPrincipal.setControle(this);
            cadastrou = true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar! Tente novamente.");
        }*/

        return false;
    }

    public boolean bEditarAtendente(MUsuario mUsuario) {
        /*UsuarioDAO dao = new UsuarioDAO();

        boolean editou = dao.alterar(atendente);
        boolean cadastrou = false;

        if (editou) {
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
            tCadastrarEditarUsuario.setContole(this);
            tPrincipal.setControle(this);
            cadastrou = true;

        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar! Tente novamente.");

        }*/

        return false;
    }

    public boolean bCadastrarNucleo(MNucleo mNucleoRecebido, int iCadastrarOuEditar) {
        ndao = new NucleoDAO();
        ndao.setControle(this);

        if (mNucleoRecebido.getsNome().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo não pode ficar em branco");
        } else if (ndao.bValidarNucleoExistente(mNucleoRecebido.getsNome())) {
            JOptionPane.showMessageDialog(null, "Já existe um núcleo no sistema com este mesmo nome");
        } else if (iCadastrarOuEditar == 0) {
            ndao.bCadastrarNucleo(mNucleoRecebido);
        } else if (iCadastrarOuEditar == 1) {
        }
        return true;
    }

    /*
     * Validar e obter dados
     */
    public boolean bValidarAcessoTPesquisa(int opcaoSelecionada, String nucleoDaConsulta, String nucleoLogado) {
        /*
        10 - assistente social 
        11 - serviço social 
        12 - pedagogia 
        13 - psicologia 
        14 - NAPNE 
        15 - area comum 
        ----------------------
        10 - 10, 15 
        11 - 10, 11, 14, 15 
        12 - 10, 11, 14, 15 
        13 - 10, 13, 14, 15 
        14 - 14 
        15 - 15 
         */
        // acesso negado
        /*if (nucleoDaConsulta == 10 && nucleoLogado != 10 || nucleoLogado != 16) {
            saida = false;
        } else if (nucleoDaConsulta == 11 && nucleoLogado != 10 || nucleoLogado != 11 || nucleoLogado != 14 || nucleoLogado != 15) {
            saida = false;
        } else if (nucleoDaConsulta == 12 && nucleoLogado != 10 || nucleoLogado != 12 || nucleoLogado != 14 || nucleoLogado != 15) {
            saida = false;
        } else if (nucleoDaConsulta == 13 && nucleoLogado != 10 || nucleoLogado != 13 || nucleoLogado != 14 || nucleoLogado != 15) {
            saida = false;
        } else if (nucleoDaConsulta == 14 && nucleoLogado != 14) {
            saida = false;
        } else if (nucleoDaConsulta == 15 && nucleoLogado != 15) {
            saida = false;
        } else {
            saida = false;
        }*/

        boolean saida;
        switch (opcaoSelecionada) {
            case 0:
                saida = bValidarAcessoDados(nucleoDaConsulta, nucleoLogado);
                break;

            case 1:
                saida = bValidarAcessoDados(nucleoDaConsulta, nucleoLogado);
                break;

            case 2:
                saida = bValidarAcessoDados(nucleoDaConsulta, nucleoLogado);
                break;

            case 3:
                saida = bValidarAcessoDados(nucleoDaConsulta, nucleoLogado);
                break;

            default:
                saida = false;
                break;
        }
        return saida;
    }

    public boolean bValidarAcessoDados(String nucleoDaConsulta, String nucleoLogado) {
        boolean saida = true;
        return saida;
    }

    public boolean bIsLetter(String sLetra) {
        String isLetter = "1234567890-=!@#$%¨&*()_+¹²³£¢¬§´`[]{}~^ªº°;:?,.<>|";
        return isLetter.contains(sLetra);
    }

    public boolean bIsNumber(String sNumero) {
        String isNumber = "abcçdefghijklmnopqrstuvwxyzABCÇDEFGHIJKLMNOPQRSTFVWXYZ-=!@#$%¨&*()_+¹²³£¢¬§´`[]{}~^ªº°;:?,.<>|";
        return isNumber.contains(sNumero);
    }

    public boolean bIsEmail(String sEmail) {
        String sGmail = "@gmail.com", sHotmail = "@hotmail.com", sIfpr = "@ifpr.edu.br";
        return sEmail.contains(sGmail) || sEmail.contains(sHotmail) || sEmail.contains(sIfpr);
    }

    public boolean bValidarSenha(String sSenhaInformada) {
        return bTeste;
    }

    public String sGetSMTP(String email) {

        return "";
    }

    public String sGerarSenhaAlfanumerica() {
        int iASCII, iMax = 0;
        char cLetra;
        String sSenha = "";
        Random rRandom = new Random();
        while (iMax < 9) {
            iMax++;
            iASCII = rRandom.nextInt(25) + 97; // letras minúsculas
            cLetra = (char) iASCII;
            sSenha += cLetra;
            iASCII = rRandom.nextInt(9) + 48; // números
            cLetra = (char) iASCII;
            sSenha += cLetra;
            iASCII = rRandom.nextInt(25) + 65; // LETRAS MAIÚSCULAS
            cLetra = (char) iASCII;
            sSenha += cLetra;
        }
        return sSenha;
    }

    public String sGerarUsuarioAleatorio() {
        int iASCII, iMax = 0;
        char cLetra;
        String sUsuario = "";
        Random rRandom = new Random();
        loginDAO = new LoginDAO();
        do {
            while (iMax < 4) {
                iMax++;
                iASCII = rRandom.nextInt(25) + 97; // letras minúsculas
                cLetra = (char) iASCII;
                sUsuario += cLetra;
                iASCII = rRandom.nextInt(25) + 65; // LETRAS MAIÚSCULAS
                cLetra = (char) iASCII;
                sUsuario += cLetra;
            }
        } while (loginDAO.bValidarLoginExistente(sUsuario));
        return sUsuario;
    }

    public String sGerarSiapeAleatorio() {
        usuarioDAO = new UsuarioDAO();
        int iASCII, iMax = 0;
        char cLetra;
        String sSenha = "";
        Random rRandom = new Random();
        do {
            while (iMax < 9) {
                iASCII = rRandom.nextInt(9) + 48; // números
                cLetra = (char) iASCII;
                sSenha += Character.toString(cLetra);
                iMax++;
            }
        } while (usuarioDAO.bValidarSiapeExistenteDAO(sSenha));
        return sSenha;
    }

    /*
     * Logins e permissões ao sistema
     */
    public void vEsqueciUsuario() {
        usuarioDAO = new UsuarioDAO();
        loginDAO = new LoginDAO();
        mLogin = new MLogin();
        JTextField jtfJOP = new JTextField();
        String sEmailDigitadoJOP, sUsuarioAlterado = sGerarUsuarioAleatorio(), sSiapeDigitadoJOP = null;
        sEmailDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "Insira seu email:", "");
        if (sEmailDigitadoJOP == null) {
            return;
        }
        while (!bIsEmail(sEmailDigitadoJOP) || usuarioDAO.iValidarEmailUsuarioDAO(sEmailDigitadoJOP) == 0) {
            sEmailDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "Não existe um usuário no sistema "
                    + "que possua o email:" + sEmailDigitadoJOP + " insira um email válido: ", "");
            if (sEmailDigitadoJOP == null) {
                return;
            }
        }
        if (usuarioDAO.iValidarEmailUsuarioDAO(sEmailDigitadoJOP) > 1) {
            sSiapeDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "O sistema possui "
                    + usuarioDAO.iValidarEmailUsuarioDAO(sEmailDigitadoJOP) + " usuários com o mesmo email, "
                    + "favor inserir o seu siape: ", "");
            if (sSiapeDigitadoJOP == null) {
                return;
            }
            while (!usuarioDAO.bValidarSiapeExistenteDAO(sSiapeDigitadoJOP) || !loginDAO.bValidarSiapeEEmail(sSiapeDigitadoJOP, sEmailDigitadoJOP)) {
                sSiapeDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "Insira um siape válido:", "");
                if (sSiapeDigitadoJOP == null) {
                    return;
                }
            }
        }

        if (bEnviarEmailTeste("Recuperação de acesso ao Sistema de Suporte ao Aluno", "Usuário alterado: "
                + sUsuarioAlterado, sEmailDigitadoJOP)) {
            int iComSemSiape; // com 2  sem 22
            if (sSiapeDigitadoJOP == null) {
                iComSemSiape = 22;
            } else {
                mLogin.setsSiape(sSiapeDigitadoJOP);
                iComSemSiape = 2;
            }
            mLogin.setsUsuario(sUsuarioAlterado);
            loginDAO.bAlterarLogin(iComSemSiape, mLogin, "");

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar um email com o usuário alterado, "
                    + "favor tentar novamente mais tarde, se o erro persistir consulte o suporte");
        }
    }

    public void vEsqueciSenha(String sNomeUsuario) {
        usuarioDAO = new UsuarioDAO();
        loginDAO = new LoginDAO();
        mLogin = new MLogin();
        JTextField jtfJOP = new JTextField();
        String sEmailDigitadoJOP, sSenhaAlterada = sGerarSenhaAlfanumerica(), sUsuarioDigitadoJOP;
        if (sNomeUsuario.trim().isEmpty() || !loginDAO.bValidarLoginExistente(sNomeUsuario)) {
            sUsuarioDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "É necessário informar um usuário "
                    + "válido para recuperar a senha:", "");
            if (sUsuarioDigitadoJOP == null) {
                return;
            }
            while (sUsuarioDigitadoJOP.trim().isEmpty() || !loginDAO.bValidarLoginExistente(sUsuarioDigitadoJOP)) {
                sUsuarioDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "É necessário informar um usuário "
                        + "válido para recuperar a senha:", "");
                if (sUsuarioDigitadoJOP == null) {
                    return;
                }
            }
            sEmailDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "Insira um email referente ao "
                    + "usuário: " + sUsuarioDigitadoJOP, "");
            if (sEmailDigitadoJOP == null) {
                return;
            }
            while (!bIsEmail(sEmailDigitadoJOP) || usuarioDAO.iValidarEmailUsuarioDAO(sEmailDigitadoJOP) == 0) {
                sEmailDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "Insira um email válido referente ao "
                        + "usuário: " + sUsuarioDigitadoJOP, "");
                if (sEmailDigitadoJOP == null) {
                    return;
                }
            }
        } else {
            sUsuarioDigitadoJOP = sNomeUsuario;
            sEmailDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "Insira um email referente ao "
                    + "usuário: " + sUsuarioDigitadoJOP, "");
            if (sEmailDigitadoJOP == null) {
                return;
            }
            while (!bIsEmail(sEmailDigitadoJOP) || usuarioDAO.iValidarEmailUsuarioDAO(sEmailDigitadoJOP) == 0) {
                sEmailDigitadoJOP = JOptionPane.showInputDialog(jtfJOP, "Insira um email válido referente ao "
                        + "usuário: " + sUsuarioDigitadoJOP, "");
                if (sEmailDigitadoJOP == null) {
                    return;
                }
            }
        }
        mLogin.setsSenha(sSenhaAlterada);
        mLogin.setsUsuario(sUsuarioDigitadoJOP);
        if (!loginDAO.bAlterarLogin(1, mLogin, "") || !bEnviarEmailTeste("Recuperação de acesso ao Sistema de "
                + "Suporte ao Aluno", "Senha alterada: " + sSenhaAlterada, sEmailDigitadoJOP)) {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar um email com a senha alterada, "
                    + "favor tentar novamente mais tarde, se o erro persistir consulte o suporte");
        }
    }

    public void vCriarUmLogin() {
        JTextField jtfEmail = new JTextField();
        String sEmailDigitado, sUsuarioCriado = sGerarUsuarioAleatorio(), sSenhaCriada = sGerarSenhaAlfanumerica(), sSiapeCriado = sGerarSiapeAleatorio();
        String sConteudoDoEmail = "Usuário de acesso:-> " + sUsuarioCriado
                + " senha de acesso:-> " + sSenhaCriada;
        sEmailDigitado = JOptionPane.showInputDialog(jtfEmail, "Insira seu email: ", "");
        if (sEmailDigitado == null) {
            return;
        }
        while (!bIsEmail(sEmailDigitado)) {
            JOptionPane.showMessageDialog(null, "Insira um email válido");
            sEmailDigitado = JOptionPane.showInputDialog(jtfEmail, "Insira seu email: ", "");
            if (sEmailDigitado == null) {
                return;
            }
        }
        if (!bEnviarEmailTeste("Criação de acesso ao Sistema de Suporte ao Aluno", sConteudoDoEmail, sEmailDigitado)) {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar um email com o seu usuário e senha, favor "
                    + "tentar novamente mais tarde, se o erro persistir consulte o suporte");
        }
        mLogin = new MLogin();
        mUsuario.setsNome("Usuário padrão");
        mUsuario.setsSiape(sSiapeCriado);
        mUsuario.setbUsuarioAtivo(true);
        mUsuario.setsEmail(sEmailDigitado);
        mUsuario.setsNucleo("Área comum");
        mUsuario.setsSexo("Outro");
        mUsuario.setsCelular("(12) 9 3456-7890");
        mLogin.setsSiape(sSiapeCriado);
        mLogin.setsUsuario(sUsuarioCriado);
        mLogin.setsSenha(sSenhaCriada);
        usuarioDAO.bCadastrarUsuarioDAO(mUsuario);
        loginDAO.bCadastrarLoginDAO(mLogin);
    }

    public void vAlterarLoginESenha(String sUsuarioRecebido, String sSenhaRecebida) {
        loginDAO = new LoginDAO();
        if (sUsuarioRecebido.equals(mLoginLogado.getsUsuario())) {
            mLoginLogado.setsSenha(sSenhaRecebida);
            if (loginDAO.bAlterarLogin(3, mLoginLogado, "")) {
                JOptionPane.showMessageDialog(null, "Login alterado com sucesso");
                vAbrirTelaPrincipal(4, -1);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o login, caso o problema perssista consulte o suporte");
            }
        } else if (loginDAO.bValidarLoginExistente(sUsuarioRecebido)) {
            JOptionPane.showMessageDialog(null, "Já existe um login no sistema com esse mesmo usuário");
        } else {
            mLoginLogado.setsUsuario(sUsuarioRecebido);
            mLoginLogado.setsSenha(sSenhaRecebida);
            if (loginDAO.bAlterarLogin(3, mLoginLogado, "")) {
                JOptionPane.showMessageDialog(null, "Login alterado com sucesso");
                vAbrirTelaPrincipal(4, -1);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar o login, caso o problema perssista consulte o suporte");
            }
        }
    }

    /*
     * Núcleo
     */
    public void inicializaTela(int iCadastrarOuEditar, DefaultListModel a, Icon icon) {
        ndao = new NucleoDAO();
        if (iCadastrarOuEditar == 0) {
            icon = new javax.swing.ImageIcon(getClass().getResource("/Icone/Add32x32.png"));
            ndao.fillComponent(1, (DefaultListModel) a);
        } else if (iCadastrarOuEditar == 1) {
            System.out.println("b");
            icon = new javax.swing.ImageIcon(getClass().getResource("/Icone/Edit32x32.png"));
            //
        }
    }

    /*
     * Limpar
     */
    public void vLimparTabela(DefaultTableModel tabela) {
        if (tabela.getRowCount() > 0) {
            for (int i = tabela.getRowCount(); i > 0; i--) {
                tabela.removeRow(0);
            }
        }
    }

    /*
     * Gerar relatório
     */
    public void vRelatorioAluno(MAluno aluno) throws IOException, BadElementException {
        /* try { // Esquerda , Direita , Cima , Baixo
            // Declarações
            Document document = new Document(PageSize.A4, 30, 20, 30, 20);
            OutputStream outputStream = new FileOutputStream("Ficha de dados(" + aluno.getNome() + ").pdf");
            Font fonteTitulo = new Font(FontFamily.TIMES_ROMAN, 15, Font.UNDERLINE);
            Font fonteNegrito = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font fonteRodape = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
            Paragraph titulo = new Paragraph("Ficha do aluno", fonteNegrito);
            Paragraph tituloResponsavel = new Paragraph("Responsável", fonteNegrito);
            Paragraph paragrafoVazio = new Paragraph("  ");
            Paragraph tituloRodape1 = new Paragraph("INSTITUTO FEDERAL DO PARANÁ – CÂMPUS ASSIS CHATEAUBRIAND", fonteRodape);
            Paragraph tituloRodape2 = new Paragraph("RUA SÃO LUIZ S/N | CEP 85935-000 | CENTRO CÍVICO | ASSIS CHATEAUBRIAND - PR", fonteRodape);
            PdfPTable tabela = new PdfPTable(6);
            tabela.setTotalWidth(500);
            tabela.setLockedWidth(true);
            PdfPCell cabecalhoDadosAluno = new PdfPCell(new Paragraph("Dados do aluno", fonteNegrito));
            PdfPCell cabecalhoResponsavel = new PdfPCell(new Paragraph("Responsável", fonteNegrito));
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Página 1:          
            // Cabeçalho an Rodapé
            vOnEndPage(document, tituloRodape1, tituloRodape2);

            // Título do texto:
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(paragrafoVazio);

            // Tabela:
            cabecalhoDadosAluno.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalhoDadosAluno.setColspan(6);
            tabela.addCell(cabecalhoDadosAluno);

            PdfPCell nome = new PdfPCell(new Paragraph("Nome: " + aluno.getNome()));
            nome.setColspan(4);
            tabela.addCell(nome);
            PdfPCell matriculaTabela = new PdfPCell(new Paragraph("Matrícula: " + aluno.getMatricula()));
            matriculaTabela.setColspan(2);
            tabela.addCell(matriculaTabela);
            PdfPCell curso = new PdfPCell(new Paragraph("Curso: " + aluno.getCurso()));
            curso.setColspan(3);
            tabela.addCell(curso);
            PdfPCell dataNascimento = new PdfPCell(new Paragraph("Data de nascimento: " + aluno.getDataNascimento()));
            dataNascimento.setColspan(3);
            tabela.addCell(dataNascimento);
            PdfPCell endereco = new PdfPCell(new Paragraph("Endereço: " + aluno.getEndereco()));
            endereco.setColspan(5);
            tabela.addCell(endereco);
            PdfPCell numerocasa = new PdfPCell(new Paragraph("Nº: " + aluno.getNumerocasa()));
            tabela.addCell(numerocasa);
            PdfPCell uf = new PdfPCell(new Paragraph("UF: " + aluno.getUf()));
            tabela.addCell(uf);
            PdfPCell cidade = new PdfPCell(new Paragraph("Cidade: " + aluno.getCidade()));
            cidade.setColspan(3);
            tabela.addCell(cidade);
            PdfPCell bairro = new PdfPCell(new Paragraph("Bairro: " + aluno.getBairro()));
            bairro.setColspan(2);
            tabela.addCell(bairro);
            PdfPCell celular = new PdfPCell(new Paragraph("Celular: " + aluno.getCelular()));
            celular.setColspan(2);
            tabela.addCell(celular);
            PdfPCell telefone = new PdfPCell(new Paragraph("Telefone: " + aluno.getTelefone()));
            telefone.setColspan(2);
            tabela.addCell(telefone);
            PdfPCell sexo = new PdfPCell(new Paragraph("Sexo: " + aluno.getSexo()));
            sexo.setColspan(2);
            tabela.addCell(sexo);
            PdfPCell rg = new PdfPCell(new Paragraph("RG: " + aluno.getRg()));
            rg.setColspan(3);
            tabela.addCell(rg);
            PdfPCell cpf = new PdfPCell(new Paragraph("CPF: " + aluno.getCpf()));
            cpf.setColspan(3);
            tabela.addCell(cpf);
            PdfPCell situacao = new PdfPCell(new Paragraph("Situação: " + aluno.getSituacao()));
            situacao.setColspan(3);
            tabela.addCell(situacao);
            PdfPCell ne = new PdfPCell(new Paragraph("Possui algum tipo de Nessecidade Especial?: " + aluno.getNe()));
            ne.setColspan(6);
            tabela.addCell(ne);
            PdfPCell email = new PdfPCell(new Paragraph("Email: " + aluno.getEmail()));
            email.setColspan(6);
            tabela.addCell(email);
            cabecalhoResponsavel.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalhoResponsavel.setColspan(6);
            tabela.addCell(cabecalhoResponsavel);
            PdfPCell nomeResponsavel1 = new PdfPCell(new Paragraph("Responsável: " + aluno.getNomeResponsavel1()));
            nomeResponsavel1.setColspan(6);
            tabela.addCell(nomeResponsavel1);
            PdfPCell telefoneResponsavel1 = new PdfPCell(new Paragraph("Telefone: " + aluno.getTelefoneResponsavel1()));
            telefoneResponsavel1.setColspan(3);
            tabela.addCell(telefoneResponsavel1);
            PdfPCell celularResponsavel1 = new PdfPCell(new Paragraph("Celular: " + aluno.getCelularResponsavel1()));
            celularResponsavel1.setColspan(3);
            tabela.addCell(celularResponsavel1);
            document.add(tabela);

            document.newPage();
            document.close();
            // abrir o documento criado
            Desktop.getDesktop().open(new File("Ficha de dados(" + aluno.getNome() + ").pdf"));
        } catch (DocumentException | FileNotFoundException documentException) {

            System.out.println(documentException);
        } catch (IOException ex) {
            System.out.println(ex);
        }*/
    }

    public void vRelatorioConsulta(String matriculaFor, String nomeAluno) throws IOException, BadElementException {
        /*try { // Esquerda , Direita , Cima , Baixo
            // Declarações
            Document document = new Document(PageSize.A4, 30, 20, 30, 20);
            OutputStream outputStream = new FileOutputStream("Relatório de consulta(" + nomeAluno + ").pdf");
            Font fonteTitulo = new Font(FontFamily.TIMES_ROMAN, 15, Font.UNDERLINE);
            Font fonteNegrito = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font fonteRodape = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
            Paragraph titulo = new Paragraph("Relatório de consulta", fonteNegrito);
            Paragraph paragrafoVazio = new Paragraph(" m ");
            Paragraph tituloRodape1 = new Paragraph("INSTITUTO FEDERAL DO PARANÁ – CÂMPUS ASSIS CHATEAUBRIAND", fonteRodape);
            Paragraph tituloRodape2 = new Paragraph("RUA SÃO LUIZ S/N | CEP 85935-000 | CENTRO CÍVICO | ASSIS CHATEAUBRIAND - PR", fonteRodape);
            PdfPTable tabela = new PdfPTable(6);
            tabela.setTotalWidth(500);
            tabela.setLockedWidth(true);
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Página 1:          
            // Cabeçalho and Rodapé
            vOnEndPage(document, tituloRodape1, tituloRodape2);

            // Título do texto:
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(paragrafoVazio);
            // Tabela de dados:

            MConsulta consultaFor = null;
            // Tabela de Consulta:

            Paragraph tituloDaConsultaComData = new Paragraph("Consulta iniciada às " + consultaFor.getHoraInicio() + " dia " + consultaFor.getDataInicio() + " :: " + consultaFor.getTituloConsulta(), fonteNegrito);
            PdfPCell tituloDeCadaConsulta = new PdfPCell(tituloDaConsultaComData);
            tituloDeCadaConsulta.setHorizontalAlignment(Element.ALIGN_CENTER);
            tituloDeCadaConsulta.setColspan(6);
            tabela.addCell(tituloDeCadaConsulta);

            PdfPCell atendente = new PdfPCell(new Paragraph("Atendente: " + consultaFor.getAtendente()));
            atendente.setColspan(4);
            tabela.addCell(atendente);

            PdfPCell siap = new PdfPCell(new Paragraph("Siap: " + consultaFor.getSiape()));
            siap.setColspan(2);
            tabela.addCell(siap);

            PdfPCell textConsulta = new PdfPCell(new Paragraph("Consulta: " + consultaFor.getTextoConsulta()));
            textConsulta.setColspan(6);
            tabela.addCell(textConsulta);

            Paragraph fimDaConsulta = new Paragraph("Consulta iniciada às " + consultaFor.getHoraFinal() + " dia " + consultaFor.getDataFinal(), fonteNegrito);
            PdfPCell fimConsulta = new PdfPCell(fimDaConsulta);
            fimConsulta.setHorizontalAlignment(Element.ALIGN_CENTER);
            fimConsulta.setColspan(6);
            tabela.addCell(fimConsulta);

            PdfPCell celulaVazia = new PdfPCell(new Paragraph("   "));
            celulaVazia.setColspan(6);
            tabela.addCell(celulaVazia);

            document.add(tabela);

            document.newPage();
            document.close();
            // abrir o documento criado
            Desktop.getDesktop().open(new File("Relatório de consulta(" + nomeAluno + ").pdf"));
        } catch (DocumentException | FileNotFoundException documentException) {

            System.out.println(documentException);
        } catch (IOException ex) {
            System.out.println(ex);
        }*/
    }

    public void vRelatorioAtendente(MUsuario mUsuario) {
        try { // Esquerda , Direita , Cima , Baixo
            // Declarações
            Document document = new Document(PageSize.A4, 30, 20, 30, 20);
            OutputStream outputStream = new FileOutputStream("Ficha de dados(" + mUsuario.getsNome() + ").pdf");
            Font fonteTitulo = new Font(FontFamily.TIMES_ROMAN, 15, Font.UNDERLINE);
            Font fonteNegrito = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font fonteRodape = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
            Paragraph titulo = new Paragraph("Ficha do aluno", fonteNegrito);
            Paragraph tituloResponsavel = new Paragraph("Responsável", fonteNegrito);
            Paragraph paragrafoVazio = new Paragraph("  ");
            Paragraph tituloRodape1 = new Paragraph("INSTITUTO FEDERAL DO PARANÁ – CÂMPUS ASSIS CHATEAUBRIAND", fonteRodape);
            Paragraph tituloRodape2 = new Paragraph("RUA SÃO LUIZ S/N | CEP 85935-000 | CENTRO CÍVICO | ASSIS CHATEAUBRIAND - PR", fonteRodape);
            PdfPTable tabela = new PdfPTable(6);
            tabela.setTotalWidth(500);
            tabela.setLockedWidth(true);
            PdfPCell cabecalhoDadosAluno = new PdfPCell(new Paragraph("Dados do aluno", fonteNegrito));
            PdfPCell cabecalhoResponsavel = new PdfPCell(new Paragraph("Responsável", fonteNegrito));

            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Página 1:          
            // Cabeçalho an Rodapé
            vOnEndPage(document, tituloRodape1, tituloRodape2);

            // Título do texto:
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(paragrafoVazio);

            // Tabela:
            cabecalhoDadosAluno.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalhoDadosAluno.setColspan(6);
            tabela.addCell(cabecalhoDadosAluno);

            PdfPCell nome = new PdfPCell(new Paragraph("Nome: " + mUsuario.getsNome()));
            nome.setColspan(4);
            tabela.addCell(nome);
            PdfPCell matriculaTabela = new PdfPCell(new Paragraph("Siape: " + mUsuario.getsSiape()));
            matriculaTabela.setColspan(2);
            tabela.addCell(matriculaTabela);
            PdfPCell curso = new PdfPCell(new Paragraph("Núcleo: " + mUsuario.getsNucleo()));
            curso.setColspan(3);
            tabela.addCell(curso);
            PdfPCell dataNascimento = new PdfPCell(new Paragraph("Data de nascimento: " + mUsuario.getsDataNascimento()));
            dataNascimento.setColspan(3);
            tabela.addCell(dataNascimento);
            PdfPCell endereco = new PdfPCell(new Paragraph("Endereço: " + mUsuario.getsEndereco()));
            endereco.setColspan(5);
            tabela.addCell(endereco);
            PdfPCell numerocasa = new PdfPCell(new Paragraph("Nº: " + mUsuario.getsNumeroCasa()));
            tabela.addCell(numerocasa);
            PdfPCell uf = new PdfPCell(new Paragraph("UF: " + mUsuario.getsUf()));
            tabela.addCell(uf);
            PdfPCell cidade = new PdfPCell(new Paragraph("Cidade: " + mUsuario.getsCidade()));
            cidade.setColspan(3);
            tabela.addCell(cidade);
            PdfPCell bairro = new PdfPCell(new Paragraph("Bairro: " + mUsuario.getsBairro()));
            bairro.setColspan(2);
            tabela.addCell(bairro);
            PdfPCell celular = new PdfPCell(new Paragraph("Celular: " + mUsuario.getsCelular()));
            celular.setColspan(2);
            tabela.addCell(celular);
            PdfPCell telefone = new PdfPCell(new Paragraph("Telefone: " + mUsuario.getsTelefone()));
            telefone.setColspan(2);
            tabela.addCell(telefone);
            PdfPCell sexo = new PdfPCell(new Paragraph("Sexo: " + mUsuario.getsSexo()));
            sexo.setColspan(2);
            tabela.addCell(sexo);
            PdfPCell rg = new PdfPCell(new Paragraph("RG: " + mUsuario.getsRg()));
            rg.setColspan(3);
            tabela.addCell(rg);
            PdfPCell cpf = new PdfPCell(new Paragraph("CPF: " + mUsuario.getsCpf()));
            cpf.setColspan(3);
            tabela.addCell(cpf);
            PdfPCell situacao = new PdfPCell(new Paragraph("Situação: " + mUsuario.getsSituacao()));
            situacao.setColspan(3);
            tabela.addCell(situacao);
            PdfPCell email = new PdfPCell(new Paragraph("Email: " + mUsuario.getsEmail()));
            email.setColspan(6);
            tabela.addCell(email);
            document.add(tabela);

            document.newPage();
            document.close();
            // abrir o documento criado
            Desktop.getDesktop().open(new File("Ficha de dados(" + mUsuario.getsNome() + ").pdf"));
        } catch (DocumentException | FileNotFoundException documentException) {

            System.out.println(documentException);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void vOnEndPage(Document document, Paragraph tituloRodape1, Paragraph tituloRodape2) {
        try {
            // Cabecalho:
            Image imagemCabecalho = Image.getInstance("D:/IFPR/Segundao/Linguagem_de_Programacao/Trabalho_Final/Cabecalho_PDF.png");
            imagemCabecalho.scaleToFit(450, 80);
            imagemCabecalho.setAlignment(Element.ALIGN_CENTER);
            document.add(imagemCabecalho);

            // Rodape:
            tituloRodape1.setAlignment(Element.ALIGN_CENTER);
            tituloRodape2.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloRodape1);
            document.add(tituloRodape2);

        } catch (IOException | DocumentException e) {
            System.out.println(e);
        }
    }

    /*
     * Enviar email
     */
    public boolean bEnviarEmailTeste(String tituloDoEmail, String conteudoDoEmail, String emailDestinatario) {

        String sEmailRemetente = "email";
        String sSenhaEmailRemetente = "senha";
        boolean enviou = false;

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session sesConexaoEstabelecida = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sEmailRemetente, sSenhaEmailRemetente);
            }
        });

        try {

            Message mMessage = new MimeMessage(sesConexaoEstabelecida);
            mMessage.setFrom(new InternetAddress("email"));
            mMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailDestinatario));//u will send to
            mMessage.setSubject(tituloDoEmail);
            mMessage.setText(conteudoDoEmail);
            JOptionPane.showMessageDialog(null, "Enviando");
            Transport.send(mMessage);
            JOptionPane.showMessageDialog(null, "Enviado com sucesso");
            enviou = true;
        } catch (MessagingException e) {
            System.out.println(e);
        }
        return enviou;
    }

    /*
     * Outros
     */
    private void vCadastrarUsuarioDefault() {
        usuarioDAO = new UsuarioDAO();
        loginDAO = new LoginDAO();
        mUsuario = new MUsuario();
        mLogin = new MLogin();
        mNucleo = new MNucleo();
        ndao = new NucleoDAO();
        String sSiapeCadastrar1 = "2015302772",
                sUsuarioCadastrar1 = "italo.rodrigues",
                sSiapeCadastrar2 = "666",
                sUsuarioCadastrar2 = "a",
                sPermissaoDeAcessoAdmin = "Admin, Área comum",
                sPermissaoDeAcessoAreaComum = "Área comum";

        /*ndao.rRemoverAllNucleo();
        loginDAO.rRemoverAllLogin();
        usuarioDAO.rRemoverAllUsuarioDAO();*/
        if (!ndao.bValidarNucleoExistente("Área comum")) {
            mNucleo.setsNome("Área comum");
            mNucleo.setsPermissoesDeAcesso(sPermissaoDeAcessoAreaComum);
            ndao.bCadastrarNucleo(mNucleo);
        }
        if (!ndao.bValidarNucleoExistente("Admin")) {
            mNucleo.setsNome("Admin");
            mNucleo.setsPermissoesDeAcesso(sPermissaoDeAcessoAdmin);
            ndao.bCadastrarNucleo(mNucleo);
        }
        if (!usuarioDAO.bValidarSiapeExistenteDAO(sSiapeCadastrar1) && !loginDAO.bValidarLoginExistente(sUsuarioCadastrar1)) {
            // psicologo
            mUsuario.setsNome("Italo Rodrigues");
            mUsuario.setsSiape(sSiapeCadastrar1);
            mUsuario.setsCelular("(12) 9 3456-7890");
            mUsuario.setsEmail("italo.rsantos@hotmail.com");
            mUsuario.setsSexo("Masculino");
            if (ndao.bValidarNucleoExistente("Admin")) {
                mUsuario.setsNucleo("Admin");
                mUsuario.setbUsuarioAtivo(true);
                mLogin.setsSiape(sSiapeCadastrar1);
                mLogin.setsUsuario(sUsuarioCadastrar1);
                mLogin.setsSenha("rodrigues");
                usuarioDAO.bCadastrarUsuarioDAO(mUsuario);
                loginDAO.bCadastrarLoginDAO(mLogin);
            }
        }
        if (!usuarioDAO.bValidarSiapeExistenteDAO(sSiapeCadastrar2) && !loginDAO.bValidarLoginExistente(sUsuarioCadastrar2)) {
            // psicologo
            mUsuario.setsNome("Tio Crowley");
            mUsuario.setsSiape(sSiapeCadastrar2);
            mUsuario.setsCelular("(12) 9 3456-7890");
            mUsuario.setsEmail("italo.rsantos@hotmail.com");
            mUsuario.setsSexo("Masculino");
            if (ndao.bValidarNucleoExistente("Admin")) {
                mUsuario.setsNucleo("Admin");
                mUsuario.setbUsuarioAtivo(true);
                mLogin.setsSiape(sSiapeCadastrar2);
                mLogin.setsUsuario(sUsuarioCadastrar2);
                mLogin.setsSenha("a");
                usuarioDAO.bCadastrarUsuarioDAO(mUsuario);
                loginDAO.bCadastrarLoginDAO(mLogin);
            }
        }/**/ System.out.println("asd");
    }

    public void vAdicionarLinhaTabela(DefaultTableModel t) {
        t.addRow(new Object[]{"2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2"});
    }

    public void vAdicionarAPorraDoElemento(DefaultListModel dlm) {
        dlm.addElement("asd");
    }
}
