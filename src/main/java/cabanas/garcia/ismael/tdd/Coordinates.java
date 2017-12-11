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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (y != that.y) return false;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        return result;
    }
}
