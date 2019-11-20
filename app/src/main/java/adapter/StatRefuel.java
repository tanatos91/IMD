package adapter;

import java.util.ArrayList;

public class StatRefuel extends Refuel {
    private int incMileage = 0;
    private double refuelSumPrice = 0;
    private boolean consumptionEnable = false;
    private boolean incMileageEnable = false;
    private double consumption = 0;

    /*private StatRefuel(GregorianCalendar refuelDate, int refuelMileage, double refuelVolume, double refuelFuelPrice, boolean fullTankFlag) {
        super(refuelDate, refuelMileage, refuelVolume, refuelFuelPrice, fullTankFlag);
        setStat();
    }*/

    private StatRefuel(Refuel refuel) {
        super(refuel.getRefuelDate(), refuel.getRefuelMileage(), refuel.getRefuelVolume(), refuel.getRefuelFuelPrice(), refuel.getFullTankFlag());
        setStat();
    }

    private StatRefuel(Refuel refuel, StatRefuel previousStatRefuel) {
        super(refuel.getRefuelDate(), refuel.getRefuelMileage(), refuel.getRefuelVolume(), refuel.getRefuelFuelPrice(), refuel.getFullTankFlag());
        setStat(previousStatRefuel);
    }

    private void setStat(StatRefuel previousStatRefuel) {
        setIncMileage(getRefuelMileage() - previousStatRefuel.getRefuelMileage());
        setRefuelSumPrice(getRefuelFuelPrice() * getRefuelVolume());
        incMileageEnable = true;
        setConsumptionEnable(getFullTankFlag() && previousStatRefuel.getFullTankFlag() && (incMileage != 0));
        if (consumptionEnable) {
            setConsumption(getRefuelVolume() * 100.00 / getIncMileage());
        }
    }

    private void setStat() {
        setRefuelSumPrice(getRefuelFuelPrice() * getRefuelVolume());
        setConsumptionEnable(false);
    }

    public static ArrayList<StatRefuel> makeStatRefuelArrayListFrom(ArrayList<Refuel> refuelArrayList) {
        ArrayList<StatRefuel> statRefuelArrayList = new ArrayList<>();
        if (refuelArrayList.size() > 0) {
            statRefuelArrayList.add(new StatRefuel(refuelArrayList.get(0)));
            for (int i = 1; i < refuelArrayList.size(); i++)
                statRefuelArrayList.add(new StatRefuel(refuelArrayList.get(i), statRefuelArrayList.get(i - 1)));
        }
        return statRefuelArrayList;
    }

   /* private int findPrevFullPosFrom(ArrayList<StatRefuel> statRefuelArrayList, int startPosition){
        for (int i = startPosition; i>0; i--)

    }*/


    public int getIncMileage() {
        return incMileage;
    }


    private void setIncMileage(int incMileage) {
        this.incMileage = incMileage;
    }


    public double getRefuelSumPrice() {
        return refuelSumPrice;
    }

    private void setRefuelSumPrice(double refuelSumPrice) {
        this.refuelSumPrice = refuelSumPrice;
    }

    public boolean isConsumptionEnable() {
        return consumptionEnable;
    }

    private void setConsumptionEnable(boolean consumptionEnable) {
        this.consumptionEnable = consumptionEnable;
    }

    public double getConsumption() {
        return consumption;
    }

    private void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public boolean isIncMileageEnable() {
        return incMileageEnable;
    }
}
