package Items;

import java.awt.*;
import java.awt.event.KeyEvent;

import Game.Constants;
import Game.ImageLoader;

public class Player extends Item {

    public boolean isDead = false;
    public Player(int x, int y,Image image)
    {
        super(x, y);
        this.image = image;
    }



    public void move(int dy)
    {
        if (this.y +dy >= Constants.upLimit && this.y+dy <= Constants.downLimit)
        {
            this.y += dy;
        }
    }

    public void updateAnimation()
    {
        if (isDead == true)
        {
            image = ImageLoader.getInstance().getPlayerDestroyed();
        }

    }




    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP)
        {
            move(Constants.dMove);
        }

        if (key == KeyEvent.VK_DOWN) {
            move(Constants.dMove);
        }
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP)
        {
            move(Constants.mvUp);
        }
        if (key == KeyEvent.VK_DOWN) {
            move(Constants.mvDw);
        }
    }
}
