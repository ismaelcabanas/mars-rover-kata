package cabanas.garcia.ismael.tdd;

public class Rover {

    private static final int MAX_HEIGHT = 10;
    private static final int MAX_WIDTH = 10;

    private Orientation orientation;
    private Coordinates coordinates;

    public Rover() {
        this.coordinates = new Coordinates();
        this.orientation = Orientation.NORTH;
    }

    public int getPosX() {
        return this.coordinates.x();
    }

    public int getPosY() {
        return this.coordinates.y();
    }

    public String getOrientation() {
        return orientation.getValue();
    }

    public void execute(String commands) {
        for (char c : commands.toCharArray())
            if(c == 'R') {
                this.orientation = this.orientation.right();
            }
            else if(c == 'L') {
                this.orientation = this.orientation.left();
            }
            else if(c == 'M'){
                this.coordinates = move();
            }
    }

    private Coordinates move() {
        int x = this.coordinates.x();
        int y = this.coordinates.y();

        switch (this.orientation) {
            case NORTH:
                y = (y + 1) % MAX_HEIGHT;
                break;
            case SOUTH:
                y = (y > 0) ? y - 1 : MAX_HEIGHT - 1;
                break;
            case EAST:
                x = (x + 1) % MAX_WIDTH;
                break;
            case WEST:
                x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
                break;
        }

        return new Coordinates(x, y);
    }
}
