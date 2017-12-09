package cabanas.garcia.ismael.tdd;

class Coordinates {
    private final int y;
    private final int x;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
