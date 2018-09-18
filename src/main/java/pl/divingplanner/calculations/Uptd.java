package pl.divingplanner.calculations;

public class Uptd {


    public double countUptd(long oxygenPressure){

        double partMOD = ((oxygenPressure -0.5)/0.5);

        return Math.pow((partMOD), 0.83);
    }
}
