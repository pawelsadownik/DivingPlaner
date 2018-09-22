package pl.divingplanner.calculations;

import org.junit.Test;
import pl.divingplanner.excelservice.ExcelReader;
import pl.divingplanner.model.Profile;

import static org.junit.Assert.*;

public class GasAmountTest {

    @Test
    public void countGasAmount() {

        //given
        GasAmount gasAmount = new GasAmount();
        gasAmount.setPressure(200);
        gasAmount.setTankVolume(15);

        //when
        double result = gasAmount.countGasAmount(gasAmount);

        //then
        assertTrue(result == 3000);



    }
}