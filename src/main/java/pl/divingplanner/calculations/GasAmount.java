package pl.divingplanner.calculations;

public class GasAmount {

    private double tankVolume;
    private double pressure;
    private double amountOfGas;

    public GasAmount(double tankVolume, double pressure, double amountOfGas) {
        this.tankVolume = tankVolume;
        this.pressure = pressure;
        this.amountOfGas = amountOfGas;
    }

    public GasAmount() {

    }

    public double getAmountOfGas() {

        return amountOfGas;
    }

    public void setAmountOfGas(double amountOfGas) {
        this.amountOfGas = amountOfGas;
    }


    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }



    public double countGasAmount(GasAmount gasAmount){

        return gasAmount.getTankVolume()*gasAmount.getPressure();
    }

}
