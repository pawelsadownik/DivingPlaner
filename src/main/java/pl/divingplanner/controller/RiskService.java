package pl.divingplanner.controller;
import pl.divingplanner.model.Risk;

import java.util.List;

public interface RiskService {

    List<Risk> findAll();

    void saveAll(List<Risk> riskList);
}