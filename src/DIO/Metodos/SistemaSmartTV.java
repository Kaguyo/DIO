package DIO.Metodos;

public class SistemaSmartTV {
    // Aula 3
    boolean ligada = false;
    int canal = 1;
    int volume = 15;
    final int MAX_VOLUME = 100;
    final int MAX_CHANNELS = 320;
    public void desligar()
    {
        ligada = false;
    }
    public void ligar()
    {
        ligada = true;
    }
    public static void pausaDeDoisSegundos() {
        try {
            Thread.sleep(2000); // Pausa por 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Mtodo para "limpar" o console simulando com várias linhas em branco
    public static void limparConsole() {
        for (int i = 0; i < 50; ++i) System.out.println(); // Imprime 50 linhas em branco
    }
}
