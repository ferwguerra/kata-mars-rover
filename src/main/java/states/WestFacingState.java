package states;

public class WestFacingState implements FacingState {

    private final String name = "W";

    @Override
    public FacingState left() {
        return new SouthFacingState();
    }

    @Override
    public FacingState right() {
        return new NorthFacingState();
    }

    public String getName() {
        return name;
    }
}
