package pl.divingplanner.calculations;

import org.junit.Test;

import static org.junit.Assert.*;

public class EquivalentAirDepthTest {

    @Test
    public void countEAD() {

        //given
     EquivalentAirDepth equivalentAirDepth = new EquivalentAirDepth();

   equivalentAirDepth.setDepth(30);
   equivalentAirDepth.setNitroFraction(0.64);

        //when
        double result = (int)equivalentAirDepth.countEAD(equivalentAirDepth);

        //then
        assertTrue(result == 23);
    }
}