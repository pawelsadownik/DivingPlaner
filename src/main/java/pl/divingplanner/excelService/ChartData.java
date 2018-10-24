package pl.divingplanner.excelService;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pl.divingplanner.model.DivingProces;
import pl.divingplanner.model.Profile;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ChartData {

    DivingProces divingProces = new DivingProces();
    DataColecting dataColecting = new DataColecting();
    Profile profile = new Profile();

        public void setTime() throws IOException, InvalidFormatException {
            divingProces.depthStopsList.clear();
            divingProces.timeStopsList.clear();
            divingProces.depthStopsListBreak.clear();
            divingProces.timeStopsListBreak.clear();

            dataColecting.getStopsByDeapth(profile);

            List<Integer> time = new LinkedList<>();
            int sum = 0;
            for (int i = 0; i < divingProces.getTimeStopsList().size(); i++) {
                sum = sum + divingProces.getTimeStopsList().get(i);
                time.add(sum);
            }
        }

    List<Integer> depth = new LinkedList<>(divingProces.getDepthStopsList());
    List<Integer> timeBreak = new LinkedList<>(divingProces.getTimeStopsListBreak());
    List<Integer> depthBreak = new LinkedList<>(divingProces.getDepthStopsListBreak());
}
