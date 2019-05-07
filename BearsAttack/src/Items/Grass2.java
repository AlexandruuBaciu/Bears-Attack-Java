package Items;

import Game.ImageLoader;


public class Grass2 extends Item
{
    public Grass2(int x, int y) {
        super(x, y);
        image= ImageLoader.getInstance().getGrass2();


    }
}