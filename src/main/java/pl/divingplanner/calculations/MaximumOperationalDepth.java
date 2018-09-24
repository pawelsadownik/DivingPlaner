package pl.divingplanner.calculations;

public class MaximumOperationalDepth {


    double fraction;
    double partialPressure;

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public double getPartialPressure() {
        return partialPressure;
    }

    public MaximumOperationalDepth() {
    }

    public MaximumOperationalDepth(double fraction, double partialPressure) {
        this.fraction = fraction;
        this.partialPressure = partialPressure;
    }

    public void setPartialPressure(double partialPressure) {
        this.partialPressure = partialPressure;
    }

    public double countMOD (MaximumOperationalDepth maximumOperationalDepth){

        return (10*maximumOperationalDepth.getPartialPressure())/maximumOperationalDepth.getFraction();
    }
}
