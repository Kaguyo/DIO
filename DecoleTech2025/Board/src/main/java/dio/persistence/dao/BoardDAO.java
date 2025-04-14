package dio.persistence.dao;

import dio.model.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private final Connection connection;

    public BoardDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarBoard(String nome) throws SQLException {
        String sql = "INSERT INTO BOARDS (name) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
            System.out.println("Board criado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar board: " + e.getMessage());
        }
    }

    public List<Board> listarBoards() throws SQLException {
        List<Board> boards = new ArrayList<>();
        String sql = "SELECT id, name FROM BOARDS";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Board board = new Board();
                board.setId(rs.getInt("id"));
                board.setNome(rs.getString("name"));
                boards.add(board);
            }

            for (Board board : boards) {
                System.out.println(board);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar boards: " + e.getMessage());
        }

        return boards;
    }
}
