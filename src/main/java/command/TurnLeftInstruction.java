package command;

import domain.MarsRover;

public class TurnLeftInstruction implements MarsRoverInstruction {

    private MarsRover marsRover;

    public TurnLeftInstruction(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public String execute() {
        return marsRover.turnLeft();
    }
}
