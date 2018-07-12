package pl.divingplanner.excelservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.divingplanner.model.Profile;

import java.util.Map;

@Component
public class DataColecting  {

    private ExcelReader reader;

    @Autowired
    public DataColecting(ExcelReader reader) {
        this.reader = reader;
    }

    public Map<Integer, String> getStopsByDeapth(Profile profile) {
        int rowIndexForProfile = reader.getRowIndex(profile);
        return reader.getDepthStopTime(rowIndexForProfile, profile);
    }
}
