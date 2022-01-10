package Base;

import Characters.Archer;
import Characters.Chivalry;
import Characters.GameCharacters;
import Characters.Samurai;
import Items.Inventory;
import Locations.BattleLocs.Cave;
import Locations.BattleLocs.Forest;
import Locations.BattleLocs.Mine;
import Locations.BattleLocs.River;
import Locations.Location;
import Locations.NormalLocs.SafeHouse;
import Locations.NormalLocs.ToolStore;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;






    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory;
    private int originalHealth;

    public  Player(String name){
        this.inventory= new Inventory();
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar(){

        GameCharacters [] gameCharacters = {new Chivalry(),new Samurai(),new Archer()};
        int i =1;
        System.out.println("------------Characters----------");
        for (GameCharacters gamechar:gameCharacters
             ) {
            System.out.println(i+"-"+gamechar.getName()+"\tID: "+gamechar.getID()+"\tDamage: "+gamechar.getDamage()+"\tHealth: "+gamechar.getHealth()+"\tMoney: "+gamechar.getMoney());

        i++;}
        boolean selection = true;
        while(selection){
            System.out.print("Select your character ID: ");
            int select = scanner.nextInt();
            if(select == 1){
                initPlayer(new Samurai());
                System.out.println("Samurai selected!");
                selection=false;
            }
            else if(select== 2 ){
                initPlayer(new Archer());
                System.out.println("Archer selected!");
                selection= false;
            }
            else if(select== 3){
                initPlayer(new Chivalry());
                System.out.println("Chivalry selected!");
                selection = false;
            }
            else {
                System.out.println("Wrong selection, try it again!");

            }

        }

    }
    public boolean selectLoc(){
        Location location=null;
        System.out.println("Locations:");
        System.out.println("1- Safe House");
        System.out.println("2- Tool Store");
        System.out.println("3- Battle Areas");
        System.out.println("0- Finish the game,exit!");
        boolean selection = true;
        while(selection){
            checkTropies();
            System.out.print("Select location ID: ");
            int select = scanner.nextInt();
            switch (select) {
                case 0 -> {
                    System.out.println("You are leaving from the game... Good Bye!");
                    selection = false;
                    return false;
                }
                case 1 -> {
                    location = new SafeHouse(this);
                    selection = false;
                    return location.onLocation();
                }
                case 2 -> {
                    location = new ToolStore(this);
                    selection = false;
                    return location.onLocation();
                }
                case 3 -> {

                    System.out.println("1-Cave");
                    System.out.println("2-Forest");
                    System.out.println("3-River");
                    System.out.println("4-Mine");
                    System.out.println("5-Exit");


                    System.out.print("Select the ID of area to fight:");
                    int battleLocId = scanner.nextInt();

                    if (battleLocId == 5) {
                        System.out.println("You returned the locations! ");
                        return true;
                    }

                    if (battleLocId == 1 && this.getInventory().getCollectedTropies()[0]==null) {
                        location = new Cave(this);
                        location.onLocation();
                        return true;
                    }
                    if (battleLocId == 1 && this.getInventory().getCollectedTropies()[0]!=null) {
                        System.out.println("You collected food from Cave, go another location!");
                        return true;
                    }

                    if (battleLocId == 2) {
                        location = new Forest(this);
                        location.onLocation();
                        return true;
                    }
                    if (battleLocId == 2 && this.getInventory().getCollectedTropies()[1]!=null) {
                        System.out.println("You collected Firewood from Forest, go another location!");
                        return true;
                    }
                    if (battleLocId == 3) {
                        location = new River(this);
                        location.onLocation();
                        return true;
                    }
                    if (battleLocId == 3 && this.getInventory().getCollectedTropies()[2]!=null) {
                        System.out.println("You collected Water from River, go another location!");
                        return true;
                    }
                    if (battleLocId == 4) {
                        location = new Mine(this);
                        location.onLocation();
                        return true;
                    }
                    else {
                        System.out.println("Wrong selection!");
                        return true;
                    }
                }
                default -> {
                    System.out.println("Wrong selection do it again!");
                    return true;
                }
            }



        }
        return true;
    }

    private boolean checkTropies() {
        int tropyCount = 0;
        for(String t: this.getInventory().getCollectedTropies()){
            if(t!=null){
                tropyCount++;
            }
        }
        if(tropyCount==3){
            System.out.println("***********************************");
            System.out.println("You collected all trophies, You should go Safe House and leave from this scary Island!  ");
            System.out.println("***********************************");
            return true;
        }

        return false;
    }

    private void initPlayer(GameCharacters gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
        this.setOriginalHealth(this.getHealth());


    }
    public void printInfo(){
        System.out.println("-------------------------------------------------");
        System.out.println("Your weapon: "+ this.getInventory().getWeapon().getName() +"\tYour armor: "+ this.getInventory().getArmor().getName() +"\tYour defending: "+ this.getInventory().getArmor().getDefending() +
                "\tYour Damage: "+this.gettotalDamage()+"\tYour Health: "+this.getHealth()+"\tYour Money: "+this.getMoney());
        System.out.println("-------------------------------------------------");
    }

    public int getDamage() {
        return damage;
    }
    public int gettotalDamage() {
        return damage+this.getInventory().getWeapon().getDamage();
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }


}
