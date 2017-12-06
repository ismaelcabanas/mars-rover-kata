package cabanas.garcia.ismael.tdd;

public enum Orientation {
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
        for (Orientation orientation : values()) {
            if(rightOrientation.equals(orientation.value)) {
                return orientation;
            }
        }
        return null;
    }

    public Orientation left() {
        for (Orientation orientation : values()) {
            if(leftOrientation.equals(orientation.value)) {
                return orientation;
            }
        }
        return null;
    }
}
