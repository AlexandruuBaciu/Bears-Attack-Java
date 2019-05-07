package Items;

import Game.ImageLoader;


public class Brick3 extends Item
{
    public Brick3(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getBrick3();

    }
}