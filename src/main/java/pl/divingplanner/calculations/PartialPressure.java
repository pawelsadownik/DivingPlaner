package pl.divingplanner.calculations;

public class PartialPressure {

    private double depth;
    private double fraction;

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


    public double countPartialPressure(double x, double y){

        return ((x/10)+1)*y;

    }

    public double countFraction(double depth, double pressure){

        return (pressure*10)/(depth+10);

    }

    public double countDepth(double pressure ,double fraction){

        return ((pressure*10)/fraction) - 10;

    }
}
