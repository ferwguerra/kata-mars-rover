import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverShould {

    MarsRover marsRover;
    Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = new Grid(10);
        marsRover = new MarsRover(grid);
    }

    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N"
    })
    public void turn_left(String command, String result) {
        assertThat(marsRover.execute(command), is(result));
    }

    @Test
    @Parameters({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N"
    })
    public void turn_right(String command, String result) {
        assertThat(marsRover.execute(command), is(result));
    }

    @Test
    @Parameters({
            "M, 0:1:N",
            "MM, 0:2:N",
            "MMM, 0:3:N",
            "MMMM, 0:4:N",
            "MMMMM, 0:5:N",
            "MMMMMM, 0:6:N",
            "MMMMMMM, 0:7:N",
            "MMMMMMMM, 0:8:N",
            "MMMMMMMMM, 0:9:N",
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMM, 0:1:N",

            "RM, 1:0:E",
            "RMM, 2:0:E",
            "RMMM, 3:0:E",
            "RMMMM, 4:0:E",
            "RMMMMM, 5:0:E",
            "RMMMMMM, 6:0:E",
            "RMMMMMMM, 7:0:E",
            "RMMMMMMMM, 8:0:E",
            "RMMMMMMMMM, 9:0:E",
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMM, 1:0:E",

            "LM, 9:0:W",
            "LMM, 8:0:W",
            "LMMM, 7:0:W",
            "LMMMM, 6:0:W",

            "LLM, 0:9:S",
            "LLMM, 0:8:S",
            "LLMMM, 0:7:S",
            "LLMMMM, 0:6:S"
    })
    public void move(String command, String result) {
        assertThat(marsRover.execute(command), is(result));
    }

    @Test
    @Parameters({
            "M, 0, 1, O:0:0:N",
            "MM, 0, 1, O:0:0:N",
            "MRM, 0, 1, O:0:0:N",
            "LM, 9, 0, O:0:0:W",

            "MMMMMRMMMMMLMMR, 3, 5, O:2:5:E",
    })
    public void move_with_obstacles(String command, int positionXObstacle, int positionYObstacle, String result) {
        Obstacle obstacle = new Obstacle(positionXObstacle, positionYObstacle);
        Grid grid = new Grid(10);
        grid.addObstacle(obstacle);
        MarsRover marsRover = new MarsRover(grid);

        assertThat(marsRover.execute(command), is(result));
    }


}
