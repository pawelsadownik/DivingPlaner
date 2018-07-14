package pl.divingplanner.excelservice;

import org.springframework.stereotype.Service;
import pl.divingplanner.model.Profile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class ExcelReader {

    public static final int COUNTER = 51;

    private Workbook workbook;
    private Sheet sheet;
    List<String> stops = new ArrayList<>();

    @Autowired
    public ExcelReader(@Value("${xlsx.file}") String sampleXlsxFile) throws IOException, InvalidFormatException {
        workbook = WorkbookFactory.create(new File(sampleXlsxFile));
        sheet = workbook.getSheetAt(0);
    }

    public int getRowIndex(Profile profile) {

        DataFormatter dataFormatter = new DataFormatter();

        int rowIndex = 0;

        profile.getDepth();

        profile.getOveralTime();

        for (Row row : sheet) {

            String firstColumnValue = dataFormatter.formatCellValue(row.getCell(0));

            if (Integer.valueOf(firstColumnValue) >= profile.getDepth()) {

                for (Cell cell : row) {
                    String cellValue = dataFormatter.formatCellValue(cell);

                    if (rowIndex != 0 || cell.getColumnIndex() > 1)
                        break;

                    if (cell.getColumnIndex() == 1 && profile.getOveralTime() <= Integer.valueOf(cellValue)) {
//return rowIndex
                        rowIndex = cell.getRowIndex();
                        break;
                    }
                }
            }
        }

        return rowIndex;
    }

    public Map<Integer, String> getDepthStopTime(int rowIndexForProfile, Profile profile) throws IOException, InvalidFormatException {

        DataFormatter dataFormatter = new DataFormatter();


        Row rowStops = sheet.getRow(rowIndexForProfile);

        int counter = COUNTER;

        for (Cell cell : rowStops) {
            String cellValue = dataFormatter.formatCellValue(cell);
            stops.add(cellValue);
            if (cellValue != "" && cell.getColumnIndex() > 3) {
                profile.getDepthStopTime().put(counter, cellValue);
            }
            counter -= 3;
            if (counter<0){
                break;
            }
        }

        profile.setAscendTime(Integer.valueOf(stops.get(2)));

        List<Integer> keyList = new ArrayList(profile.getDepthStopTime().keySet());

       profile.setAscendSpeed((profile.getDepth()-keyList.get(0))/profile.getAscendTime());


        return profile.getDepthStopTime();
    }

}