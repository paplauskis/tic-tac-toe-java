package util;

import player.Player;

public class ConsoleLogger {
    public void printBoard(char[][] board) {
        System.out.println("-----------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.print(" ");
                System.out.print(board[i][j]);
                System.out.print(" ");
                if (j == 2) {
                    System.out.println("|");
                }
            }
        }
        System.out.println("-----------");
    }

    public void printGameResult(char gameSequence, Player player) {
        switch (gameSequence) {
            case 'X':
            case 'O':
                System.out.println(player.getName() + " wins! (" + player.getSymbol() + ")");
                break;
            case 'D':
                System.out.println("It is a draw!");
                break;
        }
    }

    public void printPlayerTurn(Player player) {
        System.out.println(player.getName() + "'s turn! (" + player.getSymbol() + ")");
    }

    public void printPlayerSelection(String numberOfPlayer) {
        System.out.println("Enter " + numberOfPlayer + "player");
        System.out.println("Players: 'easy', 'medium', 'hard' (computers), 'human'");
    }

}