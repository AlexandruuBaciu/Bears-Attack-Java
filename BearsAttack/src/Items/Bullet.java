package Items;

import Game.Board;
import Game.Constants;
import Game.ImageLoader;


public class Bullet extends Item
{



    public Bullet(int x, int y) {
        super(x, y);
        if (Board.currentLevel == 3) {
            image = ImageLoader.getInstance().getBullet();
        } else {
            image = ImageLoader.getInstance().getNeedle();
        }
    }



    public void move() {
        if (x < Constants.BOARD_WIDTH)
        {
            x += 10;
        }

    }



}
