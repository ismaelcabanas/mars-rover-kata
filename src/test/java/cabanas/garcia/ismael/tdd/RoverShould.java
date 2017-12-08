package cabanas.garcia.ismael.tdd;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverShould {

    private Rover rover;

    @Before public void
    setUp() {
        rover = new Rover();
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
            "R, E",
            "RR, S",
            "RRR, W",
            "RRRR, N"
    }) public void
    rotate_to_right(String commands, String expectedOrientation) {

        rover.execute(commands);

        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
    }

    @Test
    @Parameters({
            "L, W",
            "LL, S",
            "LLL, E",
            "LLLL, N"
    }) public void
    rotate_to_left(String commands, String expectedOrientation) {

        rover.execute(commands);

        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
    }

    @Test
    @Parameters({
            "M, 0, 1, N",
            "MMMM, 0, 4, N"
    }) public void
    move_up(String commands, int expectedPosX, int expectedPosY, String expectedOrientation) {

        rover.execute(commands);

        assertThat(rover.getPosX()).isEqualTo(expectedPosX);
        assertThat(rover.getPosY()).isEqualTo(expectedPosY);
        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

    @Test
    @Parameters({
            "RRM, 0, 9, S",
            "RRMMMM, 0, 6, S"
    }) public void
    move_down(String commands, int expectedPosX, int expectedPosY, String expectedOrientation) {

        rover.execute(commands);

        assertThat(rover.getPosX()).isEqualTo(expectedPosX);
        assertThat(rover.getPosY()).isEqualTo(expectedPosY);
        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

    @Test
    @Parameters({
            "RM, 1, 0, E",
            "RMMMM, 4, 0, E"
    }) public void
    move_right(String commands, int expectedPosX, int expectedPosY, String expectedOrientation) {

        rover.execute(commands);

        assertThat(rover.getPosX()).isEqualTo(expectedPosX);
        assertThat(rover.getPosY()).isEqualTo(expectedPosY);
        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

    @Test
    @Parameters({
            "LM, 9, 0, W",
            "LMMMM, 6, 0, W"
    }) public void
    move_left(String commands, int expectedPosX, int expectedPosY, String expectedOrientation) {

        rover.execute(commands);

        assertThat(rover.getPosX()).isEqualTo(expectedPosX);
        assertThat(rover.getPosY()).isEqualTo(expectedPosY);
        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

    @Test
    @Parameters({
            "MMMMMMMMMM, 0, 0, N"
    }) public void
    wrap_from_top_to_bottom_when_moving_to_north(String commands, int expectedPosX, int expectedPosY,
                                                          String expectedOrientation) {
        rover.execute(commands);

        assertThat(rover.getPosX()).isEqualTo(expectedPosX);
        assertThat(rover.getPosY()).isEqualTo(expectedPosY);
        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

    @Test
    @Parameters({
            "RMMMMMMMMMM, 0, 0, E"
    }) public void
    wrap_from_rigth_to_left_when_moving_to_east(String commands, int expectedPosX, int expectedPosY,
                                                 String expectedOrientation) {
        rover.execute(commands);

        assertThat(rover.getPosX()).isEqualTo(expectedPosX);
        assertThat(rover.getPosY()).isEqualTo(expectedPosY);
        assertThat(rover.getOrientation()).isEqualTo(expectedOrientation);
    }

}
