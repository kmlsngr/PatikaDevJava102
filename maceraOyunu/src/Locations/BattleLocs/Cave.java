package Locations.BattleLocs;

import Base.Player;
import Obstacles.Obstacle;
import Obstacles.Zombi;

import java.util.Random;

public class Cave extends BattleLoc{

    public Cave(Player player) {
        super(player, new Zombi(), "Cave", "Food",1,3,false);
    }

}
