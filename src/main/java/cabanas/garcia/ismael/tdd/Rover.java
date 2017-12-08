package cabanas.garcia.ismael.tdd;

public class Rover {

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
                this.coordinates = new Grid().nextCoordinateFor(coordinates, orientation);
            }
    }
}
