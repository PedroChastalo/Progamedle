/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projetofinal.controller.ModoIlimitado;

 /**
 *
 * @author pedro
 */

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projetofinal.model.rn.RankingRN;
import projetofinal.model.vo.JogadorIlimitadoVO;
import java.io.IOException;
import java.util.List;


public class TelaRankingIlimitadoController {

    @FXML
    private Pane PaneTelaDefundoRanking;

    @FXML
    private Button botaoVoltar;

    @FXML
    private GridPane gridPaneInformacoesRanking;

    @FXML
    private Pane paneBotaoVoltar;

    @FXML
    private Pane paneInformacoesRanking;

    @FXML
    private Pane panePrincipalRanking;

    @FXML
    private Text primeiroLugarPontuacao;

    @FXML
    private Text primeiroLugarRanking;

    @FXML
    private Text primerioLugarNome;

    @FXML
    private Text quartoLugarNome;

    @FXML
    private Text quartoLugarPontuacao;

    @FXML
    private Text quartoLugarRanking;

    @FXML
    private Text segundoLugarNome;

    @FXML
    private Text segundoLugarPontuacao;

    @FXML
    private Text segundoLugarRanking;

    @FXML
    private StackPane stackPaneRanking;

    @FXML
    private ImageView telaDeFundoRanking;

    @FXML
    private Text terceiroLugarNome;

    @FXML
    private Text terceiroLugarPontuacao;

    @FXML
    private Text terceiroLugarRanking;

    @FXML
    private Text tituloRanking;
    
    @FXML
    void initialize(){
        carregarRankingIlimitado();
    }

    @FXML
    void handleBotaoVoltarRanking(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaInicial.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            Stage stageAtual = (Stage) botaoVoltar.getScene().getWindow();
            stageAtual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int pontuacaoAtual;

    public void setPontuacaoAtual(int pontuacaoAtual) {
        this.pontuacaoAtual = pontuacaoAtual;
    }
    
    
 private void carregarRankingIlimitado() {
    RankingRN rankingRN = new RankingRN();
    List<JogadorIlimitadoVO> jogadores = rankingRN.obterTop5Jogadores();

    for (int posicao = 0; posicao < jogadores.size(); posicao++) {
        JogadorIlimitadoVO jogador = jogadores.get(posicao);
        switch (posicao) {
            case 1:
                primerioLugarNome.setText(jogador.getNick());
                primeiroLugarPontuacao.setText(String.valueOf(jogador.getPontuacao()));
                break;
            case 2:
                segundoLugarNome.setText(jogador.getNick());
                segundoLugarPontuacao.setText(String.valueOf(jogador.getPontuacao()));
                break;
            case 3:
                terceiroLugarNome.setText(jogador.getNick());
                terceiroLugarPontuacao.setText(String.valueOf(jogador.getPontuacao()));
                break;
            case 4:
                quartoLugarNome.setText(jogador.getNick());
                quartoLugarPontuacao.setText(String.valueOf(jogador.getPontuacao()));
                break;
        }
    }
}

}



