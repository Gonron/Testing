package dk.cphbusiness.backend.doubles;
import dk.cphbusiness.backend.models.Clock;

public class ClockDummy implements Clock {
    @Override
    public long getTime() {
        return 0;
    }
}
