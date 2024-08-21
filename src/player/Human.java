package player;

import util.InputReader;
import game.Gameboard;

public class Human implements Player {
    private final char symbol;
    private final String name;
    private final InputReader reader;

    public Human(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        this.reader = new InputReader();
    }
    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return  name;
    }

    private int[] getMoveCoords(Gameboard gameboard) {
        int rowCoord;
        int columnCoord;
        do {
            rowCoord = reader.getCoordinate("row") - 1;
            columnCoord = reader.getCoordinate("column") - 1;
        } while (!reader.areCoordinatesFrom0To2(rowCoord, columnCoord) ||
                !gameboard.isFieldEmpty(rowCoord, columnCoord));
        return new int[]{rowCoord, columnCoord};
    }

    public int[] attack(Gameboard gameboard) {
        int[] coords = getMoveCoords(gameboard);
        gameboard.placeSymbol(coords[0],
                coords[1],
                getSymbol());

        return coords;
    }
}
