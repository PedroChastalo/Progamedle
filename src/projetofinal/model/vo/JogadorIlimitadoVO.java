/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projetofinal.model.vo;

/**
 *
 * @author pedro
 */

import java.sql.Date;

    public class JogadorIlimitadoVO {
        private String nick;
        private int pontuacao;
        private Date dataJogo;

    
    public JogadorIlimitadoVO(){
        this.nick = nick;
        this.pontuacao = pontuacao;
        this.dataJogo = dataJogo;
    }
    
    public JogadorIlimitadoVO(String nick, int pontuacao, Date dataJogo) {
        this.nick = nick;
        this.pontuacao = pontuacao;
        this.dataJogo = dataJogo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Date getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(Date dataJogo) {
        this.dataJogo = dataJogo;
    }
    
}

