package Locations.BattleLocs;

import Base.Player;
import Items.Armors.Heavy;
import Items.Armors.Light;
import Items.Armors.Medium;
import Items.Weapons.Revolver;
import Items.Weapons.Rifle;
import Items.Weapons.Sword;
import Items.Weapons.Weapon;
import Locations.Location;
import Obstacles.Obstacle;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int id;
    private int maxObstacle;
    private boolean isTropieWin;
    Scanner scanner = new Scanner(System.in);



    public BattleLoc(Player player, Obstacle obstacle, String name, String award, int id, int maxObstacle, boolean isTropieWin) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.id = id;
        this.maxObstacle = maxObstacle;
        this.isTropieWin = isTropieWin;
    }
    public boolean getisTropieWin() {
        return isTropieWin;
    }

    public void setisTropieWin(boolean tropieWin) {
        isTropieWin = tropieWin;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int randObstacle = this.randomObstacle();
        System.out.println("You are now here: " + this.getName());
        System.out.println("Be careful! " + randObstacle + " " + this.getObstacle().getName() + " lives here!");
        System.out.print("(F)ight or (R)un away: ");
        String selectCase = scanner.nextLine().toLowerCase();
        if (selectCase.equals("f")) {
            if (combat(randObstacle)) {
                return true;
            }

        }

        if (this.getPlayer().getHealth() <= 0) {
            this.getPlayer().setHealth(0);
            System.out.println("You are death! GAME IS OVER!");
            return false;
        }
        return true;
    }



    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                int randomHit = new Random().nextInt(2)+1;
                if(randomHit==1){
                    obstacleHit();
                }
                System.out.print("(K)ick or (R)un away:");
                String selectCombat = scanner.nextLine().toLowerCase();


                if (selectCombat.equals("k")&&this.getPlayer().getHealth() >0) {
                    System.out.println("----------------------------------------------");
                    System.out.println(this.getPlayer().getName() + " kicked to " + i + ". " + this.getObstacle().getName());
                    int obstHealth = this.getObstacle().getHealth() - this.getPlayer().getDamage();
                    if (obstHealth < 0) {
                        obstHealth = 0;
                    }
                    this.getObstacle().setHealth(obstHealth);
                    System.out.println("----------------------------------------------");
                    afterHit();
                    System.out.println("----------------------------------------------");
                    obstacleHit();
                } else {
                        return false;
                    }
            }

            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("You killed a "+this.getObstacle().getName());
                if(this.getObstacle().getID()==4){
                    System.out.println("Your award is: "+this.getAward());
                    System.out.println("Box is opening...");
                    int rateWinTropy = new Random().nextInt(100)+1;
                    System.out.println("Rate: "+rateWinTropy);
                    if(rateWinTropy<=15){
                        int rateWinWeapon = new Random().nextInt(100)+1;
                        if(rateWinWeapon<=20){
                            this.getPlayer().getInventory().setWeapon(new Rifle());
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getWeapon().getName());
                        }
                        else if(rateWinWeapon>20&&rateWinWeapon<=50){
                            this.getPlayer().getInventory().setWeapon(new Sword());
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getWeapon().getName());
                        }
                        else {
                            this.getPlayer().getInventory().setWeapon(new Revolver());
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getWeapon().getName());
                        }
                    }
                    else if(rateWinTropy>15&&rateWinTropy<=30){
                        int rateWinArmor = new Random().nextInt(100)+1;
                        if(rateWinArmor<=20){
                            this.getPlayer().getInventory().setArmor(new Heavy());
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getArmor().getName());
                        }
                        else if(rateWinArmor>20&&rateWinArmor<=50){
                            this.getPlayer().getInventory().setArmor(new Medium());
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getArmor().getName());
                        }
                        else {
                            this.getPlayer().getInventory().setArmor(new Light());
                            System.out.println("Your new item: "+this.getPlayer().getInventory().getArmor().getName());
                        }
                    }
                    else if(rateWinTropy>30&&rateWinTropy<=55){
                        int rateWinMoney = new Random().nextInt(100)+1;
                        if(rateWinMoney<=20){
                            this.getPlayer().setMoney(this.getPlayer().getMoney()+10);
                            System.out.println("You won "+10+"golden");
                            System.out.println("Your current goldens: "+this.getPlayer().getMoney());

                        }
                        else if(rateWinMoney>20&&rateWinMoney<=50){
                            this.getPlayer().setMoney(this.getPlayer().getMoney()+5);
                            System.out.println("You won "+5+"golden");
                            System.out.println("Your current goldens: "+this.getPlayer().getMoney());

                        }
                        else {
                            this.getPlayer().setMoney(this.getPlayer().getMoney()+1);
                            System.out.println("You won "+1+" golden");
                            System.out.println("Your current goldens: "+this.getPlayer().getMoney());
                        }
                    }
                    else {
                        System.out.println("Box is empty!");
                    }
                }
                    else {
                    System.out.println("Your award is: "+this.getObstacle().getTrophy()+" golden!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getTrophy());
                    this.setisTropieWin(true);
                    }

            }
            else{
                return false;
            }

        }
        if(this.getPlayer().getHealth()>0){
            System.out.println("----------------------------------------------");
            System.out.println("You killed all "+this.getObstacle().getName()+"s.");
            String tropy = this.getAward();
            int index = this.getId();
            if(index<=3){
                this.getPlayer().getInventory().setCollectedTropies(tropy,index-1);
                System.out.println("You collected a "+this.getAward());
                System.out.print("Your tropies: ");
                for(int i =0;i<3;i++){
                    if(this.getPlayer().getInventory().getCollectedTropies()[i]!=null){
                        System.out.print(this.getPlayer().getInventory().getCollectedTropies()[i]+" ");
                    }

                }
                System.out.println("");
            }


        }
return true;
    }

    private void obstacleHit() {
        if(this.getObstacle().getName()=="Snake"){
            this.getObstacle().setDamage(randomDamage());
        }
        if (this.getObstacle().getHealth() > 0) {
            System.out.println(this.getObstacle().getName() + " kicked to " + this.getPlayer().getName());
            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefending();
            if (obstacleDamage < 0) {
                obstacleDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
            System.out.println("----------------------------------------------");
            afterHit();
            System.out.println("----------------------------------------------");
        }
    }

    private void afterHit () {
            System.out.println(this.getPlayer().getName() + "   health is: " + this.getPlayer().getHealth());
            System.out.println(this.getObstacle().getName() + " health is: " + this.getObstacle().getHealth());
        }

        private void obstacleStats () {
            System.out.println("---------Obstacle status---------");
            System.out.println("-------------------------------");
            System.out.println("Health: " + this.getObstacle().getHealth());
            System.out.println("Damage: " + this.getObstacle().getDamage());
            System.out.println("Award : " + this.getObstacle().getTrophy());
        }

        private void playerStats () {
            System.out.println("---------Player status---------");
            System.out.println("-------------------------------");
            System.out.println("Health: " + this.getPlayer().getHealth());
            System.out.println("Damage: " + this.getPlayer().gettotalDamage());
            System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
            System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        }

        public int randomObstacle () {
            return new Random().nextInt(this.getMaxObstacle()) + 1;
        }
        private int randomDamage(){
        return new Random().nextInt(this.getObstacle().getDamage())+3;
        }

    }
