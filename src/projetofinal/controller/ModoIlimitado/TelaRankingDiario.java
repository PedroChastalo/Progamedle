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
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projetofinal.model.rn.RankingRN;
import projetofinal.model.vo.JogadorIlimitadoVO;

public class TelaRankingDiario {

    @FXML
    private Button botaoVoltar;

    @FXML
    private DatePicker dataJogo;

    @FXML
    private GridPane gridPanePrincipal;

    @FXML
    private GridPane gridRankingDiario;

    @FXML
    private ImageView imagemFundo;

    @FXML
    private Text nomePrimeiro;

    @FXML
    private Text nomeSegundo;

    @FXML
    private Text nomeTerceiro;

    @FXML
    private Text pontuacaoPrimeiro;

    @FXML
    private Text pontuacaoSegundo;

    @FXML
    private Text pontuacaoTerceiro;

    @FXML
    private StackPane stackPanePrincipal;

    @FXML
    private Text textoPrimeiro;

    @FXML
    private Text textoSegundo;

    @FXML
    private Text textoTerceiro;

    @FXML
    private Text texxtoRankingDiario;

    @FXML
    void escolherData(ActionEvent event) {
        Date dataSelecionada = Date.valueOf(dataJogo.getValue());
        carregarRankingDiario(dataSelecionada);
    }
    
 private void carregarRankingDiario(Date data) {
    RankingRN rankingRN = new RankingRN();
    List<JogadorIlimitadoVO> jogadores = rankingRN.obterTop3Dia(data);

       if (jogadores.isEmpty()) {
        TelaErro("Nenhuma informação encontrada para o dia selecionado.");
        return;
    }
    
    while (jogadores.size() < 3) {
        jogadores.add(new JogadorIlimitadoVO());
    }

    for (int posicao = 0; posicao < jogadores.size(); posicao++) {
        JogadorIlimitadoVO jogador = jogadores.get(posicao);
        switch (posicao) {
            case 0:
                nomePrimeiro.setText(jogador.getNick());
                pontuacaoPrimeiro.setText(String.valueOf(jogador.getPontuacao()));
                break;
            case 1:
                nomeSegundo.setText(jogador.getNick());
                pontuacaoSegundo.setText(String.valueOf(jogador.getPontuacao()));
                break;
            case 2:
                nomeTerceiro.setText(jogador.getNick());
                pontuacaoTerceiro.setText(String.valueOf(jogador.getPontuacao()));
                break;
        }
    }
  }
 
     @FXML
    void voltarTelaInicial(ActionEvent event) {
        try {
            FXMLLoader TelaInicial = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaInicial.fxml"));
            Parent root = TelaInicial.load();
            Stage Telainicial = new Stage();
            Telainicial.setScene(new Scene(root));
            Telainicial.show();
            
            Stage stageAtual = (Stage) botaoVoltar.getScene().getWindow();
            stageAtual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void TelaErro(String mensagem) {
        Alert Erro = new Alert(Alert.AlertType.ERROR);
        Erro.setTitle("Deu erro :( ");
        Erro.setContentText(mensagem);
        Erro.showAndWait();
    }
}
