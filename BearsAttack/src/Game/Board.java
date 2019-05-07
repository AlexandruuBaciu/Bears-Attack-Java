package Game;

import Items.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel implements Runnable, Constants {
    private boolean ingame = true;
    private boolean gameOver = false;
    private boolean gameWon = false;
    public static int score;
    public static int score1 = 0;
    public static int score2;
    public static int score3;

    private final ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<Bullet> bullets = new ArrayList<>();

    private Thread animator;
    private Thread process;
    private int cooldown;
    private int bearsDeath = 0;
    private Item loser;
    private Item winner;
    public static int currentLevel;


    private Player levelPlayer;
    private int[][] levelMap;
    private ArrayList<Bear> levelBears;
    private  BaseBlock[] levelBaseBlocks;

    public Board(Player p, int[][] map,ArrayList<Bear> b, BaseBlock[] base, int level)
    {
        currentLevel = level;
        switch (currentLevel)
        {
            case 1:
                score = score1;
                break;
            case 2:
                score = score2;
                break;
            case 3:
                score = score3;
                break;

        }
        levelPlayer=p;
        levelMap=map;
        levelBears = b;
        levelBaseBlocks = base;
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        gameInit();
        cooldown=0;

        if (animator == null || !ingame) {

            animator = new Thread(this);
            animator.start();
        }
        if (process == null || !ingame) {

            process = new Thread(this);
            process.start();
        }
    }

    public void addNotify() {

        super.addNotify();
    }

    public void gameInit() {
        int type;
        for (int x = 0; x < levelMap.length; x++) {
            for (int y = 0; y < levelMap[0].length; y++) {
                type = levelMap[x][y];
                BlockType bType = BlockType.getTypeFromInt(type);
                switch (bType) {
                    case GRASS1:
                        items.add(new Grass1(y * 100, x * 100));
                        break;
                    case GRASS2:
                        items.add(new Grass2(y * 100, x * 100));
                        break;
                    case BRICK1:
                        items.add(new Brick1(y * 100, x * 100));
                        break;
                    case BRICK2:
                        items.add(new Brick2(y * 100, x * 100));
                        break;
                    case BRICK3:
                        items.add(new Brick3(y * 100, x * 100));
                        break;
                    case BRICK4:
                        items.add(new Brick4(y * 100, x * 100));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void run() {
        if (Thread.currentThread() == process) {
            processCycle();
        }
        else
        {
            animationCycle();

        }
    }



    public void GameOver()
    {

        loser = new Item(0,0);
        loser.image = ImageLoader.getInstance().getLoser();
        loser.image = loser.image.getScaledInstance(1010,500,Image.SCALE_DEFAULT);

    }

    public void GameWon()
    {
        winner = new Item(200,40);
        winner.image = ImageLoader.getInstance().getWinner();
        switch (currentLevel)
        {
            case 1:
                score2 = score;
                break;
            case 2:
                score3 = score;
                break;
        }
    }

    public void processCycle()
    {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        while (ingame) {

            if(Constants.bearsNumber == bearsDeath)
            {
                gameWon = true;
                GameWon();
            }

            if(!gameOver && !gameWon)
            {
                CheckCollisions();
                synchronized (bullets) {
                    for (Bullet a : bullets) {
                        a.move();
                    }
                }
                synchronized (levelBears) {
                    for (Bear b : levelBears) {
                        b.move();
                    }
                }
                if(cooldown>0)
                {
                    cooldown--;
                }
            }
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            beforeTime = System.currentTimeMillis();
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted Process");
            }
        }
    }

    public void animationCycle()
    {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        while (ingame)
        {
            repaint();

            if(!gameOver && !gameWon)
            {
                AnimationWithCollisions();

            }
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }


            beforeTime = System.currentTimeMillis();
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted Animator");
            }
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame)
        {
            for (Item a : items) {
                a.draw(g,this);
            }
            for(int i = 0; i < 5;++i){
                    levelBaseBlocks[i].draw(g,this);
            }
            levelPlayer.draw(g,this);
            synchronized (bullets)
            {
                for(Bullet a: bullets)
                {
                        a.draw(g, this);
                }
            }
            synchronized (levelBears)
            {
                for(Bear b:levelBears)
                {
                        b.draw(g, this);
                }
            }
            if(gameOver)
            {
             loser.draw(g,this);
            }
            if(gameWon)
            {
                winner.draw(g,this);
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("arial",Font.PLAIN,25));
            g.drawString("SCORES: " + score,820,490);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void AnimationWithCollisions()
    {
        synchronized (levelBears)
        {
            synchronized (levelBaseBlocks)
            {
                for (Bear b : levelBears)
                {
                    Rectangle r1 = b.getBounds();
                    for(BaseBlock c: levelBaseBlocks)
                    {
                        Rectangle r2 = c.getBounds();
                        if(r1.intersects(r2) && b.isVisible())
                        {
                            c.isDead = true;
                            c.updateAnimation();
                            gameOver=true;
                            GameOver();
                        }
                    }
                    Rectangle r2 = levelPlayer.getBounds();
                    if(r1.intersects(r2) && b.isVisible())
                    {
                        b.setX(b.getX());
                        levelPlayer.isDead = true;
                        levelPlayer.updateAnimation();
                        gameOver = true;
                        GameOver();
                    }
                }
                for(Bear b : levelBears) {
                    if (b.isVisible()) {
                        b.movingAnimation();
                    }
                }
            }
        }
    }

    public void CheckCollisions()
    {
        synchronized (levelBears)
        {
            synchronized (bullets)
            {
                for (Bear b : levelBears)
                {
                    Rectangle r1 = b.getBounds();
                    for (Bullet a : bullets)
                    {
                        if (b.getX() < BOARD_WIDTH - 20) {
                            Rectangle r2 = a.getBounds();
                            if (r1.intersects(r2) && a.isVisible() && b.isVisible() && b.getX() > a.getX()-150) {
                                a.setVisible(false);
                                b.setVisible(false);
                                switch (currentLevel)
                                {
                                    case 1:
                                        score+=20;
                                        break;
                                    case 2:
                                        score+=40;
                                        break;
                                    case 3:
                                        score+=50;
                                        break;
                                }
                                bearsDeath++;
                            }
                        }
                    }
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter
    {
        public void keyReleased(KeyEvent e) {

            if (!gameOver && !gameWon) {
                levelPlayer.keyReleased(e);
            }
            else{
                if(gameOver) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        BearsAttack currentGame = BearsAttack.getInstance();
                        currentGame.GoToGameOver();
                        ingame = false;
                    }
                }
                if(gameWon) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        BearsAttack currentGame = BearsAttack.getInstance();
                        currentGame.GoToGameWon();
                        ingame = false;
                        currentLevel++;

                    }
                }
            }
        }

        public void keyPressed(KeyEvent e) {
            if (!gameOver && !gameWon) {
                levelPlayer.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                    if (cooldown == 0) {
                        cooldown = BulletCooldown;
                        synchronized (bullets) {
                            bullets.add(new Bullet(levelPlayer.getX(), levelPlayer.getY()));
                        }
                    }
                }
            }
        }
   }
}



