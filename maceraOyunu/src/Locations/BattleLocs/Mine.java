package Locations.BattleLocs;

import Base.Player;
import Obstacles.Obstacle;
import Obstacles.Snake;

public class Mine extends BattleLoc{

    public Mine(Player player) {
        super(player, new Snake(), "Mine", "box", 4, 3, false);


    }
}
