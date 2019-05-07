package Game;

import Items.BaseBlock;

import java.awt.*;

public class BaseBlocksFactory
{
    public static BaseBlock[] getBaseBlocks(int level)
    {
        BaseBlock[] baseBlocks =new BaseBlock[5];
        int dy;
        dy = 5;
        for(int i = 0; i < 5; ++i)
        {
            switch (level)
            {
                case 1:
                    baseBlocks[i] = new BaseBlock(0,dy, ImageLoader.getInstance().getBeehive());
                    break;

                case 2:
                    baseBlocks[i] = new BaseBlock(0,dy,ImageLoader.getInstance().getBeehive2());
                    break;
                case 3:
                    baseBlocks[i] = new BaseBlock(0,dy,ImageLoader.getInstance().getBeehive3());
                    break;
                default:
                    baseBlocks[i] = null;
            }
            dy+=100;
        }
        return  baseBlocks;

    }
}