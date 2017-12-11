package cabanas.garcia.ismael.tdd;

import java.util.Optional;

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

    public String execute(String commands) {
        String obstacle = "";
        for (char c : commands.toCharArray())
            if(c == 'R') {
                this.orientation = this.orientation.right();
            }
            else if(c == 'L') {
                this.orientation = this.orientation.left();
            }
            else if(c == 'M'){
                Optional<Coordinates> nextCoordinates = grid.nextCoordinateFor(coordinates, orientation);
                if(nextCoordinates.isPresent()) {
                    this.coordinates = nextCoordinates.get();
                }
                else {
                    obstacle = "O:";
                }
            }
        return obstacle + coordinates.x() + ":" + coordinates.y() + ":" + orientation.getValue();
    }
}
