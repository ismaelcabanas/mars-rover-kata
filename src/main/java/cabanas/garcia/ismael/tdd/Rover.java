package cabanas.garcia.ismael.tdd;

public class Rover {

    private int posX;
    private int posY;
    private Orientation orientation;

    public Rover() {
        this.posX = 0;
        this.posY = 0;
        this.orientation = Orientation.NORTH;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getOrientation() {
        return orientation.getValue();
    }

    public void execute(String commands) {
        for (char c : commands.toCharArray())
            if(c == 'R') {
                this.orientation = this.orientation.right();
            }
            else {
                this.orientation = this.orientation.left();
            }
        }
}
