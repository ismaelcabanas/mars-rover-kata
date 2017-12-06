package cabanas.garcia.ismael.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test public void
    rotate_to_right() {
        rover.execute("R");

        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
        assertThat(rover.getOrientation()).isEqualTo("E");
    }

    @Test public void
    rotate_twice_to_right() {
        rover.execute("RR");

        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
        assertThat(rover.getOrientation()).isEqualTo("S");
    }

    @Test public void
    rotate_three_times_to_right() {
        rover.execute("RRR");

        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
        assertThat(rover.getOrientation()).isEqualTo("W");
    }

    @Test public void
    rotate_four_times_to_right() {
        rover.execute("RRRR");

        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
        assertThat(rover.getOrientation()).isEqualTo("N");
    }
}
