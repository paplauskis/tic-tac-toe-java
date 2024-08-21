package player;

import game.Gameboard;

public interface Player {

    char getSymbol();

    String getName();

    int[] attack(Gameboard gameboard);
}
