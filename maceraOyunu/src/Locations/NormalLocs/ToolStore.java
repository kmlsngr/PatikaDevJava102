package Locations.NormalLocs;
import Base.*;
import Items.Armors.Armor;
import Items.Weapons.*;

import java.util.Scanner;

public class ToolStore extends NormalLoc {
    Scanner scanner = new Scanner(System.in);

    public ToolStore(Player player) {
        super(player, "Tool Store");

    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in Tool Store,welcome! Select the item or exit!");
        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("3- Exit");
        System.out.print("Select: ");
        int select = scanner.nextInt();

        boolean selection = true;
        while (selection) switch (select) {
            case 1 -> {
                System.out.println("I will show you weapons!");
                showWeapons();
                buyWeapon();
                selection = false;
            }
            case 2 -> {
                System.out.println("I will show you armors!");
                showArmors();
                buyArmor();
                selection = false;
            }
            case 3 -> {
                System.out.println("You did not buy anything, you are leaving! Good Bye!");
                selection = false;
            }
            default -> System.out.println("Wrong selection! Try it again!");
        }

        return true;
    }

    private void showArmors() {
        System.out.println("------------------------------");
        System.out.println("-----------Armors------------");
        System.out.println("------------------------------");

        int i=1;
        for (Armor armor :Armor.armors()
        ) {
            System.out.println(i+"-"+ armor.getName()+" ".repeat(10-armor.getName().length())+"ID: "+ armor.getId()+"\tDefending: "+ armor.getDefending()+"\tPrice: "+ armor.getPrice());
            i++;
        }
    }

    private void showWeapons() {
        System.out.println("------------------------------");
        System.out.println("-----------Weapons------------");
        System.out.println("------------------------------");
        Weapon [] weapons = {new Revolver(),new Rifle(),new Sword()};
        int i=1;
        for (Weapon weapon :weapons
             ) {
            System.out.println(i+"-"+ weapon.getName()+" ".repeat(10-weapon.getName().length())+"ID: "+ weapon.getID()+"\tDamage: "+ weapon.getDamage()+"\tPrice: "+ weapon.getCost());
            i++;
        }


    }
    public void buyWeapon(){
        System.out.print("Do you want to buy a Weapon?\n (Y) for buy (N) for go back to store: ");
        boolean select  = true;
        while (select){
            String selection = scanner.nextLine().toLowerCase();
            switch (selection){
                case "y":
                    System.out.print("Enter the weapon ID: ");
                    int ID = scanner.nextInt();
                    Weapon selectedWeapon = Weapon.getWeaponByID(ID);
                    if(selectedWeapon != null){
                        if(selectedWeapon.getCost()<= this.getPlayer().getMoney()){
                            this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedWeapon.getCost());

                            System.out.println("Your old item: "+this.getPlayer().getInventory().getWeapon().getName());
                            this.getPlayer().getInventory().setWeapon(selectedWeapon);
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getWeapon().getName());
                        }
                        else{
                            System.out.println("You dont have enough money! Kill more monster! ");
                        }
                        select=false;
                        break;
                    }
                case "n":
                    System.out.println("Come again after decided what you will buy!");
                    onLocation();
                    select=false;
                    break;
            }

        }
    }
    public void buyArmor(){
        System.out.print("Do you want to buy an Armor?\n(Y)es for buy (N)o for go back to store: ");
        boolean select  = true;
        while (select){
            String selection = scanner.nextLine().toLowerCase();
            switch (selection){
                case "y":
                    System.out.print("Enter the armor ID: ");
                    int ID = scanner.nextInt();
                    Armor selectedArmor = Armor.getArmorById(ID);
                    if(selectedArmor != null){
                        if(selectedArmor.getPrice()<= this.getPlayer().getMoney()){
                            this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());

                            System.out.println("Your old item: "+this.getPlayer().getInventory().getArmor().getName());
                            this.getPlayer().getInventory().setArmor(selectedArmor);
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getArmor().getName());
                        }
                        else{
                            System.out.println("You dont have enough money! Kill more monster! ");
                        }
                        select=false;
                        break;
                    }
                case "n":
                    System.out.println("Come again after decided what you will buy!");
                    select=false;
                    break;

            }

        }
    }


}

