package pl.divingplanner.controller;

import pl.divingplanner.model.Risk;

import java.util.ArrayList;
import java.util.List;

public class RiskCreationDto {


    private List<Risk> riskList;

    public RiskCreationDto() {
        this.riskList = new ArrayList<>();
    }

    public RiskCreationDto(List<Risk> riskList) {
        this.riskList = riskList;
    }

    public List<Risk> getRiskList() {
        return riskList;
    }

    public void setRiskList(List<Risk> riskList) {
        this.riskList = riskList;
    }

    public void addRisk(Risk risk) {
        this.riskList.add(risk);
    }


}
