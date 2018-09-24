package pl.divingplanner.excelService;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.divingplanner.application.DivingPlanerApplication;
import pl.divingplanner.model.Profile;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DivingPlanerApplication.class)
public class ExcelReaderIntegrationTest {

    @Autowired
    DataColecting dataColecting;

    @Autowired
    Profile profile;

    @Test
    public void integrationTest() throws IOException, InvalidFormatException {
        //given
        profile.setDepth(20);
        profile.setOveralTime(45);

        //when
        Map<Integer, String> result =  dataColecting.getStopsByDeapth(profile);
        int time = profile.getAscendTime();

        //then
        //assertEquals("{3=5(3)}", result.toString());
        assertThat(result, IsMapContaining.hasEntry(3, "5(3)"));



    }


}
