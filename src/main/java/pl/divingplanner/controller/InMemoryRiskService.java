package pl.divingplanner.controller;

import org.springframework.stereotype.Service;
import pl.divingplanner.model.Risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class InMemoryRiskService implements RiskService {

    static Map<Long, Risk> risksDB = new HashMap<>();

    @Override
    public List<Risk> findAll() {
        return new ArrayList<>(risksDB.values());
    }

    @Override
    public void saveAll(List<Risk> riskList) {
        long nextId = getNextId();
        for (Risk risk : riskList) {
            if (risk.getId() == 0) {
                risk.setId(nextId++);
            }
        }

        Map<Long, Risk> riskMap = riskList.stream()
                .collect(Collectors.toMap(Risk::getId, Function.identity()));

        risksDB.putAll(riskMap);
    }

    private Long getNextId() {
        return risksDB.keySet()
                .stream()
                .mapToLong(value -> value)
                .max()
                .orElse(0) + 1;
    }
}

