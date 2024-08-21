package player;

public class PlayerFactory {
    public static Player createPlayer(String type, char symbol) {
        return switch (type) {
            case "human" -> new Human(symbol, "Human");
            case "easy" -> new EasyComputer(symbol, "Noob computer");
            case "medium" -> new MediumComputer(symbol, "Average computer");
            case "hard" -> new HardComputer(symbol, "Super computer");
            default -> throw new IllegalArgumentException("Unknown player type:" + type);
        };
    }
}
