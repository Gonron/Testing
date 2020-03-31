package dk.cphbusiness.backend.contract;

import dk.cphbusiness.contract.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MovementManagerTest.class
})

public class MovementManagerDummyTest {
    @BeforeClass
    public static void setupClass(){
        MovementManagerHolder.movementManager = new MovementManagerDummy();
    }
}
