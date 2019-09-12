package domain;

public class Obstacle {
    private Position position;

    public Obstacle(int x, int y) {
        Position position = new Position(x, y);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
