package Model;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;



public class Profile {



    private int depth;

    private int overalTime;

    private Map<Integer, String> depthStopTime = new TreeMap<>(Collections.reverseOrder());

    private int ascendTime;

    private int ascendSpeed;

    public int getAscendSpeed() {

        ascendSpeed = getDepth()/getOveralTime();

        return ascendSpeed;
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

    public Profile() {
    }

    public Profile(int depth, int overalTime, Map<Integer, String> depthStopTime) {
        super();
        this.depth = depth;
        this.overalTime = overalTime;
        this.depthStopTime = depthStopTime;
    }
}
