import states.FacingState;
import states.NorthFacingState;

public class MarsRover {

    public static final String OBSTACLE_INDICATOR = "O:";

    private boolean obstacleFound;
    private final Grid grid;
    private FacingState facing;
    private Position position;

    public MarsRover(Grid grid) {
        this.grid = grid;
        this.facing = new NorthFacingState();
        this.position = new Position(0, 0);
        this.obstacleFound = false;
    }

    public String execute(String command) {
        StringBuffer finalPosition = new StringBuffer();

        processCommands(command);

        if (obstacleFound) {
            finalPosition.append(OBSTACLE_INDICATOR);
        }

        return finalPosition
                .append(position.getX())
                .append(":")
                .append(position.getY())
                .append(":")
                .append(facing.getName()).toString();
    }

    private void processCommands(String command) {
        for (char instruction : command.toCharArray()) {
            switch (instruction) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    tryToMove();
                    if (obstacleFound) {
                        return;
                    }
                    break;
            }
        }
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
        switch (facing.getName()) {
            case "N":
                potentialPosition.increaseY();
                break;
            case "E":
                potentialPosition.increaseX();
                break;
            case "W":
                potentialPosition.decreaseX();
                break;
            case "S":
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

    private void turnRight() {
        facing = facing.right();
    }

    private void turnLeft() {
        facing = facing.left();
    }


}
