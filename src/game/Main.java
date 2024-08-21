package game;

import player.Player;
import player.PlayerFactory;
import util.ConsoleLogger;
import util.InputReader;

public class Main {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        InputReader reader = new InputReader();

        logger.printPlayerSelection("first");
        Player player1 = PlayerFactory.createPlayer(reader.getPlayer(), 'X');
        logger.printPlayerSelection("second");
        Player player2 = PlayerFactory.createPlayer(reader.getPlayer(), 'O');

        new Game(player1, player2);
    }
}
