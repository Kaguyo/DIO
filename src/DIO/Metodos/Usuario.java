package DIO.Metodos;

import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) {
        String escolhaUser = "";
        int escolhaNumeral = 0;
        SistemaSmartTV smartTv = new SistemaSmartTV();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!smartTv.ligada) {
                System.out.println(smartTv.ligada ? "TV Ligada" : "TV Desligada");
                System.out.print("\nDeseja ligar a TV?: ");

                escolhaUser = scanner.nextLine().toLowerCase();
                if (escolhaUser.equals("yes") || escolhaUser.equals("y") || escolhaUser.equals("s") || escolhaUser.equals("sim")) {
                    smartTv.ligar();
                } else {
                    smartTv.desligar();
                    System.out.println("---------------");
                    System.out.println("TV Desligada.");
                    System.out.println("---------------\n");
                    break;
                }

                while (smartTv.ligada) {
                    System.out.println("---------------");
                    System.out.println("TV Ligada.");
                    System.out.println("---------------");
                    System.out.println("Canal Atual: " + smartTv.canal + "/" + smartTv.MAX_CHANNELS);
                    System.out.println("Volume: " + smartTv.volume + "/" + smartTv.MAX_VOLUME);
                    System.out.println("\nAlterar Volume: (+ / - )");
                    System.out.println("Mudar Canal: (C+ / C-)");
                    System.out.print("\n\nPara desligar, digite qualquer valor inválido entre as opções: ");
                    escolhaUser = scanner.nextLine().toLowerCase();
                    System.out.println("\n\n");

                    // Verifica se a escolha do usuário não é um dos comandos válidos para continuar
                    if (!(escolhaUser.equals("+") || escolhaUser.equals("volume+") || escolhaUser.equals("-")
                            || escolhaUser.equals("volume-") || escolhaUser.equals("c+") || escolhaUser.equals("c-"))) {
                        break;
                    }

                    if (escolhaUser.equals("+") || escolhaUser.equals("volume+")) {
                        if (smartTv.volume >= smartTv.MAX_VOLUME) {
                            System.out.println("\n\nO Volume já está no máximo.\n");
                            SistemaSmartTV.pausaDeDoisSegundos();
                            SistemaSmartTV.limparConsole();
                        } else {
                            System.out.println("\n\n---------------");
                            System.out.println("Volume: (" + smartTv.volume + "/" + smartTv.MAX_VOLUME + ")");
                            System.out.println("---------------\n");
                            System.out.print("\nEscolha um valor para aumentar o volume: ");
                            escolhaNumeral = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                            smartTv.volume += escolhaNumeral;
                            if (smartTv.volume > smartTv.MAX_VOLUME) {
                                smartTv.volume = smartTv.MAX_VOLUME;
                            }
                        }
                    } else if (escolhaUser.equals("-") || escolhaUser.equals("volume-")) {
                        if (smartTv.volume <= 0) {
                            System.out.println("\n\nA Televisão já está no mudo.\n");
                            SistemaSmartTV.pausaDeDoisSegundos();
                            SistemaSmartTV.limparConsole();
                        } else {
                            System.out.println("\n\n---------------");
                            System.out.println("Volume: (" + smartTv.volume + "/" + smartTv.MAX_VOLUME + ")");
                            System.out.println("---------------\n");
                            System.out.print("\nEscolha um valor para diminuir o volume: ");
                            escolhaNumeral = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                            smartTv.volume -= escolhaNumeral;
                            if (smartTv.volume < 0) {
                                smartTv.volume = 0;
                            }
                            System.out.println("\nVolume Atual: " + smartTv.volume + "\n");
                        }
                    } else if (escolhaUser.equals("c+") || escolhaUser.equals("c-")) {
                        // Solicita ao usuário para escolher um canal manualmente
                        System.out.print("\nEscolha um Canal (1/" + smartTv.MAX_CHANNELS + "): ");
                        escolhaNumeral = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                        System.out.println("\n\n");
                        if (escolhaNumeral >= 1 && escolhaNumeral <= smartTv.MAX_CHANNELS) {
                            smartTv.canal = escolhaNumeral;
                            System.out.println("\nCanal Alterado para: " + smartTv.canal + "\n");
                        } else {
                            System.out.println("\nEscolha de Canal Inválida.\n");
                        }
                    }
                }
            }
        }
    }
}