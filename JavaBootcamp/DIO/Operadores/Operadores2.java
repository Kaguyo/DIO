package DIO.Operadores;
// Aula 7
public class Operadores2 {
    public static void main(String [] args) 
    {
        boolean condicao1 = true;
        boolean condicao2 = false;
        String chevrolet_Camaro = "Camaro SS";
        String hyundai_HB20 = "HB20";
        String ak47_ammo = "7.62";
        String m4a1_ammo = "7.62";

        System.out.print("Condição1 and Camaro equals HB20 is true?: ");
        if (condicao1 && chevrolet_Camaro == hyundai_HB20) {
            System.out.println("Yes, True");
        }
        else {
            System.out.println("No, False");
        }
        System.out.print("Pelomenos uma das das verificações é verdadeira?: ");
        if (condicao2 || ak47_ammo == m4a1_ammo) {
            System.out.println("Yes, true");
        }
    } 
}