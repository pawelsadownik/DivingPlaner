package ExcelService;

import Model.Profile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class ExcelReader {

    public static final String SAMPLE_XLSX_FILE_PATH = "./src/main/resources/TabeleDeko.xlsx";

    public int getRowIndex(Profile profile) throws IOException, InvalidFormatException {


        //Profile profile = new Profile();

        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        int rowIndex = 0;

        profile.getDepth();
        profile.getOveralTime();

        for (Row row : sheet) {

            String firstColumnValue = dataFormatter.formatCellValue(row.getCell(0));

            if (Integer.valueOf(firstColumnValue) >= profile.getDepth()) {

                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);

                    if (rowIndex != 0 || cell.getColumnIndex()>1)
                        break;

                    if (cell.getColumnIndex() == 1 && profile.getOveralTime() <= Integer.valueOf(cellValue)) {

                        rowIndex = cell.getRowIndex();
                        break;
                    }
                }
            }
        }

        return rowIndex;
    }

}