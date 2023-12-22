/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofinal.model.dao;

/**
 *
 * @author pedro
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetofinal.model.vo.JogadorIlimitadoVO;

public class RankingDAO {

    public List<JogadorIlimitadoVO> obterTop5Jogadores() {
        List<JogadorIlimitadoVO> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM rankingilimitado ORDER BY pontuacao DESC LIMIT 5";

        try (Connection conexao = conexaoJDBC.getConexao(); 
             PreparedStatement preparedStatement = conexao.prepareStatement(sql); 
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                JogadorIlimitadoVO jogador = new JogadorIlimitadoVO(
                        rs.getString("nick"),
                       rs.getInt("pontuacao"),
                        rs.getDate("dataJogo"));
                jogadores.add(jogador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogadores;
    }

    public List<JogadorIlimitadoVO> obterTop3Dia(Date data) {
        List<JogadorIlimitadoVO> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM rankingilimitado WHERE dataJogo = ? ORDER BY pontuacao DESC LIMIT 3";

        try (Connection conexao = conexaoJDBC.getConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setDate(1, data);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    JogadorIlimitadoVO jogador = new JogadorIlimitadoVO(
                            rs.getString("nick"),
                           rs.getInt("pontuacao"),
                            rs.getDate("dataJogo"));
                    jogadores.add(jogador);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jogadores;
    }

    public boolean inserirJogador(JogadorIlimitadoVO jogador) {
        String sql = "INSERT INTO rankingilimitado (nick, pontuacao, dataJogo) VALUES (?, ?, ?)";

        try (Connection conexao = conexaoJDBC.getConexao(); 
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            
             ps.setString(1, jogador.getNick());
             ps.setInt(2, jogador.getPontuacao());
             ps.setDate(3, jogador.getDataJogo());
             ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
