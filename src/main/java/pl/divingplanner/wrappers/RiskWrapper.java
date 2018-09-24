package pl.divingplanner.wrappers;

import pl.divingplanner.model.Risk;

import java.util.ArrayList;
import java.util.List;

public class RiskWrapper {


    private List<Risk> riskList;

    public RiskWrapper() {
    }

    public RiskWrapper(List<Risk> riskList) {
        this.riskList = riskList;
    }

    public List<Risk> getRiskList() {

        return riskList;
    }

    public void setRiskList(List<Risk> riskList) {
        this.riskList = riskList;
    }




}
