package cabanas.garcia.ismael.tdd;

enum Orientation {
    NORTH("N", "E", "W"), EAST("E", "S", "N"), WEST("W", "N", "S"), SOUTH("S", "W", "E");

    private final String value;
    private final String rightOrientation;
    private final String leftOrientation;

    Orientation(String value, String rightOrientation, String leftOrientation) {
        this.value = value;
        this.rightOrientation = rightOrientation;
        this.leftOrientation = leftOrientation;
    }

    public String getValue() {
        return value;
    }

    public Orientation right() {
        return directionTo(this.rightOrientation);
    }

    public Orientation left() {
        return directionTo(this.leftOrientation);
    }

    private Orientation directionTo(String actualOrientation) {
        for (Orientation orientation : values()) {
            if(actualOrientation.equals(orientation.value)) {
                return orientation;
            }
        }
        return null;
    }
}
