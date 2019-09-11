package states;

public class NorthFacingState implements FacingState {

    private final String name = "N";

    @Override
    public FacingState left() {
        return new WestFacingState();
    }

    @Override
    public FacingState right() {
        return new EastFacingState();
    }

    public String getName() {
        return name;
    }
}
