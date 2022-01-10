package Locations.BattleLocs;

import Base.Player;
import Obstacles.Obstacle;
import Obstacles.Vampire;

import java.util.Random;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, new Vampire(), "Forest","Firewood",2,3,false);
    }

}
