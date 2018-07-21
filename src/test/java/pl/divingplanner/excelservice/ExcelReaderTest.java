package pl.divingplanner.excelservice;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pl.divingplanner.model.Profile;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class ExcelReaderTest {

     @Test
     public void testExcelReader() throws IOException, InvalidFormatException {
          //given
          Profile profile = new Profile();
          ExcelReader excelReader = new ExcelReader("./src/main/resources/TabeleDeko.xlsx");

          //when
          profile.setDepth(16);
          profile.setOveralTime(180);
          int result = excelReader.getRowIndex(profile);

          //then
          assertEquals(11, result);
     }

}