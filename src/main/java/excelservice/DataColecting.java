package excelservice;

import Model.Profile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;



import java.io.IOException;
import java.util.Map;

@Configuration
@Component
@PropertySource("classpath:application.properties")
public class DataColecting  {

    @Value("xlsx.file")
    private String sampleXlsxFile;

    //PROBA Z ENVIRONMENT
    /*
    @Autowired
    private Environment env;

    String sampleXlsxFile = env.getProperty("xlsx.file");
   */

    //private String sampleXlsxFile= "./src/main/resources/TabeleDeko.xlsx";

    private ExcelReader reader;


    @Autowired
    public DataColecting() throws IOException, InvalidFormatException {
        reader = new ExcelReader(sampleXlsxFile);
    }


    public Map<Integer, String> getStopsByDeapth(Profile profile) {
        int rowIndexForProfile = reader.getRowIndex(profile);
        return reader.getDepthStopTime(rowIndexForProfile, profile);
    }
}
