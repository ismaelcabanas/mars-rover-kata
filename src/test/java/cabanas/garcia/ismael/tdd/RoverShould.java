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

}
