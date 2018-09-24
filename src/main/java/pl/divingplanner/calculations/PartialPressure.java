package pl.divingplanner.calculations;

public class PartialPressure {

    private double depth;
    private double fraction;
    private double partialPressure;

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public double getPartialPressure() {
        return partialPressure;
    }

    public void setPartialPressure(double partialPressure) {
        this.partialPressure = partialPressure;
    }

    public PartialPressure() {
    }

    public PartialPressure(double depth, double fraction, double partialPressure) {
        this.depth = depth;
        this.fraction = fraction;
        this.partialPressure = partialPressure;
    }

    public double countPartialPressure(PartialPressure partialPressure){

        return ((partialPressure.getDepth()/10)+1)*partialPressure.getFraction();

    }

    public double countFraction(PartialPressure partialPressure){

        return (partialPressure.getPartialPressure()*10)/(partialPressure.getDepth()+10);

    }

    public double countDepth(PartialPressure partialPressure){

        return ((partialPressure.getPartialPressure()*10)/partialPressure.getFraction()) - 10;

    }
}
