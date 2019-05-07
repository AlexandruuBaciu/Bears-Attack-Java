package Items;

import Game.Constants;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Item
{
    public int x;
    public int y;

    public  boolean vis;

    public Image image;


    public Item(int x, int y) {

        this.x = x;
        this.y = y;
        vis = true;
    }


    public Image getImage()
    {
        return image;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public  boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible)
    {
        vis = visible;
    }

    public void draw(Graphics g, ImageObserver o)
    {
        if(this.isVisible())
        {
        g.drawImage(this.getImage(), this.getX(), this.getY(), o);

        }
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, Constants.Image_WIDTH, Constants.Image_HEIGHT);
    }

}
