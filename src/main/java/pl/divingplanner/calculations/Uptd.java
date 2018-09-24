package pl.divingplanner.calculations;

public class Uptd {

    double oxygenPressure;

    public double getOxygenPressure() {
        return oxygenPressure;
    }

    public Uptd(){

    }
    public Uptd(double oxygenPressure) {
        this.oxygenPressure = oxygenPressure;
    }

    public void setOxygenPressure(double oxygenPressure) {
        this.oxygenPressure = oxygenPressure;
    }

    public double countUptd(Uptd uptd){

        return Math.pow(((uptd.getOxygenPressure() -0.5)/0.5), 0.83);
    }


}
