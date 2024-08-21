package player;

import game.Gameboard;

public class EasyComputer extends Computer {

    public EasyComputer(char symbol, String name) {
        super(symbol, name);
    }

    protected int[] getMoveCoords(Gameboard gameboard) {
        logger.printLoadingDots();
        int[] randomCoords = returnRandomCoords(gameboard);

        return new int[]{randomCoords[0], randomCoords[1]};
    }
}
