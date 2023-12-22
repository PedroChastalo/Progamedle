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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class TelaJogoIlimitadoController {

    @FXML
    private Button botaoAdvinharJogo;

    @FXML
    private TextField caixaRespostaJogo;

    @FXML
    private Pane paneItensJogo;

    @FXML
    private Pane paneJogo;

    @FXML
    private StackPane stackPaneJogo;

    @FXML
    private Text pontuacao;

    @FXML
    private ImageView telaFundoJogo;

    @FXML
    private ImageView telaLinguagemJogo;

    @FXML
    private Text textoVidas;

    //variaveis usadas para o jogo
    private int pontuacaoAtual = 0;

    private int tentativasRestantes = 3;

    private String linguagemAtual;

    private String novaLinguagem;

    private Set<String> linguagensUti = new HashSet<>();
    private List<String> linguagens = Arrays.asList("Java", "Python", "C++", "JavaScript", "C#", "Ruby", "Swift", "Kotlin", "TypeScript", "PHP", "Go", "Rust", "Dart", "R");

    private Map<String, List<String>> dicaLinguagem = new HashMap<>();
    private Map<String, Set<String>> dicaUsada = new HashMap<>();

    {
        dicaLinguagem.put("Java", Arrays.asList("Linguagem interpretada e de alto nível.", "Sintaxe limpa e fácil de aprender.", "Amplamente utilizada em desenvolvimento web, automação e ciência de dados."));
        dicaLinguagem.put("Python", Arrays.asList("Linguagem interpretada e de alto nível.", "Sintaxe limpa e fácil de aprender.", "Amplamente utilizada em desenvolvimento web, automação e ciência de dados."));
        dicaLinguagem.put("C++", Arrays.asList("Extensão do C com suporte a programação orientada a objetos.", "Utilizada em desenvolvimento de jogos e sistemas de tempo real.", "Oferece alto desempenho e controle de memória."));
        dicaLinguagem.put("C#", Arrays.asList("Desenvolvida pela Microsoft.", "Amplamente usada no desenvolvimento de aplicativos Windows.", "Suporte robusto para programação orientada a objetos."));
        dicaLinguagem.put("Dart", Arrays.asList("Desenvolvida pelo Google.", "Utilizada no framework Flutter para desenvolvimento de aplicativos móveis.", "Suporte a programação orientada a objetos."));
        dicaLinguagem.put("Go", Arrays.asList("Desenvolvida pelo Google.", "Foco em simplicidade, desempenho e concorrência.", "Utilizada em servidores e sistemas distribuídos."));
        dicaLinguagem.put("JavaScript", Arrays.asList("Linguagem de script para páginas web.", "Executada no navegador do usuário.", "Suporta assincronia e é essencial para o desenvolvimento front-end."));
        dicaLinguagem.put("Kotlin", Arrays.asList("Compatível com Java, mas mais concisa.", "Utilizada para desenvolvimento Android.", "Suporta programação funcional."));
        dicaLinguagem.put("PHP", Arrays.asList("Linguagem de script para desenvolvimento web.", "Integrada com HTML.", "Amplamente usada em servidores web."));
        dicaLinguagem.put("R", Arrays.asList("Utilizada para estatísticas e análise de dados.", "Oferece uma variedade de pacotes para análise.", "Comunidade forte na área de ciência de dados."));
        dicaLinguagem.put("Ruby", Arrays.asList("Linguagem dinâmica e de alto nível.", "Foco em produtividade e simplicidade.", "Popular para desenvolvimento web, especialmente com o framework Ruby on Rails."));
        dicaLinguagem.put("Rust", Arrays.asList("Foco em segurança e desempenho.", "Sistema de propriedade de empréstimo para evitar erros de memória.", "Utilizada para desenvolvimento de sistemas e software de baixo nível."));
        dicaLinguagem.put("Swift", Arrays.asList("Desenvolvida pela Apple para iOS, macOS, watchOS e tvOS.", "Sintaxe clara e concisa.", "Suporte a programação funcional e orientada a objetos."));
        dicaLinguagem.put("TypeScript", Arrays.asList("Superset de JavaScript com tipagem estática.", "Ferramenta útil para grandes projetos JavaScript.", "Adiciona recursos de orientação a objetos."));
    }

    @FXML
    void initialize() {
        iniciarNovoJogo();
        System.out.println(linguagemAtual);
    }

    @FXML
    void handleBotaoAdvinharJogo(ActionEvent event) {
        String respostaUsuario = caixaRespostaJogo.getText().trim();

        if (respostaUsuario.equalsIgnoreCase(linguagemAtual)) {
            ExibirMensagemAcerto("Parabéns! Você acertou!");
            pontuacaoAtual += 100;
            pontuacao.setText("Pontuação:" + pontuacaoAtual);
            iniciarNovoJogo();
        } else {
            tentativasRestantes--;
            if (tentativasRestantes >= 0) {
                List<String> dicas = dicaLinguagem.getOrDefault(linguagemAtual, Collections.emptyList());
                String dicaEscolhida = escolherDicaNaoRepetida(linguagemAtual, dicas);
                exibirDica(dicaEscolhida);
                textoVidas.setText(String.valueOf(tentativasRestantes));
            } else {
                exibirMensagemErro("Você errou! A resposta correta era: " + linguagemAtual);
                exibirTelaFimDeJogo();
            }
        }
    }

    private String escolherDicaNaoRepetida(String linguagem, List<String> dicas) {
        dicaUsada.computeIfAbsent(linguagem, k -> new HashSet<>());
        Set<String> dicasUtilizadas = dicaUsada.get(linguagem);

        Random random = new Random();
        String dicaEscolhida = null;

        if (!dicas.isEmpty()) {
            do {
                dicaEscolhida = dicas.get(random.nextInt(dicas.size()));
            } while (dicasUtilizadas.contains(dicaEscolhida));
            dicasUtilizadas.add(dicaEscolhida);
        }

        return dicaEscolhida;
    }

    // mudar para tela propria de erro estilo win94
    private void exibirDica(String dica) {
        Alert dicas = new Alert(Alert.AlertType.INFORMATION);
        dicas.setTitle("");
        dicas.setHeaderText("Dica");
        dicas.setContentText(dica);
        dicas.showAndWait();
    }

    private void ExibirMensagemAcerto(String mensagem) {
        Alert acerto = new Alert(Alert.AlertType.INFORMATION);
        acerto.setTitle("Acertou");
        acerto.setContentText(mensagem);
        acerto.showAndWait();

    }

    private void exibirMensagemErro(String mensagem) {
        Alert erro = new Alert(Alert.AlertType.ERROR);
        erro.setTitle("ERRO COMPILATION FAILED");
        erro.setContentText(mensagem);
        erro.showAndWait();
    }

    private void iniciarNovoJogo() {
        //verificar se o jogo deve ou não acabar
        if (linguagensUti.size() == linguagens.size()) {
            exibirTelaFimDeJogo();
            return;
        }

        Random random = new Random();

        do {
            novaLinguagem = linguagens.get(random.nextInt(linguagens.size()));
        } while (linguagensUti.contains(novaLinguagem));

        linguagemAtual = novaLinguagem;
        linguagensUti.add(novaLinguagem);

        //inicia o jogo
        telaLinguagemJogo.setImage(new Image("/projetofinal/Imagens/telaJogo/" + linguagemAtual + ".png"));

        caixaRespostaJogo.clear();
        tentativasRestantes = 3;
        textoVidas.setText(String.valueOf(tentativasRestantes));
        System.out.println(linguagemAtual);
    }

    private void exibirTelaFimDeJogo() {
        try {
            FXMLLoader TelaFinal = new FXMLLoader(getClass().getResource("/projetofinal/view/TelaDadosRanking.fxml"));
            Parent root = TelaFinal.load();
            Stage telaFinal = new Stage();
            telaFinal.setScene(new Scene(root));
            telaFinal.show();

            TelaDadosRankingController DRC = TelaFinal.getController();
            DRC.setPontuacaoAtual(pontuacaoAtual);
            DRC.setDataJogo(new Date(System.currentTimeMillis()));

            Stage stageAtual = (Stage) botaoAdvinharJogo.getScene().getWindow();
            stageAtual.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
