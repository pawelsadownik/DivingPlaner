package ExcelService;

import Model.Profile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataColecting  {

    public static final String SAMPLE_XLSX_FILE_PATH = "./src/main/resources/TabeleDeko.xlsx";

    public Map<Integer, String> getStopsByDeapth() throws IOException, InvalidFormatException {

        ExcelReader reader = new ExcelReader();

        Profile profile = new Profile();

        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        List<String> stops = new ArrayList<>();

        Row rowStops = sheet.getRow(reader.getRowIndex());

        int counter = 51;

        for (Cell cell : rowStops) {

            String cellValue = dataFormatter.formatCellValue(cell);


            stops.add(cellValue);

            if (cellValue != "" && cell.getColumnIndex() > 3) {
                profile.getDepthStopTime().put(counter, cellValue);
            }
            counter -= 3;
        }

        return profile.getDepthStopTime();
    }

}
