package pl.divingplanner.controller;

import pl.divingplanner.model.DivingPlan;

import java.util.List;

public class DivingPlanWrapper {

    private List<DivingPlan> divingPlanList;

    public DivingPlanWrapper() {
    }

    public DivingPlanWrapper(List<DivingPlan> divingPlanList) {
        this.divingPlanList = divingPlanList;
    }

    public List<DivingPlan> getDivingPlanList() {
        return divingPlanList;
    }

    public void setDivingPlanList(List<DivingPlan> divingPlanList) {
        this.divingPlanList = divingPlanList;
    }
}
