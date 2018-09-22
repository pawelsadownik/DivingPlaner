package pl.divingplanner.calculations;

public class VentilationStream {

    double co2Production;
    double absolutePressure;
    int amountOfDivers;
    double co2MaxPartialPressure;

    public VentilationStream() {
    }

    public VentilationStream(double co2Production, double absolutePressure, int amountOfDivers, double co2MaxPartialPressure) {
        this.co2Production = co2Production;
        this.absolutePressure = absolutePressure;
        this.amountOfDivers = amountOfDivers;
        this.co2MaxPartialPressure = co2MaxPartialPressure;
    }

    public double getCo2Production() {
        return co2Production;
    }

    public void setCo2Production(double co2Production) {
        this.co2Production = co2Production;
    }

    public double getAbsolutePressure() {
        return absolutePressure;
    }

    public void setAbsolutePressure(double absolutePressure) {
        this.absolutePressure = absolutePressure;
    }

    public int getAmountOfDivers() {
        return amountOfDivers;
    }

    public void setAmountOfDivers(int amountOfDivers) {
        this.amountOfDivers = amountOfDivers;
    }

    public double getCo2MaxPartialPressure() {
        return co2MaxPartialPressure;
    }

    public void setCo2MaxPartialPressure(double co2MaxPartialPressure) {
        this.co2MaxPartialPressure = co2MaxPartialPressure;
    }

    public double countStreamOfVent(VentilationStream ventilationStream){

        return (ventilationStream.getAbsolutePressure()*ventilationStream.getAmountOfDivers()*ventilationStream.getCo2Production())/ventilationStream.getCo2MaxPartialPressure();

    }

}
