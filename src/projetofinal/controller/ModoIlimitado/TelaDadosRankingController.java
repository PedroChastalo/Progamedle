/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projetofinal.controller.ModoIlimitado;

/**
 *
 * @author pedro
 */

import java.io.IOException;
import java.sql.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projetofinal.model.vo.JogadorIlimitadoVO;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import projetofinal.model.rn.RankingRN;

public class TelaDadosRankingController {

    @FXML
    private Pane PaneDadosRankingIlimitado;

    @FXML
    private Button botaoDadosRanking;

    @FXML
    private TextArea caixaNick;

    @FXML
    private Pane paneInformacoesDadoRankingIlimitado;

    @FXML
    private StackPane stackPaneDadosRankingIlimitado;

    @FXML
    private Text textoNick;
    
    
    //variaveis
    
    private final RankingRN rankingRN;
    
    private int pontuacaoAtual;
    
    private Date dataJogo;
    
    public void setPontuacaoAtual(int pontuacaoAtual) {
        this.pontuacaoAtual = pontuacaoAtual;
    }
    
    public void setDataJogo(Date dataJogo){
        this.dataJogo = dataJogo;
    }


    public TelaDadosRankingController() {
        this.rankingRN = new RankingRN();
    }

    @FXML
    void enviarDadosRanking(ActionEvent event) {
        String nick = caixaNick.getText().trim();
        
        JogadorIlimitadoVO jogador = new JogadorIlimitadoVO(nick, pontuacaoAtual, dataJogo);

        rankingRN.inserirJogador(jogador);
  
        try {
            FXMLLoader telaInicio = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaInicial.fxml"));
            Parent root = telaInicio.load();
            Stage telainicio = new Stage();
            telainicio.setScene(new Scene(root));
            telainicio.show();

            Stage stageAtual = (Stage) botaoDadosRanking.getScene().getWindow();
            stageAtual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
