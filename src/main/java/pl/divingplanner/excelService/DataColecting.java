package pl.divingplanner.excelService;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.divingplanner.model.Profile;

import java.io.IOException;
import java.util.Map;

@Component
public class DataColecting  {

    private ExcelReader reader;

    @Autowired
    public DataColecting(ExcelReader reader) {
        this.reader = reader;
    }

    public Map<Integer, String> getStopsByDeapth(Profile profile) throws IOException, InvalidFormatException {
        int rowIndexForProfile = reader.getRowIndex(profile);


        return reader.getDepthStopTime(rowIndexForProfile, profile);
    }
}
