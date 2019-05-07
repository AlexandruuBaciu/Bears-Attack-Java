package Items;

import java.awt.*;


public class Bear extends Item
{

    private int countdown = 20;
    private Image animation;
    public Bear(int x, int y, Image image, Image animation) {
        super(x, y);
        this.image = image;
        this.animation = animation;
    }

    public void move()
    {

        if(countdown > 0)
        {
            countdown--;
        }
        else
        {
            countdown=3;
            if(x>75)
                x-=15;
        }

    }

    public void setX(int x)
    {
        this.x=x;
    }

    public  void movingAnimation()
    {
            Image temp = image;
            image = animation;
            animation = temp;

    }


}
