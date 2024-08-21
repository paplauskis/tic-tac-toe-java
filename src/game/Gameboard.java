package game;

public class Gameboard {
    private final char[][] gameboard = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public char[][] getGameboard() {
        return gameboard;
    }

    public void placeSymbol(int xCoordinate, int yCoordinate, char symbol) {
        gameboard[xCoordinate][yCoordinate] = symbol;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isFieldEmpty(int x, int y) {
        return gameboard[x][y] == ' ';
    }

    public char checkWinner(int x, int y, char symbol) {

        if (ColumnFind3InARow(x, symbol) != null) return symbol;

        if (RowFind3InARow(y, symbol) != null) return symbol;

        if (x == y) {
            if (DiagonalFind3InARow(symbol) != null) return symbol;
        }

        if (x + y == 2) {
            if (AntiDiagonalFind3InARow(symbol) != null) return symbol;
        }

        if (isDraw()) {
            return 'D';
        }

        return 'N';
    }

    private Character AntiDiagonalFind3InARow(char symbol) {
        for(int i = 0; i < 3; i++){
            if(gameboard[i][2 - i] != symbol)
                break;
            if(i == 2){
                return symbol;
            }
        }
        return null;
    }

    private Character DiagonalFind3InARow(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameboard[i][i] != symbol) {
                break;
            }
            if (i == 2) {
                return symbol;
            }
        }
        return null;
    }

    private Character RowFind3InARow(int y, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameboard[i][y] != symbol) {
                break;
            }
            if (i == 2) {
                return symbol;
            }
        }
        return null;
    }

    private Character ColumnFind3InARow(int x, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameboard[x][i] != symbol) {
                break;
            }
            if (i == 2) {
                return symbol;
            }
        }
        return null;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameboard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
