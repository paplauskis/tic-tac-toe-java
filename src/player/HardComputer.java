package player;

import game.Gameboard;

public class HardComputer extends Computer {
    public HardComputer(char symbol, String name) {
        super(symbol, name);
    }

    protected int[] getMoveCoords(Gameboard gameboard) {
        return new int[] {0, 0};
    }
}

// need to implement minimax later
// https://www.youtube.com/watch?v=trKjYdBASyQ
