package pl.divingplanner.calculations;

public class TimeUnderWater {

    private int surfaceAirConsuption;
    private int tankVolume;
    private double tankPressure;
    private double absolutePressure;
    private double time;

    public TimeUnderWater(int surfaceAirConsuption, int tankVolume, double tankPressure, double absolutePressure, double time) {
        this.surfaceAirConsuption = surfaceAirConsuption;
        this.tankVolume = tankVolume;
        this.tankPressure = tankPressure;
        this.absolutePressure = absolutePressure;
        this.time = time;
    }

    public TimeUnderWater(){

    }
    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getSurfaceAirConsuption() {
        return surfaceAirConsuption;
    }

    public void setSurfaceAirConsuption(int surfaceAirConsuption) {
        this.surfaceAirConsuption = surfaceAirConsuption;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    public double getTankPressure() {
        return tankPressure;
    }

    public void setTankPressure(double tankPressure) {
        this.tankPressure = tankPressure;
    }

    public double getAbsolutePressure() {
        return absolutePressure;
    }

    public void setAbsolutePressure(double absolutePressure) {
        this.absolutePressure = absolutePressure;
    }


    public double countTime(TimeUnderWater timeUnderWater){

        return (timeUnderWater.getTankPressure()*timeUnderWater.getTankVolume())/(timeUnderWater.getSurfaceAirConsuption()*timeUnderWater.getAbsolutePressure());

    }







}
