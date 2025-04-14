package dio.service;

import dio.persistence.dao.CardDAO;
import dio.model.Card;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CardService {
    private final CardDAO cardDAO;

    public CardService(Connection connection) {
        this.cardDAO = new CardDAO(connection);
    }

    public void criarCard(int boardId, String nome, String descricao) throws SQLException {
        Card card = new Card();
        card.setNome(nome);
        card.setDescricao(descricao);
        card.setStatus("pendente");  // Definindo status inicial como "pendente"
        card.setBloqueado(false);     // Card não é bloqueado inicialmente
        card.setBoardId(boardId);

        try {
            cardDAO.criarCard(card);
        } catch (SQLException e) {
            System.out.println("Erro ao criar card: " + e.getMessage());
        }
    }

    public void listarCardsPorBoard(int boardId) {
        try {
            List<Card> cards = cardDAO.listarCardsPorBoard(boardId);
            if (cards.isEmpty()) {
                System.out.println("Nenhum card encontrado para este board.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar cards: " + e.getMessage());
        }
    }

    public void moverCard(int cardId, int novoBoardId) throws SQLException {
        try {
            cardDAO.moverCard(cardId, novoBoardId);
        } catch (SQLException e) {
            System.out.println("Erro ao mover card: " + e.getMessage());
        }
    }

    public void bloquearDesbloquearCard(int cardId, boolean bloquear) {
        try {
            cardDAO.bloquearDesbloquearCard(cardId, bloquear);
        } catch (SQLException e) {
            System.out.println("Erro ao bloquear/desbloquear card: " + e.getMessage());
        }
    }
}
