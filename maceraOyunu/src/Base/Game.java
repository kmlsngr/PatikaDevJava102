package Base;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome the Adventure Game! ");
        System.out.print("Enter the player name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Hi "+player.getName()+"! welcome the Adventure Game!");
        System.out.println("------------------------------------");
        System.out.println("Select your character to start game!");
        System.out.println("------------------------------------");
        player.selectChar();
        System.out.println("------------------------------------");
        System.out.println("Select to location to go!");
        System.out.println("------------------------------------");
        boolean status=true;
        while(player.getHealth()>0 && status){
                status = player.selectLoc();
                if(status){
                    player.printInfo();
                }
                else {
                    break;
                }

        }

    }
}
