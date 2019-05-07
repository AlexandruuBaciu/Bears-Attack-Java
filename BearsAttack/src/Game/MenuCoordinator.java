package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuCoordinator
{
  private JFrame frame;
  private StartMenu START;
  private JPanel HELP;
  private JPanel SETTINGS;
  private JPanel GAMEOVER;
  private JPanel GAMEWON;
  private JPanel LEVELPANEL;

    MenuCoordinator(JFrame frame)
    {
        this.frame = frame;
        InitStartMenu();
        InitHelp();
        InitSettings();
        InitGameOver();
        InitGameWon();
        InitLevelPanel();

    }

    JButton GetButton(String s, int x, int y)
    {
        JButton button = new JButton(s);
        button.setSize(150,50);
        button.setLocation(x,y);
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return  button;
    }


    void ChangeContext(JPanel panel)
    {
        frame.getContentPane().removeAll();
        frame.getContentPane().invalidate();
        frame.getContentPane().add(panel);
        frame.getContentPane().validate();
        panel.requestFocusInWindow();
        panel.repaint();
    }

    void StartGame(int level)
    {

        System.out.println(level);
       /*if(level == 1)
       {
           Board board = new Board(PlayerFactory.getPlayer(1),MapFactory.getMap(1), BearsFactory.getEnemies(1),BaseBlocksFactory.getBaseBlocks(1),1);
           ChangeContext(board);
       }
       else{
           if(level == 2 )
           {
               Board board = new Board(PlayerFactory.getPlayer(2),MapFactory.getMap(2), BearsFactory.getEnemies(2),BaseBlocksFactory.getBaseBlocks(2),2);
               ChangeContext(board);
           }
           else
           {
               if(level == 3 )
               {
                   Board board = new Board(PlayerFactory.getPlayer(3),MapFactory.getMap(3), BearsFactory.getEnemies(3),BaseBlocksFactory.getBaseBlocks(3),3);
                   ChangeContext(board);
               }
           }
       }

*/
        Board board = new Board(PlayerFactory.getPlayer(level),MapFactory.getMap(level), BearsFactory.getEnemies(level),BaseBlocksFactory.getBaseBlocks(level),level);
        ChangeContext(board);
    }

    void InitStartMenu()
    {
        START = new StartMenu();
        frame.add(START);


        JButton play = GetButton("PLAY",700,150);
        play.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ChangeContext(LEVELPANEL);
            }
        });
        START.add(play);

        JButton help = GetButton("HELP",700,210);
        START.add(help);
        help.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoToHelp();
            }
        });
        START.add(help);


        JButton settings = GetButton("SETTINGS",700,270);
        settings.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoToSettings();
            }
        });
        START.add(settings);

        JButton exit =GetButton("EXIT",700,330);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        START.add(exit);

    }


    public void InitHelp()
    {
        HELP = new JPanel();
        HELP.setLayout(null);
        HELP.setLocation(100,100);
        HELP.setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
        HELP.setBackground(new Color(138,74,0));

        JButton back =GetButton("BACK",20,430);
        back.setForeground(Color.WHITE);

        JLabel text1 = new JLabel("The goal of the game is to save bee hives from the bad bears attack." );
        JLabel text2 = new JLabel("For this you have to control the hero, an aggressive bee called Shelby." );
        JLabel text3 = new JLabel("Move up: UP arrow");
        JLabel text4 = new JLabel( "Move down: DOWN arrow");
        JLabel text5 = new JLabel( "Shot: SPACEBAR");
        JLabel text6 = new JLabel("Hint: Try not to leave bears too close to the hero.");

        text1.setFont(new Font("Verdana",0,20));
        text2.setFont(new Font("Verdana",0,20));
        text3.setFont(new Font("Verdana",1,30));
        text4.setFont(new Font("Verdana",1,30));
        text5.setFont(new Font("Verdana",1,30));
        text6.setFont(new Font("Verdana",2,15));

        text1.setForeground(Color.WHITE);
        text2.setForeground(Color.WHITE);
        text3.setForeground(Color.WHITE);
        text4.setForeground(Color.WHITE);
        text5.setForeground(Color.WHITE);
        text6.setForeground(Color.WHITE);

        text1.setBounds(130,50, 900,100);
        text2.setBounds(130,90, 900,100);
        text3.setBounds(130,170, 900,100);
        text4.setBounds(130,210, 900,100);
        text5.setBounds(130,250, 900,100);
        text6.setBounds(200,400, 900,100);

        HELP.add(text1);
        HELP.add(text2);
        HELP.add(text3);
        HELP.add(text4);
        HELP.add(text5);
        HELP.add(text6);


        HELP.add(back);

        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoToStart();
            }
        });
    }
    public void InitSettings()
    {
        SETTINGS = new JPanel();
        SETTINGS.setLayout(null);
        SETTINGS.setLocation(100,100);
        SETTINGS.setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
        SETTINGS.setBackground(new Color(138,74,0));
        JButton back = GetButton("BACK",20,430);
        back.setForeground(Color.WHITE);
        SETTINGS.add(back);

        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoToStart();
            }
        });
    }

    public void InitGameOver()
    {
        GAMEOVER = new JPanel();
        GAMEOVER.setLayout(null);
        GAMEOVER.setLocation(100,100);
        GAMEOVER.setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
        GAMEOVER.setBackground(new Color(138,74,0));


        JLabel gameOverText= new JLabel();
        gameOverText.setFont(new Font("Osaka",1,60));
        gameOverText.setText("GAME OVER");
        gameOverText.setForeground(Color.WHITE);
        gameOverText.setBounds(Constants.BOARD_WIDTH/2-185,20, 400,200);
        GAMEOVER.add(gameOverText);




        JButton restart = GetButton("RESTART",Constants.BOARD_WIDTH/2-75,200);
        restart.setForeground(Color.WHITE);
        GAMEOVER.add(restart);
        restart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartGame(Board.currentLevel);
            }
        });

        JButton menu = GetButton("MENU",Constants.BOARD_WIDTH/2-75,260);
        menu.setForeground(Color.WHITE);
        GAMEOVER.add(menu);
        menu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoToStart();
            }
        });

        JButton exit = GetButton("EXIT",Constants.BOARD_WIDTH/2-75,320);
        exit.setForeground(Color.WHITE);
        GAMEOVER.add(exit);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
    public void InitGameWon()
    {

        GAMEWON = new JPanel();
        GAMEWON.setLayout(null);
        GAMEWON.setLocation(100,100);
        GAMEWON.setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
        GAMEWON.setBackground(new Color(138,74,0));


        JLabel gameWonText= new JLabel();
        gameWonText.setFont(new Font("Osaka",1,40));
        gameWonText.setText("LEVEL COMPLETED");
        gameWonText.setForeground(Color.WHITE);
        gameWonText.setBounds(Constants.BOARD_WIDTH/2-190,20, 400,200);
        GAMEWON.add(gameWonText);


        JButton next_level = GetButton("NEXT LEVEL",Constants.BOARD_WIDTH/2-75,200);
        next_level.setForeground(Color.WHITE);
        GAMEWON.add(next_level);
        next_level.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

              if(Board.currentLevel <= Constants.levels)
                {
                    StartGame(Board.currentLevel);
                }
            }
        });

        JButton menu = GetButton("MENU",Constants.BOARD_WIDTH/2-75,260);
        menu.setForeground(Color.WHITE);
        GAMEWON.add(menu);
        menu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoToStart();
            }
        });

        JButton exit = GetButton("EXIT",Constants.BOARD_WIDTH/2-75,320);
        exit.setForeground(Color.WHITE);
        GAMEWON.add(exit);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public void InitLevelPanel()
    {
        LEVELPANEL = new JPanel();
        LEVELPANEL.setLayout(null);
        LEVELPANEL.setLocation(100,100);
        LEVELPANEL.setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
        LEVELPANEL.setBackground(new Color(138,74,0));


        JLabel levelMENU = new JLabel("LEVEL MENU");
        levelMENU.setFont(new Font("TimesRoman",2,80));
        levelMENU.setForeground(Color.WHITE);
        levelMENU.setBounds(Constants.BOARD_WIDTH/2-250,20, 900,100);
        LEVELPANEL.add(levelMENU);

        JButton back = GetButton("BACK",20,430);
        back.setForeground(Color.WHITE);
        LEVELPANEL.add(back);
        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoToStart();
            }
        });

        JButton firstLevel = GetButton("1",10,150);
        firstLevel.setForeground(Color.WHITE);
        LEVELPANEL.add(firstLevel);
        firstLevel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartGame(1);
            }
        });

        JButton secondLevel = GetButton("2",290,150);

        secondLevel.setForeground(Color.WHITE);
        LEVELPANEL.add(secondLevel);
        secondLevel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Board.currentLevel >=2)
                {
                    StartGame(2);
                }
            }
        });

        JButton thirdLevel = GetButton("3",560,150);
        thirdLevel.setForeground(Color.WHITE);
        LEVELPANEL.add(thirdLevel);
        thirdLevel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Board.currentLevel >= 3) {
                    StartGame(3);
                }
            }
        });

        JButton fourthLevel = GetButton("NOT AVAILABLE",840,150);
        fourthLevel.setForeground(Color.WHITE);
        LEVELPANEL.add(fourthLevel);
        fourthLevel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    public void GoToStart()
    {
        ChangeContext(START);
    }
    public void GoToSettings(){ChangeContext(SETTINGS);}
    public void GoToHelp(){ChangeContext(HELP);}
    public void GoToGameOver(){ChangeContext(GAMEOVER);}
    public void GoToGameWon(){ChangeContext(GAMEWON);}

}
