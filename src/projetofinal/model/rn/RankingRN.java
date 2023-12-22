/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projetofinal.model.rn;

/**
 *
 * @author pedro
 */
import projetofinal.model.dao.RankingDAO;
import projetofinal.model.vo.JogadorIlimitadoVO;
import java.util.List;
import java.sql.Date;

public class RankingRN{

    private final RankingDAO rankingDAO;

    public RankingRN() {
        this.rankingDAO = new RankingDAO();
    }

    public List<JogadorIlimitadoVO> obterTop5Jogadores() {
        return rankingDAO.obterTop5Jogadores();
    }

    public boolean inserirJogador(JogadorIlimitadoVO jogador) {
        return rankingDAO.inserirJogador(jogador);
    }
    
    public List<JogadorIlimitadoVO> obterTop3Dia(Date data){
        return rankingDAO.obterTop3Dia(data);
    }
}

