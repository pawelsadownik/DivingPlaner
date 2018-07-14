package pl.divingplanner.model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ascend {

    void getAscendTime() throws IOException, InvalidFormatException {

        Profile profile = new Profile();

        int ascendTime = profile.getAscendTime();

        List <Integer> ascendDepths = new ArrayList<>();

        for (int i=1; i<ascendTime*2;i++){




        }



    }
}