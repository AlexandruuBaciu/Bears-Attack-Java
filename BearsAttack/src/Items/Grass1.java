package Items;

import Game.ImageLoader;


public class Grass1 extends Item
{
    public Grass1(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getGrass1();

    }
}