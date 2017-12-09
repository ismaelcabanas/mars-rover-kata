package cabanas.garcia.ismael.tdd;

public class Rover {

    private Orientation orientation;
    private Coordinates coordinates;
    private Grid grid;

    public Rover(Grid grid) {
        this.coordinates = new Coordinates(0, 0);
        this.orientation = Orientation.NORTH;
        this.grid = grid;
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
                this.coordinates = grid.nextCoordinateFor(coordinates, orientation);
            }
    }
}
