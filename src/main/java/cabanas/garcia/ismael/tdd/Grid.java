package cabanas.garcia.ismael.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class Grid {
    static final int MAX_HEIGHT = 10;
    static final int MAX_WIDTH = 10;
    private final List<Coordinates> obstaclesCoordinates;

    public Grid(List<Coordinates> obstaclesCoordinates) {
        this.obstaclesCoordinates = obstaclesCoordinates;
    }

    public Grid() {
        this.obstaclesCoordinates = Collections.emptyList();
    }

    Optional<Coordinates> nextCoordinateFor(Coordinates coordinates, Orientation orientation) {
        int x = coordinates.x();
        int y = coordinates.y();

        switch (orientation) {
            case NORTH:
                y = (y + 1) % Grid.MAX_HEIGHT;
                break;
            case SOUTH:
                y = (y > 0) ? y - 1 : Grid.MAX_HEIGHT - 1;
                break;
            case EAST:
                x = (x + 1) % Grid.MAX_WIDTH;
                break;
            case WEST:
                x = (x > 0) ? x - 1 : Grid.MAX_WIDTH - 1;
                break;
        }

        Coordinates newCoordinates = new Coordinates(x, y);

        if(isAnObstacle(newCoordinates))
            return Optional.empty();

        return Optional.of(newCoordinates);
    }

    private boolean isAnObstacle(Coordinates coordinates) {
        return obstaclesCoordinates.contains(coordinates);
    }
}
