package cabanas.garcia.ismael.tdd;

public class Rover {

    private int posX;
    private int posY;
    private String orientation;

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
        this.orientation = "E";
    }
}
