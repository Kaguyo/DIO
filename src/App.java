public class App {

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

        String armaLendaria = armaLendaria (primeiroNome,segundoNome);
        System.out.println(armaLendaria);
    }


public static String armaLendaria (String primeiroNome, String segundoNome)
    {
        return "Resultado do método " +  primeiroNome.concat(" ").concat(segundoNome);
    }
}