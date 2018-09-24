package pl.divingplanner.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Component
public class DivingProces {


    @Autowired
    public DivingProces() {
    }

    private int workingTime;

    public static List<Integer> timeStopsList = new ArrayList<>();

    public static List<Integer> depthStopsList = new ArrayList<>();

    public static List<Integer> timeStopsListBreak = new ArrayList();
    public static List<Integer> depthStopsListBreak = new ArrayList<>();


    public int getWorkingTime() {

        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public List<Integer> getTimeStopsList() {

        return timeStopsList;
    }

    public void setTimeStopsList(List<Integer> timeStopsList) {
        this.timeStopsList = timeStopsList;
    }

    public List<Integer> getDepthStopsList() {
        return depthStopsList;
    }

    public void setDepthStopsList(List<Integer> depthStopsList) {
        this.depthStopsList = depthStopsList;
    }

    public static List<Integer> getTimeStopsListBreak() {
        return timeStopsListBreak;
    }

    public static void setTimeStopsListBreak(List<Integer> timeStopsListBreak) {
        DivingProces.timeStopsListBreak = timeStopsListBreak;
    }

    public static List<Integer> getDepthStopsListBreak() {
        return depthStopsListBreak;
    }

    public static void setDepthStopsListBreak(List<Integer> depthStopsListBreak) {
        DivingProces.depthStopsListBreak = depthStopsListBreak;
    }
}
