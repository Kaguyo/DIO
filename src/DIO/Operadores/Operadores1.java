package DIO.Operadores;

public class Operadores1 {

    public static void main(String [] args)
    {
        // Aula 3
        int num1 = 5;
        int num2 = 2;
        System.out.println(- num1 + num2); // apenas inteiros
        System.out.println("Numero " + - num1); // Concatenação string->inteiro

        // Inversão boleana diferenciada
        boolean falso = false;
        falso  = !falso;

        // Aula 5
        // Ternários -------------- 
        String unrealEngine = num1>num2 ? "Bomdimais" : "Perde pra unity :(";
        System.out.println(unrealEngine);
        // Ternários -------------- 

        // Aula 6
        // Operadores Relacionais
        String unreal___Engine = "Unreal Engine";
        String unity = "Unity";
        boolean simNao = unreal___Engine == unity;
        System.out.println("Unreal Engine e Unity são iguais? " + simNao);
        //  ---------------------------------------
        // Mais exemplos:
        //  ---------------------------------------
        System.out.print("----------------\n" + "Resultado desse Operador relacional: ");
        System.out.println(unreal___Engine == unity);
        System.out.print("----------------\n");
        //  ---------------------------------------
        // Mais exemplos:
        //  ---------------------------------------
        String ford_Fusion = "Ford";
        String ford_Mustang = new String("Ford");
        String ford_KA = "Ford";
        System.out.print("----------------\n" + "Fusion e Mustang são da mesma marca?: ");
        System.out.println(ford_Fusion == ford_Mustang);
        System.out.print("----------------\n");
        System.out.print("----------------\n" + "Fusion e KA são da mesma marca?: ");
        System.out.println(ford_Fusion == ford_KA);
        System.out.print("----------------\n");
    }   
}