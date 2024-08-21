package util;

public class GameboardSearcher {
    public int[][] searchRows(char[][] gameboard, char symbol) {
        boolean symbolFound;
        for (int i = 0; i < 3; i++) {
            symbolFound = false;
            for (int j = 0; j < 3; j++) {
                if (gameboard[i][j] == symbol) {
                    if (symbolFound) {
                        return new int[][]{{i, j - 1}, {i, j}};
                    }
                    symbolFound = true;
                } else symbolFound = false;
            }
        }
        return null;
    }

    public int[][] searchColumns(char[][] gameboard, char symbol) {
        boolean symbolFound;
        for (int i = 0; i < 3; i++) {
            symbolFound = false;
            for (int j = 0; j < 3; j++) {
                if (gameboard[j][i] == symbol) {
                    if (symbolFound) {
                        return new int[][]{{j - 1, i}, {j, i}};
                    }
                    symbolFound = true;
                } else symbolFound = false;
            }
        }
        return null;
    }

    public int[][] searchDiagonally(char[][] gameboard, char symbol) {
        boolean symbolFound = false;
        for (int i = 0; i < 3; i++) {
            if (gameboard[i][i] == symbol) {
                if (symbolFound) {
                    return new int[][]{{i - 1, i - 1}, {i, i}};
                }
                symbolFound = true;
            } else symbolFound = false;
        }
        return null;
    }

    public int[][] searchAntiDiagonally(char[][] gameboard, char symbol) {
        boolean symbolFound = false;
        for (int i = 0; i < 3; i++) {
            if (gameboard[i][2 - i] == symbol) {
                if (symbolFound) {
                    if (i == 1) {
                        return new int[][]{{0, 2}, {i, i}};
                    } else {
                        return new int[][]{{1, 1}, {i, i}};
                    }
                }
                symbolFound = true;
            } else symbolFound = false;
        }
        return null;
    }
}
