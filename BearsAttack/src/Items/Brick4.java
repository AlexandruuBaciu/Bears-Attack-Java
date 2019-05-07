package Items;

import Game.ImageLoader;


public class Brick4 extends Item
{
    public Brick4(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getBrick4();

    }
}