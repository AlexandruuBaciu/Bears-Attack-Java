package Game;

public enum BlockType
{
    GRASS1(0), GRASS2(1), BRICK1(2), BRICK2(3), BRICK3(4), BRICK4(5);

    private final int value;

    private BlockType(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public static BlockType getTypeFromInt(int value)
    {
        return BlockType.values()[value];
    }
}
