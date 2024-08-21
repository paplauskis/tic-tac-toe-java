package game;

import player.Player;
import util.ConsoleLogger;

public class Game {
    private final ConsoleLogger logger;
    private final Gameboard gameboard;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;


    public Game(Player player1, Player player2) {
        this.logger = new ConsoleLogger();
        this.gameboard = new Gameboard();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        start();
    }

    public void start() {
        logger.printBoard(gameboard.getGameboard());
        gameplay();
    }

    private void swapTurns() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    private void gameplay() {
        while (true) {
            logger.printPlayerTurn(currentPlayer);
            int[] selectedCoords = currentPlayer.attack(gameboard);

            logger.printBoard(gameboard.getGameboard());
            char gameSequence = gameboard.checkWinner(
                    selectedCoords[0],
                    selectedCoords[1],
                    currentPlayer.getSymbol());

            if (gameSequence != 'N') {
                logger.printGameResult(gameSequence, currentPlayer);
                break;
            }

            swapTurns();
        }
    }
}
