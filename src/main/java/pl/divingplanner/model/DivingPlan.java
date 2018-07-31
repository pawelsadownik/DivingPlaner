package pl.divingplanner.model;

import java.util.LinkedList;
import java.util.List;

public class DivingPlan {

    private List<String> divingType = new LinkedList<>();
    private List<String> purpose = new LinkedList<>();
    private List<String> risk = new LinkedList<>();
    private List<String> security = new LinkedList<>();
    private List<String> procedure = new LinkedList<>();
    private List<String> equipment = new LinkedList<>();
    private List<String> team= new LinkedList<>();
    private List<String> commands = new LinkedList<>();
    private List<String> communication = new LinkedList<>();
    private List<String> asecuration = new LinkedList<>();
    private List<String> accident = new LinkedList<>();
    private List<String> weatherConditions = new LinkedList<>();
    private List<String> evacuation = new LinkedList<>();
    private List<String> medic = new LinkedList<>();


    public List<String> getDivingType() {
        return divingType;
    }

    public void setDivingType(List<String> type) {
        this.divingType = type;
    }

    public List<String> getPurpose() {
        return purpose;
    }

    public void setPurpose(List<String> purpose) {
        this.purpose = purpose;
    }

    public List<String> getRisk() {
        return risk;
    }

    public void setRisk(List<String> risk) {
        this.risk = risk;
    }

    public List<String> getSecurity() {
        return security;
    }

    public void setSecurity(List<String> security) {
        this.security = security;
    }

    public List<String> getProcedure() {
        return procedure;
    }

    public void setProcedure(List<String> procedure) {
        this.procedure = procedure;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public List<String> getTeam() {
        return team;
    }

    public void setTeam(List<String> team) {
        this.team = team;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public List<String> getCommunication() {
        return communication;
    }

    public void setCommunication(List<String> communication) {
        this.communication = communication;
    }

    public List<String> getAsecuration() {
        return asecuration;
    }

    public void setAsecuration(List<String> asecuration) {
        this.asecuration = asecuration;
    }

    public List<String> getAccident() {
        return accident;
    }

    public void setAccident(List<String> accident) {
        this.accident = accident;
    }

    public List<String> getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(List<String> weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public List<String> getEvacuation() {
        return evacuation;
    }

    public void setEvacuation(List<String> evacuation) {
        this.evacuation = evacuation;
    }

    public List<String> getMedic() {
        return medic;
    }

    public void setMedic(List<String> medic) {
        this.medic = medic;
    }
}
