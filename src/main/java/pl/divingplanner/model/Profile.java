package pl.divingplanner.model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.divingplanner.excelservice.ExcelReader;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@Service
public class Profile {

    private int depth;

    private int overalTime;

    private Map<Integer, String> depthStopTime = new TreeMap<>(Collections.reverseOrder());

    private int ascendTime;

    private int ascendSpeed;

    private int descendTime;

    public int getAscendSpeed() {

        return ascendSpeed;
    }
    public int getDescendTime() {

        return descendTime;
    }

    public void setDescendTime(int descendTime) {
        this.descendTime = descendTime;
    }

    public void setAscendSpeed(int ascendSpeed) {
        this.ascendSpeed = ascendSpeed;
    }

    public int getAscendTime() {
        return ascendTime;
    }

    public void setAscendTime(int ascendTime) {
        this.ascendTime = ascendTime;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getOveralTime() {
        return overalTime;
    }

    public void setOveralTime(int overalTime) {
        this.overalTime = overalTime;
    }

    public Map<Integer, String> getDepthStopTime() {
        return depthStopTime;
    }

    public void setDepthStopTime(Map<Integer, String> depthStopTime) {
        this.depthStopTime = depthStopTime;
    }

    @Autowired
    public Profile() throws IOException, InvalidFormatException {
    }

    public Profile(int depth, int overalTime, Map<Integer, String> depthStopTime) throws IOException, InvalidFormatException {
        super();
        this.depth = depth;
        this.overalTime = overalTime;
        this.depthStopTime = depthStopTime;
    }
}
