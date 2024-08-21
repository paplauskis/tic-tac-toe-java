package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner = new Scanner(System.in);

    public String getPlayer() {
        String player;
        do {
            player = scanner.nextLine().toLowerCase();
        } while(!player.equals("human") &&
                !player.equals("easy") &&
                !player.equals("medium"));
//                !player.equals("hard"));

        return player;
    }

    public int getCoordinate(String xy) {
        int coord = 0;
        boolean validNumber = false;
        while (!validNumber) {
            try {
                System.out.print("Enter the " + xy +  " coordinate: > ");
                coord = scanner.nextInt();
                validNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer");
                scanner.next();
            }
        }
        return coord;
    }

    public boolean areCoordinatesFrom0To2(int x, int y) {
        if ((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
            return true;
        } else {
            System.out.println("Invalid coordinates");
            System.out.println("Enter a number that is 1, 2 or 3");
            return false;
        }
    }
}
