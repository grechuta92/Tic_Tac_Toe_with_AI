public class ComputerBot implements Player {

    private int xPosition = 0;
    private int oPosition = 0;
    GeneratorRandomNumbers generatorRandomNumbers = new GeneratorRandomNumbers();


    @Override
    public String move() {
        System.out.println("Making move level \"easy\"");
       setXTempPosition();
       setOTempPosition();
        return (this.xPosition + " " + this.oPosition);
    }

    @Override
    public void setXTempPosition() {
        this.xPosition = generatorRandomNumbers.takeXNumber();
    }

    @Override
    public void setOTempPosition() {
        this.oPosition = generatorRandomNumbers.takeONumber();
    }

    @Override
    public int getXPosition() {

        return 0;
    }

    @Override
    public int getOPosition() {

        return 0;
    }


}
