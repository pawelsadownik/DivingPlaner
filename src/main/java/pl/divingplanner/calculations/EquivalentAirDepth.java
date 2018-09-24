package pl.divingplanner.calculations;

public class EquivalentAirDepth {

    double nitroFraction;

    int depth;

    double EAD;

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

    public double getEAD() {
        return EAD;
    }

    public void setEAD(double EAD) {
        this.EAD = EAD;
    }

    public EquivalentAirDepth() {
    }

    public EquivalentAirDepth(double nitroFraction, int depth) {
        this.nitroFraction = nitroFraction;
        this.depth = depth;
    }

    public double countEAD(EquivalentAirDepth equivalentAirDepth){

        return ((equivalentAirDepth.getNitroFraction()*(equivalentAirDepth.getDepth()+10))/0.79)-10;
    }
}
