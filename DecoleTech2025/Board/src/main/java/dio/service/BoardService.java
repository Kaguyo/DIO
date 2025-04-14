package dio.service;

import dio.persistence.dao.BoardDAO;
import dio.model.Board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BoardService {
    private final BoardDAO boardDAO;

    public BoardService(Connection connection) {
        this.boardDAO = new BoardDAO(connection);
    }

    public void criarBoard(String nome) throws SQLException {
        try {
            boardDAO.criarBoard(nome);
        } catch (SQLException e) {
            System.out.println("Erro ao criar board: " + e.getMessage());
        }
    }

    public void listarBoards() throws SQLException{
        try {
            List<Board> boards = boardDAO.listarBoards();
            if (boards.isEmpty()) {
                System.out.println("Nenhum board encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar boards: " + e.getMessage());
        }
    }
}
