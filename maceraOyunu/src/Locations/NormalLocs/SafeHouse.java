package Locations.NormalLocs;
import Base.*;
import Locations.NormalLocs.NormalLoc;

public class SafeHouse extends NormalLoc {
    Player player;
    public SafeHouse(Player player) {
        super(player, "Safe House");
        this.player=player;
    }
    @Override
   public boolean onLocation(){



        if(!checkTropies()){
            System.out.println("You are in Safe House");
            System.out.println("Your health is getting full!");
            this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
            return true;
        }
        else {
            System.out.println("Congratulations! You have everything to leave! YOU WIN! ");
            return false;
        }

    }
    private boolean checkTropies() {
        int tropyCount = 0;
        for(String t: this.getPlayer().getInventory().getCollectedTropies()){
            if(t!=null){
                tropyCount++;
            }
        }
        if(tropyCount==3){
            return true;
        }

        return false;
    }
}
