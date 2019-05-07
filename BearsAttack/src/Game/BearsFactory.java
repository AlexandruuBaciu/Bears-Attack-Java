package Game;

import Items.Bear;

import java.util.ArrayList;
import java.util.Random;

public class BearsFactory
{
    public static ArrayList<Bear> getEnemies(int level)
    {
        if(level <=0 || level > Constants.levels)
        {
            return null;
        }
        ArrayList<Bear> bears = new ArrayList<>();
        Random rand = new Random();
        int dx = Constants.BOARD_WIDTH;
        int dy;
        synchronized (bears)
        {
            for (int i = 0; i < Constants.bearsNumber; ++i)
            {
                dy = rand.nextInt(500);
                dy = dy / 100 * 100 + 5;
                int aux = dx;
                switch (level)
                {
                    case 1:  bears.add(new Bear(aux, dy,ImageLoader.getInstance().getBear(),ImageLoader.getInstance().getBearMoving()));
                            break;
                    case 2:  bears.add(new Bear(aux, dy,ImageLoader.getInstance().getRobotBear(),ImageLoader.getInstance().getRobotEnemyMoving()));
                            break;
                    case 3:  bears.add(new Bear(aux, dy,ImageLoader.getInstance().getZombieBear(),ImageLoader.getInstance().getZombieBearMoving()));
                        break;
                }

                dx = aux + rand.nextInt(350) + 100;

            }
        }
        return bears;
    }
}
