package states;

public interface FacingState {

    FacingState left();

    FacingState right();

    String getName();
}
