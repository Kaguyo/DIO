package dio;

import dio.persistence.migration.MigrationStrategy;
import dio.service.BoardService;
import dio.service.CardService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static dio.persistence.config.ConnectionConfig.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = getConnection()) {
            // Executa migração
            new MigrationStrategy(connection).executeMigration();

            // Serviços com conexão
            BoardService boardService = new BoardService(connection);
            CardService cardService = new CardService(connection);

            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Criar Board");
                System.out.println("2. Listar Boards");
                System.out.println("3. Criar Card");
                System.out.println("4. Listar Cards por Board");
                System.out.println("5. Mover Card para outro Board");
                System.out.println("6. Bloquear/Desbloquear Card");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do Board: ");
                        String nomeBoard = scanner.nextLine();
                        boardService.criarBoard(nomeBoard);
                        break;
                    case 2:
                        boardService.listarBoards();
                        break;
                    case 3:
                        System.out.print("ID do Board: ");
                        int boardId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome do Card: ");
                        String nomeCard = scanner.nextLine();
                        System.out.print("Descrição do Card: ");
                        String descricao = scanner.nextLine();
                        cardService.criarCard(boardId, nomeCard, descricao);
                        break;
                    case 4:
                        System.out.print("ID do Board: ");
                        int boardIdList = scanner.nextInt();
                        scanner.nextLine();
                        cardService.listarCardsPorBoard(boardIdList);
                        break;
                    case 5:
                        System.out.print("ID do Card: ");
                        int cardIdMover = scanner.nextInt();
                        System.out.print("Novo ID do Board: ");
                        int novoBoardId = scanner.nextInt();
                        scanner.nextLine();
                        cardService.moverCard(cardIdMover, novoBoardId);
                        break;
                    case 6:
                        System.out.print("ID do Card: ");
                        int cardIdBloquear = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Bloquear (true) ou Desbloquear (false)? ");
                        boolean bloquear = scanner.nextBoolean();
                        scanner.nextLine();
                        cardService.bloquearDesbloquearCard(cardIdBloquear, bloquear);
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 7);

            scanner.close();
        }
    }
}
