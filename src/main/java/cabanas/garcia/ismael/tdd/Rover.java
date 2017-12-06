package cabanas.garcia.ismael.tdd;

public class Rover {

    private final int posX;
    private final int posY;
    private final String orientation;

    public Rover() {
        this.posX = 0;
        this.posY = 0;
        this.orientation = "N";
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getOrientation() {
        return orientation;
    }

    public void execute(String commands) {

    }
}
