package command;

import domain.MarsRover;

public class MoveInstruction implements MarsRoverInstruction {

    private MarsRover marsRover;

    public MoveInstruction(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Override
    public String execute() {
        return marsRover.move();
    }
}
