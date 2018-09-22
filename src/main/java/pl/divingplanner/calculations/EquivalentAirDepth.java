package pl.divingplanner.calculations;

public class EquivalentAirDepth {

    double nitroFraction;

    int depth;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getNitroFraction() {
        return nitroFraction;
    }

    public void setNitroFraction(double nitroFraction) {
        this.nitroFraction = nitroFraction;
    }

    public EquivalentAirDepth() {
    }

    public EquivalentAirDepth(int depth) {
        this.depth = depth;
    }

    public double countEAD(EquivalentAirDepth equivalentAirDepth){

        return ((equivalentAirDepth.getNitroFraction()*(equivalentAirDepth.getDepth()+10))/0.79)-10;
    }
}
