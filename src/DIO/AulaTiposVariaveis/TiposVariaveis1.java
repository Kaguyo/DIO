package DIO.AulaTiposVariaveis;

public class TiposVariaveis1 {
    public static void main(String [] args) throws Exception
    {   
        // ---------------
        // Aula 2
        // ---------------
        // byte - 1 byte
        // short - 2 bytes
        // int - 4 bytes
        // long - 8 bytes

        // contém fracionários -->
        // float - 4 bytes
        // double - 8 bytes
        
        @SuppressWarnings("unused")
        float pi = 3.14f; // Tem que bota o caralho f no final.

        // ---------------
        // Aula 4
        // ---------------
        System.out.println("Valor de PI sem final: 10.374 (Alterável)");
        final float PI =  3.14f;
        System.out.println("Valor de PI com final: " + PI + " (Não alterável)");
        
            // Aula do Fujita 
            String name =  "abc";
            String password = "1234";
            if (name != "abc" || password != "123"){throw new Exception("Usuario ou senha incorretos");}
            // AULÃO FUJITA if (name != "abc" || password != "123"){throw new ArithmeticException("Usuario ou senha incorretos");}
    }
}