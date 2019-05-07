import Game.BearsAttack;

import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            BearsAttack ex = BearsAttack.getInstance();
        });
    }
}
