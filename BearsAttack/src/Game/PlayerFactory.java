package Game;

import Items.Player;

public class PlayerFactory
{
    public static Player getPlayer(int level)
    {
        switch (level)
        {
            case 1: return new Player(100, 205,ImageLoader.getInstance().getPlayer());
            case 2: return new Player(100, 205,ImageLoader.getInstance().getRobotPlayer());
            case 3: return new Player(100, 205,ImageLoader.getInstance().getSurvivalPlayer());
            default: return null;

        }
    }
}
