package domain;

public class MarsRover {

    public static final String OBSTACLE_INDICATOR = "O:";
    private final Grid grid;
    private Cardinal facing = Cardinal.N;
    private Position position = new Position(0, 0);
    private boolean obstacleFound = false;
    private StringBuffer finalPosition;

    public MarsRover(Grid grid) {
        this.grid = grid;
    }

    public String turnRight() {
        finalPosition = new StringBuffer();
        facing = facing.right();
        return getFinalPosition();
    }

    public String turnLeft() {
        finalPosition = new StringBuffer();
        facing = facing.left();
        return getFinalPosition();
    }

    public String move() {
        finalPosition = new StringBuffer();

        tryToMove();
        if (obstacleFound) {
            finalPosition.append(OBSTACLE_INDICATOR);
        }

        return getFinalPosition();
    }

    private String getFinalPosition() {
        return finalPosition
                .append(position.getX())
                .append(":")
                .append(position.getY())
                .append(":")
                .append(facing.name()).toString();
    }

    private void tryToMove() {
        Position potentialPosition = calculatePotentialPosition();
        if (!grid.hasAnyObstacleInPosition(potentialPosition)) {
            this.position = potentialPosition;
        } else {
            obstacleFound = true;
        }
    }

    private Position calculatePotentialPosition() {
        Position potentialPosition = new Position(this.position.getX(), this.position.getY());
        switch (facing) {
            case N:
                potentialPosition.increaseY();
                break;
            case E:
                potentialPosition.increaseX();
                break;
            case W:
                potentialPosition.decreaseX();
                break;
            case S:
                potentialPosition.decreaseY();
                break;
        }
        return getPositionLimitedByGridSize(potentialPosition);
    }

    private Position getPositionLimitedByGridSize(Position position) {
        if (position.getY() > grid.getUpperLimit()) {
            position.setY(grid.getLowerLimit());
        }

        if (position.getX() > grid.getUpperLimit()) {
            position.setX(grid.getLowerLimit());
        }

        if (position.getX() < grid.getLowerLimit()) {
            position.setX(grid.getUpperLimit());
        }

        if (position.getY() < grid.getLowerLimit()) {
            position.setY(grid.getUpperLimit());
        }

        return position;
    }


}
