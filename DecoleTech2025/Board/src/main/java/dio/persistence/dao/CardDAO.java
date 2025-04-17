package dio.persistence.dao;

import dio.model.Card;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {
    private final Connection connection;

    public CardDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarCard(Card card) throws SQLException {
        String sql = "INSERT INTO CARDS (name, description, status, blocked, board_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, card.getNome());
            stmt.setString(2, card.getDescricao());
            stmt.setString(3, card.getStatus());
            stmt.setBoolean(4, card.isBloqueado());
            stmt.setInt(5, card.getBoardId());
            stmt.executeUpdate();
            System.out.println("Card criado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar card: " + e.getMessage());
        }
    }

    public List<Card> listarCardsPorBoard(int boardId) throws SQLException {
        List<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM CARDS WHERE board_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, boardId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Card card = new Card(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getBoolean("blocked"),
                    rs.getInt("board_id")
                );
                cards.add(card);
            }

            for (Card card : cards) {
                System.out.println(card);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar cards: " + e.getMessage());
        }

        return cards;
    }

    public void moverCard(int cardId, int novoBoardId) throws SQLException {
        String sqlVerifica = "SELECT blocked FROM CARDS WHERE id = ?";
        String sqlMover = "UPDATE CARDS SET board_id = ? WHERE id = ?";

        try (PreparedStatement verifica = connection.prepareStatement(sqlVerifica)) {
            verifica.setInt(1, cardId);
            ResultSet rs = verifica.executeQuery();

            if (rs.next()) {
                boolean bloqueado = rs.getBoolean("blocked");
                if (bloqueado) {
                    System.out.println("Não é possível mover um card bloqueado.");
                    return;
                }

                try (PreparedStatement mover = connection.prepareStatement(sqlMover)) {
                    mover.setInt(1, novoBoardId);
                    mover.setInt(2, cardId);
                    mover.executeUpdate();
                    System.out.println("Card movido com sucesso!");
                }
            } else {
                System.out.println("Card não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao mover card: " + e.getMessage());
        }
    }

    public void bloquearDesbloquearCard(int cardId, boolean bloquear) throws SQLException {
        String sql = "UPDATE CARDS SET blocked = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, bloquear);
            stmt.setInt(2, cardId);
            stmt.executeUpdate();

            System.out.println(bloquear ? "Card bloqueado com sucesso." : "Card desbloqueado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar bloqueio do card: " + e.getMessage());
        }
    }
}
