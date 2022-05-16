import game.state.StateGenerator;
import game.state.SimpleStateGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class DoorsTest {

    @Test
    void simpleGenerator() {
        StateGenerator generator = new SimpleStateGenerator(3);

        Double[] probs = {1.0 / 3, 1.0 / 3, 1.0 / 3};
        assertArrayEquals(Arrays.stream(generator.current().doors).map((door) -> door.probability).toArray(Double[]::new), probs);

    }
}
