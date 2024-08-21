package player;

import util.GameboardSearcher;
import game.Gameboard;

public class MediumComputer extends Computer {
    private final GameboardSearcher gameboardSearcher;
    public MediumComputer(char symbol, String name) {
        super(symbol, name);
        this.gameboardSearcher = new GameboardSearcher();
    }

    protected int[] getMoveCoords(Gameboard gameboard) {
        printLoadingDots();

        int[] winningMove = findBestMove(gameboard.getGameboard(), getSymbol());
        if (winningMove != null) {
            return winningMove;
        }

        int[] blockingMove = findBestMove(gameboard.getGameboard(), getSymbol() == 'X' ? 'O' : 'X');
        if (blockingMove != null) {
            return blockingMove;
        }

        int[] randomCoords = returnRandomCoords(gameboard);
        return new int[]{randomCoords[0], randomCoords[1]};
    }

    private int[] findBestMove(char[][] gameboard, char symbol) {

        int[][] rowSearch = gameboardSearcher.searchRows(gameboard, symbol);
        if (rowSearch != null) {
            int[] move = checkPossibleRowMove(gameboard, rowSearch);
            if (move != null) {
                return move;
            }
        }

        int[][] columnSearch = gameboardSearcher.searchColumns(gameboard, symbol);
        if (columnSearch != null) {
            int[] move = checkPossibleColumnMove(gameboard, columnSearch);
            if (move != null) {
                return move;
            }
        }


        int[][] diagonalSearch = gameboardSearcher.searchDiagonally(gameboard, symbol);
        if (diagonalSearch != null) {
            int[] move = checkPossibleDiagonalMove(gameboard, diagonalSearch);
            if (move != null) {
                return move;
            }
        }

        int[][] antiDiagonalSearch = gameboardSearcher.searchAntiDiagonally(gameboard, symbol);
        if (antiDiagonalSearch != null) {
            int[] move = checkPossibleAntiDiagonalMove(gameboard, antiDiagonalSearch);
            if (move != null) {
                return move;
            }
        }

        return null;
    }

    private int[] checkPossibleRowMove(char[][] gameboard, int[][] coords) {
        if (coords[1][1] == 2) {
            if (gameboard[coords[0][0]][0] == ' ') {
                return new int[]{coords[0][0], 0};
            }
        }

        if (coords[1][1] == 1) {
            if (gameboard[coords[0][0]][2] == ' ') {
                return new int[]{coords[0][0], 2};
            }
        }

        return null;
    }

    private int[] checkPossibleColumnMove(char[][] gameboard, int[][] coords) {
        if (coords[1][0] == 1) {
            if (gameboard[2][coords[0][1]] == ' ') {
                return new int[]{2, coords[0][1]};
            }
        }

        if (coords[1][0] == 2) {
            if (gameboard[0][coords[0][1]] == ' ') {
                return new int[]{0, coords[0][1]};
            }
        }

        return null;
    }

    private int[] checkPossibleDiagonalMove(char[][] gameboard, int[][] coords) {
        if (coords[0][0] == 0) {
            if (gameboard[2][2] == ' ') {
                return new int[] {2, 2};
            }
        }

        if (coords[0][0] == 1) {
            if (gameboard[0][0] == ' ') {
                return new int[] {0, 0};
            }
        }

        return null;
    }

    private int[] checkPossibleAntiDiagonalMove(char[][] gameboard, int[][] coords) {
        if (coords[0][0] == 0) {
            if (gameboard[2][0] == ' ') {
                return new int[] {2, 0};
            }
        }

        if (coords[0][0] == 1) {
            if (gameboard[0][2] == ' ') {
                return new int[] {0, 2};
            }
        }

        return null;
    }

}
