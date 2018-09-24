package pl.divingplanner.excelService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.divingplanner.application.DivingPlanerApplication;
import pl.divingplanner.model.Profile;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DivingPlanerApplication.class)
public class ExcelReaderTestSpringBoot {


    @Autowired
    private ExcelReader excelReader;

    @Autowired
    private Profile profile;

    @Test
    public void testFindRowIndex() {
        //given

        //when
        profile.setDepth(16);
        profile.setOveralTime(180);

        int result = excelReader.getRowIndex(profile);

        //then
        assertEquals(11, result);
    }


}
