package pl.divingplanner.model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Profile {

    private int depth;

    private int overalTime;

    private Map<Integer, String> depthStopTime = new TreeMap<>(Collections.reverseOrder());

    private int ascendTime;

    private int ascendSpeed;

    private int descendTime;

    private boolean counterBreak;

    public Profile() {

    }

    public Profile(int depth, int overalTime, Map<Integer, String> depthStopTime, boolean counterBreak) throws IOException, InvalidFormatException {
        super();
        this.depth = depth;
        this.overalTime = overalTime;
        this.depthStopTime = depthStopTime;
        this.counterBreak = counterBreak;
    }

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

    public boolean getCounterBreak() {
        return counterBreak;
    }

    public void setCounterBreak(boolean counterBreak) {
        this.counterBreak = counterBreak;
    }
}
