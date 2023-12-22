 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projetofinal.controller;

 /**
 *
 * @author pedro
 */

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaModoRankingController {

    @FXML
    private Button botaoModoDiario;

    @FXML
    private Button botaoModoIlimitado;

    @FXML
    private Pane paneItensModoJogo;

    @FXML
    private Pane panelModoJogo;

    @FXML
    private StackPane stackPaneModoJogo;

    @FXML
    private Text textoQualTipoModo;
    
    

    @FXML
    void handleBotaoModoDiario(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaRankingDiario.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            Stage stageAtual = (Stage) botaoModoDiario.getScene().getWindow();
            stageAtual.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleBotaoModoIlimitado(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaRankingIlimitado.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            
            Stage stageAtual = (Stage) botaoModoIlimitado.getScene().getWindow();
            stageAtual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
