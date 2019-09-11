import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int upperLimit;
    private final int lowerLimit = 0;
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();

    public Grid(int size) {
        upperLimit = size - 1;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public boolean hasAnyObstacleInPosition(Position position) {
        return obstacles.stream().anyMatch(obstacle -> obstacle.getPosition().equals(position));
    }
}
