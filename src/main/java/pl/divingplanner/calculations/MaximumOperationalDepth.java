package pl.divingplanner.calculations;

public class MaximumOperationalDepth {

    public double countMOD (double fraction, double partialPressure){

        return (10*partialPressure)/fraction;
    }
}
