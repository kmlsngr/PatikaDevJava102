package Locations.BattleLocs;

import Base.Player;
import Obstacles.Bear;
import Obstacles.Obstacle;

import java.util.Random;

public class River extends BattleLoc{

    public River(Player player) {
        super(player,new Bear(), "River", "Water",3,2,false);
    }

}
