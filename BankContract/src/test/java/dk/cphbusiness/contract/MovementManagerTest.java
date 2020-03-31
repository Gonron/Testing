package dk.cphbusiness.contract;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assume.assumeThat;

public class MovementManagerTest {
    @Test
    public void testCreateMovement(){
        assumeThat(MovementManagerHolder.movementManager, not(nullValue()));
        List<MovementManager.MovementDetail> movement = MovementManagerHolder.movementManager.getMovements("0123456789");
        assumeThat(movement, not(nullValue()));
    }
}
