package command;

import domain.MarsRover;

public class TurnRightInstruction implements MarsRoverInstruction {

    private MarsRover marsRover;

    public TurnRightInstruction(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public String execute() {
        return marsRover.turnRight();
    }
}
