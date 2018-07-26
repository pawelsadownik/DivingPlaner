package pl.divingplanner.excelservice;

import org.springframework.stereotype.Service;
import pl.divingplanner.controller.EmailService;
import pl.divingplanner.model.DivingProces;
import pl.divingplanner.model.Email;
import pl.divingplanner.model.Profile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pl.divingplanner.controller.WelcomeController;

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
    private EmailService emailService;
    private Email email;

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
            if (counter < 0) {
                break;
            }
        }

        profile.setAscendTime(Integer.valueOf(stops.get(2)));

        List<Integer> keyList = new ArrayList(profile.getDepthStopTime().keySet());


        profile.setAscendSpeed((profile.getDepth() - keyList.get(0)) / profile.getAscendTime());

        profile.setDescendTime(1);

        DivingProces divingProces = new DivingProces();

        //Ustawienie listy glebokosci

        divingProces.getDepthStopsList().add(0);
        divingProces.getDepthStopsList().add(profile.getDepth());
        divingProces.getDepthStopsList().add(profile.getDepth());
        divingProces.getDepthStopsList().add(keyList.get(0));
        divingProces.getDepthStopsList().addAll(keyList);

        //Ustawienie listy czasu
        List<String> listStrings = new ArrayList<>(profile.getDepthStopTime().values());
        List<String> tempList = new ArrayList<>();


        for (int i = 0; i < listStrings.size(); i++) {
            String[] output = listStrings.get(i).split("\\(");
            tempList.add(output[0]);
        }

        List<Integer> listTimes = new ArrayList<Integer>(listStrings.size());



        divingProces.setWorkingTime(profile.getOveralTime()-profile.getDescendTime());

        listTimes.add(0);
        listTimes.add(profile.getDescendTime());
        listTimes.add(divingProces.getWorkingTime());
        listTimes.add(profile.getAscendTime());


        for (String current : tempList) {
            listTimes.add(Integer.parseInt(current));
        }
        divingProces.getDepthStopsList().add(0);
        listTimes.add(3);

        divingProces.setTimeStopsList(listTimes);

       // email.setAddress("pawel.sadownik@wp.pl");
       // email.setContent("content");
        //email.setTitle("title");

        //emailService.send(email.getAddress(), email.getTitle(), email.getContent());

        return profile.getDepthStopTime();
    }


}