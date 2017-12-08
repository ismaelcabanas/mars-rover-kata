package cabanas.garcia.ismael.tdd;

class Grid {
    static final int MAX_HEIGHT = 10;
    static final int MAX_WIDTH = 10;

    Coordinates nextCoordinateFor(Coordinates coordinates, Orientation orientation) {
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

        return new Coordinates(x, y);
    }
}
