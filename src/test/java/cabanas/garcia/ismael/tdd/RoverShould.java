package cabanas.garcia.ismael.tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverShould {

    @Test
    public void
    startup_in_initial_position() {
        Rover rover = new Rover();

        assertThat(rover.getPosX()).isEqualTo(0);
        assertThat(rover.getPosY()).isEqualTo(0);
        assertThat(rover.getOrientation()).isEqualTo("N");
    }

}
