package pl.divingplanner.calculations;

public class Uptd {

    int oxygenMinutes;
    double oxygenPressure;

    public int getOxygenMinutes() {
        return oxygenMinutes;
    }

    public void setOxygenMinutes(int oxygenMinutes) {
        this.oxygenMinutes = oxygenMinutes;
    }

    public double getOxygenPressure() {
        return oxygenPressure;
    }


    public Uptd(double oxygenPressure) {
        this.oxygenPressure = oxygenPressure;
    }

    public void setOxygenPressure(double oxygenPressure) {
        this.oxygenPressure = oxygenPressure;
    }

    public double countUptd(double oxygenPressure){

        return Math.pow(((oxygenPressure -0.5)/0.5), 0.83);
    }

    public double countCptd(double uptd, int oxygenMinutes){

        return oxygenMinutes*uptd;
    }
}
