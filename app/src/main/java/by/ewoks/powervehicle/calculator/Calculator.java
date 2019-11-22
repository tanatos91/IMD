package by.ewoks.powervehicle.calculator;

import java.util.ArrayList;
import java.util.List;

import by.ewoks.powervehicle.calculator.model.StatRefuel;
import by.ewoks.powervehicle.common.entities.Refuel;

public abstract class Calculator {
    public static List<StatRefuel> makeStatRefuelList(List<Refuel> refuelList) {
        if (refuelList == null) return null;
        if (refuelList.size() == 0) return null;
        List<StatRefuel> statRefuelList = new ArrayList<>();
        statRefuelList.add(new StatRefuel(
                refuelList.get(0),
                null,
                refuelList.get(0).getFuelPrice() * refuelList.get(0).getFuelVolume(),
                null));
        if (refuelList.size() > 1)
            for (int i = 1; i < refuelList.size(); i++) {
                Refuel currentRefuel = refuelList.get(i);
                Refuel previousRefuel = refuelList.get(i - 1);
                int incrementMileage = currentRefuel.getMileage() - previousRefuel.getMileage();
                double incrementMoney = currentRefuel.getFuelPrice() * currentRefuel.getFuelVolume();
                if (currentRefuel.getFullTankFlag() && previousRefuel.getFullTankFlag()) {
                    double currentConsumption = currentRefuel.getFuelVolume() * 100.0 / incrementMileage;
                    statRefuelList.add(new StatRefuel(currentRefuel, incrementMileage, incrementMoney, currentConsumption));
                } else {
                    statRefuelList.add(new StatRefuel(currentRefuel, incrementMileage, incrementMoney, null));
                }
            }
        return statRefuelList;
    }
}
