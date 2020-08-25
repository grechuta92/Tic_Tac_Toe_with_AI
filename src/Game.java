package tictactoe;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);

    ComputerBot playerComputer;
    PlayerOne playerOne;
    Table table;

    String startGameValue = "";
    String levelOfGame = "";

    private int xPositionPlayer = 0;
    private int oPositionPlayer = 0;
    private String positionsPlayerString = "";

    private int xPositionComputer = 0;
    private int oPositionComputer = 0;
    private String positionsComputerString = "";

    String stringWithCoordinates = "";
    boolean isTrue = false;

    String winner = "";

    int countXInRow = 0;
    int countOInRow = 0;
    int countXInColumn = 0;
    int countOInColumn = 0;
    int countXDiagonally = 0;
    int countODiagonally = 0;
    int countXOppositeDiagonally = 0;
    int countOOppositeDiagonally = 0;


    public void startGame() {
        table = new Table();
        playerOne = new PlayerOne();
        playerComputer = new ComputerBot();
        gameMenu();

    }

    public void gameMenu() {
        System.out.println("\nInput command: ");
        System.out.println("1.\"Start Game\"");
        System.out.println("2.\"Exit\"");
        startGameValue = scanner.nextLine();
        if (startGameValue.toLowerCase().equals("start game") || startGameValue.equals("1")) {
            continueGame();
        } else if (startGameValue.toLowerCase().equals("exit") || startGameValue.equals("2")) {
            System.exit(0);
        } else {
            System.out.println("Bad Parameters!");
            gameMenu();
        }
    }

    private void continueGame() {
        playerOneMove();
        table.printTable();

        computerMove();
        table.printTable();

        printWhoWin();
        if (!table.isBlankSpaces(table.table)) {
            gameMenu();
        }
        ;
    }


    public void playerOneMove() {
        positionsPlayerString = playerOne.move();
        changeStringWithCoordinateOnPositionValues(positionsPlayerString);
        isTrue = table.setValueInTable(xPositionPlayer, oPositionPlayer, "X");
        if (!isTrue) {
            resetPositionValue();
            playerOneMove();
        } else {
            stringWithCoordinates = "";
            resetPositionValue();
        }
        isTrue = false;
    }


    public void computerMove() {
        positionsComputerString = playerComputer.move();
        changeStringWithCoordinateOnPositionValues(positionsComputerString);
        isTrue = table.setValueInTable(xPositionComputer, oPositionComputer, "O");
        System.out.println(xPositionComputer + " " + oPositionComputer);
        if (!isTrue) {
            computerMove();
        } else {
            stringWithCoordinates = "";
            resetPositionValue();
        }
        isTrue = false;
    }

    private void resetPositionValue() {
        this.xPositionPlayer = 0;
        this.oPositionPlayer = 0;
        this.xPositionComputer = 0;
        this.oPositionComputer = 0;

    }

    private void changeStringWithCoordinateOnPositionValues(String player) {
        this.xPositionPlayer = Integer.parseInt(String.valueOf(player.charAt(0)));
        this.oPositionPlayer = Integer.parseInt(String.valueOf(player.charAt(2)));
        this.xPositionComputer = Integer.parseInt(String.valueOf(player.charAt(0)));
        this.oPositionComputer = Integer.parseInt(String.valueOf(player.charAt(2)));
    }

    public boolean threeInARow() {
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 5; j++) {
                if (table.getValueFromTable(i, j).equals("X")) {
                    countXInRow++;
                    if (countXInRow == 3) {
                        winner = "X";
                        return true;
                    }
                } else if (table.getValueFromTable(i, j).equals("O")) {
                    countOInRow++;
                    if (countOInRow == 3) {
                        winner = "O";
                        return true;
                    }
                }
            }
            countXInRow = 0;
            countOInRow = 0;
        }
        return false;
    }

    public boolean threeInColumn() {
        for (int j = 1; j < 5; j++) {
            for (int i = 0; i < 3; i++) {
                if (table.getValueFromTable(i, j).equals("X")) {
                    countXInColumn++;
                    if (countXInColumn == 3) {
                        winner = "X";
                        return true;
                    }
                } else if (table.getValueFromTable(i, j).equals("O")) {
                    countOInColumn++;
                    if (countOInColumn == 3) {
                        winner = "O";
                        return true;
                    }
                }
            }
            countXInColumn = 0;
            countOInColumn = 0;
        }
        return false;
    }


    public boolean threeDiagonally() {
        for (int i = 0; i < 3; i++) {
            if (table.getValueFromTable(i, i + 1).equals("X")) {
                countXDiagonally++;
            }
            if (table.getValueFromTable(i, i + 1).equals("O")) {
                countODiagonally++;
            }
        }
        if (countXDiagonally == 3) {
            winner = "X";
            countXDiagonally = 0;
            return true;
        } else if (countODiagonally == 3) {
            winner = "O";
            countODiagonally = 0;
            return true;
        } else {
            countODiagonally = 0;
            countXDiagonally = 0;
        }
        return false;
    }

    public boolean threeOppositeDiagonally() {
        for (int i = 2; i >= 0; i--) {
            if (table.getValueFromTable(i, 3 - i).equals("X")) {
                countXOppositeDiagonally++;
            }
            if (table.getValueFromTable(i, 3 - i).equals("O")) {
                countOOppositeDiagonally++;
            }
        }
        if (countXOppositeDiagonally == 3) {
            winner = "X";
            return true;
        } else if (countOOppositeDiagonally == 3) {
            winner = "O";
            return true;
        }
        countOOppositeDiagonally = 0;
        countXOppositeDiagonally = 0;
        return false;
    }

    public void printWhoWin() {
        boolean threeInARowTemp = threeInARow();
        boolean threeInColumnTemp = threeInColumn();
        boolean threeDiagonallyTemp = threeDiagonally();
        boolean threeOppositeDiagonallyTemp = threeOppositeDiagonally();
        if (threeInARowTemp) {
            threeInARow();
        } else if (threeInColumnTemp) {
            threeInColumn();
        } else if (!threeInARowTemp && !threeInColumnTemp) {
            if (threeDiagonallyTemp) {
                threeDiagonally();
            } else if (threeOppositeDiagonallyTemp) {
                threeOppositeDiagonally();
            }
        }

        if (threeInColumnTemp || threeInARowTemp || threeDiagonallyTemp || threeOppositeDiagonallyTemp) {
            System.out.println(winner + " wins");
            startGame();
        } else if (!threeInColumnTemp && !threeInARowTemp && !threeDiagonallyTemp && !threeOppositeDiagonallyTemp) {
            if (table.isBlankSpaces(table.table)) {
                continueGame();
            }
        }
        threeInColumnTemp = false;
        threeInARowTemp = false;
        threeDiagonallyTemp = false;
        threeOppositeDiagonallyTemp = false;
    }
}
