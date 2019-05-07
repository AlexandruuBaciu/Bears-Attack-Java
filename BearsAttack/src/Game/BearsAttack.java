package Game;
import javax.swing.*;

public class BearsAttack extends JFrame implements Constants {

    private static BearsAttack instance = null;
    private MenuCoordinator menu;

    private BearsAttack() {
        setTitle("Bears Attack");
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setResizable(false);


        menu = new MenuCoordinator(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static BearsAttack getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new BearsAttack();
            return instance;
        }
    }

    public void GoToGameOver() {

        menu.GoToGameOver();
    }

    public void GoToGameWon() {

        menu.GoToGameWon();
    }
}

