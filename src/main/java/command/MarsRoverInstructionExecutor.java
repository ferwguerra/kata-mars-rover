package command;

import domain.Grid;
import domain.MarsRover;
import domain.Obstacle;

public class MarsRoverInstructionExecutor {

    private MarsRover marsRover;
    private Grid grid = new Grid(10);

    public String execute(String command) {
        marsRover = new MarsRover(grid);
        String finalPosition = "";

        for (char instruction : command.toCharArray()) {
            MarsRoverInstruction marsRoverInstruction;

            marsRoverInstruction = createMarsRoverInstruction(instruction);
            finalPosition = marsRoverInstruction.execute();

            if(didMarsFindAnObstacleInPosition(finalPosition)) {
                break;
            }
        }

        return finalPosition;
    }

    private MarsRoverInstruction createMarsRoverInstruction(char instruction) {
        MarsRoverInstruction marsRoverInstruction;
        switch (instruction) {
            case 'L':
                marsRoverInstruction = new TurnLeftInstruction(marsRover);
                break;
            case 'R':
                marsRoverInstruction = new TurnRightInstruction(marsRover);
                break;
            case 'M':
                marsRoverInstruction = new MoveInstruction(marsRover);
                break;
            default:
                throw new IllegalStateException("Unknown instruction: " + instruction);
        }
        return marsRoverInstruction;
    }

    private boolean didMarsFindAnObstacleInPosition(String finalPosition) {
        return finalPosition.startsWith(MarsRover.OBSTACLE_INDICATOR);
    }

    public void addObstacleToGrid(Obstacle obstacle) {
        this.grid.addObstacle(obstacle);
    }
}
