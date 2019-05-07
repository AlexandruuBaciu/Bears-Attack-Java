package Items;
import Game.ImageLoader;

import java.awt.*;


public class BaseBlock extends Block {
    public boolean isDead = false;
    public BaseBlock(int x, int y, Image image) {
        super(x, y);
        this.image = image;
        setHealth(1);

    }

    public void updateAnimation()
    {
        if (isDead == true)
        {
            image = ImageLoader.getInstance().getBeehiveDestroyed();
            setHealth(0);
        }

        }
    }
