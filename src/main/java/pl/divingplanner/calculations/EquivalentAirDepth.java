package pl.divingplanner.calculations;

public class EquivalentAirDepth {


    public double countEAD(int nitroFraction, int depth){

        return ((nitroFraction*(depth+10))/0.79)-10;
    }
}
