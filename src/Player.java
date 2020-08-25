public interface Player {

    String name = "";
    int xPosition = 0;
    int oPosition = 0;

    String move();

    int getXPosition();

    int getOPosition();

    void setXTempPosition();

    void setOTempPosition();

}
