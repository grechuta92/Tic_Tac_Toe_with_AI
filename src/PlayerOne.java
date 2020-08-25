import java.util.Scanner;

public class PlayerOne implements Player {

    Scanner scanner = new Scanner(System.in);

    private int xPosition = 0;
    private int oPosition = 0;

    private String xTempPosition = "";
    private String oTempPosition = "";

    @Override
    public String move() {
        System.out.print("Enter the coordinates: ");

        setXTempPosition();
        checkIsANumber(this.xTempPosition);
        this.xPosition = Integer.parseInt(this.xTempPosition);
        checkIsTheNumbersFromRange(xPosition );

        setOTempPosition();
        checkIsANumber(this.oTempPosition);
        this.oPosition = Integer.parseInt(this.oTempPosition);
        checkIsTheNumbersFromRange(xPosition );

        return getXPosition() + " " + getOPosition();

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

    private void checkIsANumber(String tempValues) {
        if (tempValues.equals("exit")) {
            System.exit(0);
        } else if (!tempValues.matches("[0-9]")) {
            System.out.println("You should enter numbers!");
            move();
        }
    }

    public void checkIsTheNumbersFromRange(int xO) {
        if (xO < 0 || xO > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            move();
        }
    }

}
