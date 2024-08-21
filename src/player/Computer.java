package player;

import java.util.Random;
import game.Gameboard;

public abstract class Computer implements Player {
    private final char symbol;
    private final String name;
    private final Random random;

    public Computer(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        this.random = new Random();
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    protected int getRandomCoord() {
        return random.nextInt(1, 4);
    }

    protected int[] returnRandomCoords(Gameboard gameboard) {
        int randomRowCoord;
        int randomColumnCoord;
        do {
            randomRowCoord = getRandomCoord() - 1;
            randomColumnCoord = getRandomCoord() - 1;
        } while(!gameboard.isFieldEmpty(randomRowCoord, randomColumnCoord));

        return new int[] {randomRowCoord, randomColumnCoord};
    }

    protected abstract int[] getMoveCoords(Gameboard gameboard);

    public int[] attack(Gameboard gameboard) {
        int[] coords = getMoveCoords(gameboard);
        gameboard.placeSymbol(coords[0],
                coords[1],
                getSymbol());

        return coords;
    }

    protected void printLoadingDots() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.print(". ");
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }
        System.out.println(" ");
    }
}
