package DIO.Metodos;

import java.util.Scanner;

public class Usuario {

    public static void main(String[] args) {
        String escolhaUser = "";
        SistemaSmartTV smartTv = new SistemaSmartTV();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!(smartTv.ligada)) {
            System.out.println(smartTv.ligada ? "TV Ligada" : "TV Desligada");
            System.out.print("\nDeseja ligar a TV?: ");

            escolhaUser = scanner.nextLine().toLowerCase();
            if (!escolhaUser.equals("yes") && !escolhaUser.equals("y") && !escolhaUser.equals("s") && !escolhaUser.equals("sim")
                && !escolhaUser.equals("0") && !escolhaUser.equals("sair") && !escolhaUser.equals("cancelar")) {
                smartTv.desligar();
                System.out.println("---------------");
                System.out.println("TV Desligada.");
                System.out.println("---------------\n");
                break;
            } else {
                smartTv.ligar();
            }
            if (smartTv.ligada) {
                System.out.println("---------------");
                System.out.println("TV Ligada.");
                System.out.println("---------------\n");
                System.out.println("Canal Atual: " + smartTv.canal);
                System.out.println("Volume: " + smartTv.volume);
                System.out.println("\n(Digite SAIR ou 0 para cancelar)");
                System.out.print("\nDeseja desligar?: ");

                escolhaUser = scanner.nextLine().toLowerCase();
                if (!escolhaUser.equals("yes") && !escolhaUser.equals("y") && !escolhaUser.equals("s") && !escolhaUser.equals("sim")
                        && !escolhaUser.equals("0") && !escolhaUser.equals("sair") && !escolhaUser.equals("cancelar")) {

                }
                else {
                smartTv.desligar();
                System.out.println("---------------");
                System.out.println("TV Desligada.");
                System.out.println("---------------\n");
                }
            }
        }
    }
}