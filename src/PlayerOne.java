package tictactoe;

import java.util.Scanner;

public class PlayerOne implements Player {

    Scanner scanner = new Scanner(System.in);

    private int xPosition = 0;
    private int oPosition = 0;

    private String xTempPosition = "";
    private String oTempPosition = "";

    @Override
    public String move() {
        System.out.println("Enter the coordinates: ");
        setxPosition();
        setoPosition();

        return getXPosition() + " " + getOPosition();

    }

    private void setxPosition() {
        System.out.println("Set X Positon (1-3)");
        setXTempPosition();

        if ((checkIsANumber(this.xTempPosition) && checkIsTheNumbersFromRange(xTempPosition))) {
            this.xPosition = Integer.parseInt(this.xTempPosition);
        } else {
            setxPosition();
        }
    }

    private void setoPosition(){
        System.out.println("Set O Position (1-3)");
        setOTempPosition();

        if ((checkIsANumber(this.oTempPosition) && checkIsTheNumbersFromRange(oTempPosition))) {
            this.oPosition = Integer.parseInt(this.oTempPosition);
        } else {
            setoPosition();
        }
    }


    @Override
    public int getXPosition() {
        return this.xPosition;
    }

    @Override
    public int getOPosition() {
        return this.oPosition;
    }

    public void setXTempPosition() {
        this.xTempPosition = scanner.next();
    }

    @Override
    public void setOTempPosition() {
        this.oTempPosition = scanner.next();
    }

    private boolean checkIsANumber(String tempValues) {
        if (tempValues.equals("exit")) {
            System.exit(0);
        } else if (!tempValues.matches("[0-9]")) {
            System.out.println("You should enter numbers!");
            move();
            return false;
        }
        return true;
    }

    public boolean checkIsTheNumbersFromRange(String xO) {
        int xOTemp = Integer.parseInt(xO);
        if (xOTemp < 0 || xOTemp > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
    }

}
