package DIO.Loops;

public class For {
    public static void main(String[] args) {
        for (int bullets = 30; bullets >= 0; bullets --) {
            System.out.println("One shot was executed.\n");
            System.out.println(bullets + " Rounds left!");
        }
        
        String Bag [] = { "Medic Kit","Bow","G-17","Pump Shotgun"}; 

        for (int y = 0; y < 1; y++){
            System.out.println("\n\n-------------");
            System.out.println("Inventory:");
            System.out.println("-------------");
            for (int x = 0; x < Bag.length ; x++ ){
            System.out.println("(" + (x+1) + ") " + Bag[x]);
            }
            System.out.println("\n\n");

        }
    }
}
