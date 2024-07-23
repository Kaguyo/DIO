package DIO.AulaSintaxe;
public class AnatomiaClasses1 {

    public static void main (String [] args) 
    {   
        // Aula 1
        System.out.println("Hello World!" );
        
        // Aula 2
        @SuppressWarnings("unused")
        final String BR = "Brasil"; // final == const
        
        @SuppressWarnings("unused")
        boolean verdadeira = true;

        String primeiroNome = "Faca";
        String segundoNome = "AK47";
        // ---------------
        // Aula 3
        int variavel1 = 1;
         // ---------------
        String armaLendaria = armaLendaria (primeiroNome,segundoNome,variavel1);
        System.out.println(armaLendaria);


    }
    public static String armaLendaria (String primeiroNome, String segundoNome, int variavel1)
    {
        // ---------------
        // Aula 3
        if (variavel1 == 1) {
            System.out.println("é um.");
        }
        else if (variavel1 == 2) {
            System.out.println("é dois.");
        }    
        else if (variavel1 > 2) {
            System.out.println("é mais que dois.");
        }
         // ---------------

        return "Resultado do método " +  primeiroNome.concat(" ").concat(segundoNome);
    }
}