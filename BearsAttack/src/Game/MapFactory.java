package Game;

public class MapFactory
{
    public static int[][] getMap(int level)
    {
        switch (level)
        {
            case 1: return Map.level1;
            case 2: return Map.level2;
            case 3: return Map.level3;
            default: return null;

        }
    }
}
