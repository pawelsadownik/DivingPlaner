package ExcelService;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;

public class DataColecting {
    ExcelReader reader  = new ExcelReader();

    void collectData() throws IOException, InvalidFormatException {

        Row rowStops = reader.sheet.getRow(reader.getRowIndex());

        for (Cell cell : rowStops) {

            String cellValue = dataFormatter.formatCellValue(cell);


            stops.add(cellValue);

            if (cellValue != "" && cell.getColumnIndex() > 3) {
                profile.getDepthStopTime().put(counter, cellValue);
            }
            counter -= 3;
        }
    }

}
