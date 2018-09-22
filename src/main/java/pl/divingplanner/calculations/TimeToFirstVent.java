package pl.divingplanner.calculations;

public class TimeToFirstVent {

    int chamberVolume;
    int amountOfDivers;
    int co2Production;
    double maxPartialPressureCO2;
    double beginPartialPressureCO2;

    public TimeToFirstVent() {
    }

    public TimeToFirstVent(int chamberVolume, int amountOfDivers, int co2Production, double maxPartialPressureCO2, double beginPartialPressureCO2) {
        this.chamberVolume = chamberVolume;
        this.amountOfDivers = amountOfDivers;
        this.co2Production = co2Production;
        this.maxPartialPressureCO2 = maxPartialPressureCO2;
        this.beginPartialPressureCO2 = beginPartialPressureCO2;
    }
    public int getChamberVolume() {
        return chamberVolume;
    }

    public void setChamberVolume(int chamberVolume) {
        this.chamberVolume = chamberVolume;
    }

    public int getAmountOfDivers() {
        return amountOfDivers;
    }

    public void setAmountOfDivers(int amountOfDivers) {
        this.amountOfDivers = amountOfDivers;
    }

    public int getCo2Production() {
        return co2Production;
    }

    public void setCo2Production(int co2Production) {
        this.co2Production = co2Production;
    }

    public double getMaxPartialPressureCO2() {
        return maxPartialPressureCO2;
    }

    public void setMaxPartialPressureCO2(double maxPartialPressureCO2) {
        this.maxPartialPressureCO2 = maxPartialPressureCO2;
    }

    public double getBeginPartialPressureCO2() {
        return beginPartialPressureCO2;
    }

    public void setBeginPartialPressureCO2(double beginPartialPressureCO2) {
        this.beginPartialPressureCO2 = beginPartialPressureCO2;
    }


    public double countTimeToVent(TimeToFirstVent timeToFirstVent){

        return (timeToFirstVent.getChamberVolume()*(timeToFirstVent.getMaxPartialPressureCO2()-timeToFirstVent.getBeginPartialPressureCO2()))/ (timeToFirstVent.getAmountOfDivers()*timeToFirstVent.getCo2Production());

    }

}
