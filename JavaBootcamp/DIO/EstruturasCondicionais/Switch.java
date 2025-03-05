package DIO.EstruturasCondicionais;

public class Switch {

    public static void main(String[] args) {
        String pickAxe = "iron";
        
        switch (pickAxe) {
            case "iron":
                System.out.println("You can mine Diamond.");                
                break;
            case "gold":
                System.out.println("You can mine Diamond");
                break;
            case "wood":
                System.out.println("You can mine Rock");
                break;
            case "diamond":
                System.out.println("You can mine Obsidian");
                break;
            case "obsidian":
                System.out.println("You can mine any material");
                break;
            default:
                System.out.println("Select a valid value for pickAxe. (Wood,Stone,Iron,Gold,Diamond,Obsidian)");
                break;
        }
        
        int sacrifices = 10; // options are 1 to 10

        switch (sacrifices) {
            case 3:
                System.out.println("Azazel is slightly faster and active");
                break;
            case 4:
                System.out.println("Azazel is slightly faster and active");
                break;
            case 5:
                System.out.println("Azazel is significantly faster and more likely to attack");
                break;
            case 6:
                System.out.println("Azazel is significantly faster and more likely to attack");
                break;
            case 7:
                System.out.println("Azazel is significantly faster and even more likely to attack");
                break;
            case 8:
                System.err.println("Azazel has reached his complete Form");
                break;
            case 9:
                System.err.println("Azazel has reached his complete Form");
                break;
            case 10:
                System.err.println("You have banished Azazel!");
                break;
            default:
                System.out.println("Azazel ain't likely to attack neither moves that fast");
                break;
        }

        int night = 1; // Options are 1 to 7

        switch (night) {
            case 1:
                System.out.println("Welcome to your first night. The animatronics are relatively inactive.");
                break;
            case 2:
                System.out.println("Night 2. The animatronics are starting to become more active. Keep an eye on the cameras!");
                break;
            case 3:
                System.out.println("Night 3. Things are heating up. Animatronics are moving around more frequently.");
                break;
            case 4:
                System.out.println("Night 4. The animatronics are more aggressive. Manage your power carefully!");
                break;
            case 5:
                System.out.println("Final night! All animatronics are highly active. Stay vigilant!");
                break;
            case 6:
                System.out.println("Night 6! Even more aggressive animatronics. Can you survive?");
                break;
            case 7:
                System.out.println("Custom Night! The animatronics are at their most dangerous. Good luck!");
                break;
            default:
                System.out.println("Invalid night. Please select a night between 1 and 7.");
                break;
        }
    }
}