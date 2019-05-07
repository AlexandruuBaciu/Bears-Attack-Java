package Game;

import javax.swing.*;
import java.awt.*;

public class ImageLoader
{
    private Image grass1;
    private Image grass2;
    private Image brick1;
    private Image brick2;
    private Image brick3;
    private Image brick4;

    private Image playerDestroyed;
    private Image player;
    private Image robotPlayer;
    private Image survivalPlayer;
    private Image beehive;
    private Image beehive2;
    private Image beehive3;
    private Image beehiveDestroyed;
    private Image needle;
    private Image bullet;

    private Image enemyMoving;
    private Image enemy;
    private Image robotEnemyMoving;
    private Image robotEnemy;
    private Image zombieEnemy;
    private Image zombieEnemyMoving;

    private Image menu;
    private Image loser;
    private Image winner;



    private static ImageLoader instance=null;

    public static ImageLoader getInstance(){
        if( instance != null){
            return instance;
        }
        else{
            instance= new ImageLoader();
            return instance;
        }
    }

    private ImageLoader()
    {
        grass1 = loadImage("images/GRASS1.jpg");
        grass2 = loadImage("images/GRASS2.png");

        brick1 = loadImage("images/BRICK1.png");
        brick1 = brick1.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);
        brick2 = loadImage("images/BRICK2.png");
        brick2 = brick2.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        brick3 = loadImage("images/BRICK3.png");
        brick3 = brick3.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);
        brick4 = loadImage("images/BRICK4.png");
        brick4 = brick4.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        player = loadImage("images/Player.png");
        player = player.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        robotPlayer = loadImage("images/robotBee.png");
        robotPlayer = robotPlayer.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        survivalPlayer = loadImage("images/survivalBee.png");
        survivalPlayer = survivalPlayer.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        beehive = loadImage("images/Beehive.png");
        beehive = beehive.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);
        beehive2 = loadImage("images/Beehive2.png");
        beehive2 = beehive2.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);
        beehive3 = loadImage("images/Beehive3.png");
        beehive3 = beehive3.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        playerDestroyed = loadImage("images/DestroyedBee.png");
        playerDestroyed = playerDestroyed.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        beehiveDestroyed = loadImage("images/DestroyedBeehive.png");
        beehiveDestroyed = beehiveDestroyed.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        needle = loadImage("images/needle.png");
        needle = needle.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        bullet = loadImage("images/bullet.png");
        bullet = bullet.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        enemy = loadImage("images/BEAR.png");
        enemy = enemy.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        robotEnemy = loadImage("images/robotBear.png");
        robotEnemy = robotEnemy.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        zombieEnemy = loadImage("images/zombieBear.png");
        zombieEnemy = zombieEnemy.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        zombieEnemyMoving = loadImage("images/zombieBearMoving.png");
        zombieEnemyMoving = zombieEnemyMoving.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        robotEnemyMoving = loadImage("images/robotBearMoving.png");
        robotEnemyMoving = robotEnemyMoving.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        enemyMoving = loadImage("images/BEARMOVING.png");
        enemyMoving = enemyMoving.getScaledInstance(Constants.Image_WIDTH, Constants.Image_HEIGHT, Image.SCALE_DEFAULT);

        menu = loadImage("images/MenuImage.png");
        loser = loadImage("images/LOSER.png");
        winner = loadImage("images/WINNER.png");

    }

    public Image loadImage(String imageAddress)
    {
        ImageIcon icon = new ImageIcon(imageAddress);
        return icon.getImage();
    }
    public Image getGrass1()
    {
        return grass1;
    }
    public Image getGrass2()
    {
        return grass2;
    }
    public Image getBrick1()
    {
        return brick1;
    }
    public Image getBrick2()
    {
        return brick2;
    }
    public Image getBrick3()
    {
        return brick3;
    }
    public Image getBrick4()
    {
        return brick4;
    }
    public Image getPlayer()
    {
        return player;
    }
    public Image getRobotPlayer()
    {
        return robotPlayer;
    }
    public Image getBeehive()
    {
        return beehive;
    }
    public Image getBeehive2()
    {
        return beehive2;
    }
    public Image getBeehive3()
    {
        return beehive3;
    }
    public Image getPlayerDestroyed()
    {
        return playerDestroyed;
    }
    public Image getBeehiveDestroyed()
    {
        return beehiveDestroyed;
    }
    public Image getNeedle()
    {
        return needle;
    }
    public Image getBullet()
    {
        return bullet;
    }
    public Image getBear()
    {
        return enemy;
    }
    public Image getRobotBear()
    {
        return robotEnemy;
    }
    public Image getZombieBear()
    {
        return zombieEnemy;
    }
    public Image getMenu()
    {
        return menu;
    }
    public Image getBearMoving()
    {
        return enemyMoving;
    }
    public Image getLoser(){return  loser;}
    public Image getWinner(){return  winner;}
    public Image getRobotEnemyMoving(){return  robotEnemyMoving;}
    public Image getZombieBearMoving(){return zombieEnemyMoving;}
    public Image getSurvivalPlayer(){return survivalPlayer;}





}
