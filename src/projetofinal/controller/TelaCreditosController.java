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
import javafx.scene.layout.GridPane;

public class TelaCreditosController {

    @FXML
    private Button botaoVoltar;

    @FXML
    private ImageView imagemCreditos;

    @FXML
    private Pane paneCredtios;

    @FXML
    private Pane paneItensCredito;

    @FXML
    private StackPane stackPaneCreditos;

    @FXML
    private ImageView telaFundoCreditos;

    @FXML
    private Text tituloCreditos;
    
    @FXML
    private GridPane gripaneCredito;
    
    @FXML
    private Text nomePedro;
    
    @FXML
    private Text nomeVitor;
    

    @FXML
    void handleBotaoVoltar(ActionEvent event) {
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
}
