package Items;

import Game.ImageLoader;


public class Brick2 extends Item
{
    public Brick2(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getBrick2();

    }
}