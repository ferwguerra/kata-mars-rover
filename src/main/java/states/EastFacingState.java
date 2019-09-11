package states;

public class EastFacingState implements FacingState {

    private final String name = "E";

    @Override
    public FacingState left() {
        return new NorthFacingState();
    }

    @Override
    public FacingState right() {
        return new SouthFacingState();
    }

    public String getName() {
        return name;
    }
}
