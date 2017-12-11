package cabanas.garcia.ismael.tdd;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverShould {

    private Rover rover;

    @Before public void
    setUp() {
        Grid grid = new Grid();
        rover = new Rover(grid);
    }

    @Test
    public void
    startup_in_initial_position() {
        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
        assertThat(rover.getOrientation()).isEqualTo("N");
    }

    @Test
    @Parameters({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N"
    }) public void
    rotate_to_right(String commands, String expectedResult) {

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N"
    }) public void
    rotate_to_left(String commands, String expectedResult) {

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "M, 0:1:N",
            "MMMM, 0:4:N"
    }) public void
    move_up(String commands, String expectedResult) {

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "RRM, 0:9:S",
            "RRMMMM, 0:6:S"
    }) public void
    move_down(String commands, String expectedResult) {

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "RM, 1:0:E",
            "RMMMM, 4:0:E"
    }) public void
    move_right(String commands, String expectedResult) {

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "LM, 9:0:W",
            "LMMMM, 6:0:W"
    }) public void
    move_left(String commands, String expectedResult) {

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "MMMMMMMMMM, 0:0:N"
    }) public void
    wrap_from_top_to_bottom_when_moving_to_north(String commands, String expectedResult) {

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "RMMMMMMMMMM, 0:0:E"
    }) public void
    wrap_from_rigth_to_left_when_moving_to_east(String commands,
                                                 String expectedResult) {
        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }

    @Test
    @Parameters({
            "MMM, 0:2:N"
    }) public void
    stop_when_obstacle_in_0_3(String commands, String expectedResult) {
        Coordinates coordinate_0_3 = new Coordinates(0, 3);
        Grid gridWithObstacle = new Grid(Arrays.asList(coordinate_0_3));
        Rover rover = new Rover(gridWithObstacle);

        String actual = rover.execute(commands);

        assertThat(actual).isEqualTo(expectedResult);
    }
}
