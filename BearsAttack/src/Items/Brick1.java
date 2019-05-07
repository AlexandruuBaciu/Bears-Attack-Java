package Items;

import Game.ImageLoader;


public class Brick1 extends Item
{
    public Brick1(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getBrick1();

    }
}