
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

  package projetofinal.controller;
  
 /**
 *
 * @author pedro
 */
  
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class TelaInicialController {

    @FXML
    private Button botaoCreditos;
    
    @FXML
    private Button botaoIniciar;
 
    @FXML
    private Button botaoRanking;

    @FXML
    private Pane panePrinciapal;

    @FXML
    private Pane panePrinciapalTelaInicial;

    @FXML
    private Pane paneSecundario;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView telaDeFundo;

    @FXML
    private Text tituloJogo;
    
    //tela selecão de modo
    @FXML
    private Button botaoModoDiario;

    @FXML
    private Button botaoModoIlimitado;

    @FXML
    private Pane paneItensModoJogo;

    @FXML
    private Pane panoModoJogo;

    @FXML
    private StackPane stackPaneModoJogo;

    @FXML
    private Text textoQualTipoModo;
    
 
    @FXML
    void handleBotaoCreditos(ActionEvent event) {
        try {
            FXMLLoader TelaCreditos = new FXMLLoader(getClass().getResource("/projetofinal/view/Telareditos.fxml"));
            Parent root = TelaCreditos.load();
            Stage telaCreditos = new Stage();
            telaCreditos.setScene(new Scene(root));
            telaCreditos.show();
            
            Stage stageAtual = (Stage) botaoCreditos.getScene().getWindow();
            stageAtual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBotaoIniciar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaJogoIlimitado.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            Stage stageAtual = (Stage) botaoIniciar.getScene().getWindow();
            stageAtual.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBotaoRanking(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaModoRanking.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            Stage stageAtual = (Stage) botaoRanking.getScene().getWindow();
            stageAtual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
