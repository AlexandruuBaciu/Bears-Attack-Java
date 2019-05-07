package Game;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JPanel
{

    private Image img;

    StartMenu()
    {
        UpdateImage();
        setLayout(null);
        setLocation(100,100);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT,this);
    }

    public void UpdateImage()
    {
        img= ImageLoader.getInstance().getMenu();
    }

}
