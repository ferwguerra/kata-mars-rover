package states;

public class SouthFacingState implements FacingState {

    private final String name = "S";

    @Override
    public FacingState left() {
        return new EastFacingState();
    }

    @Override
    public FacingState right() {
        return new WestFacingState();
    }

    public String getName() {
        return name;
    }
}
