/*
package common;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RefuelN {

    @PrimaryKey
    private long refuel_date;
    private int refuel_mileage;
    private int vehicle_id;
    private int fuel_type;
    private double refuel_volume;
    private double refuel_fuel_price;
    private boolean full_tank_flag;

    public static final boolean FULL_TANK = true;
    public static final boolean NOT_FULL_TANK = false;


    public RefuelN(
            long refuelDate,
            int fuelType,
            int vehicleID,
            int refuelMileage,
            double refuelVolume,
            double refuelFuelPrice,
            boolean fullTankFlag) {
        setRefuel_date(refuelDate);
        setRefuel_mileage(refuelMileage);
        setRefuel_volume(refuelVolume);
        setRefuel_fuel_price(refuelFuelPrice);
        setFull_tank_flag(fullTankFlag);
        setVehicle_id(vehicleID);
        setFuel_type(fuelType);
    }


    private void setFull_tank_flag(boolean full_tank_flag) {
        this.full_tank_flag = full_tank_flag;
    }

    public boolean getFull_tank_flag() {
        return full_tank_flag;
    }


    private void setRefuel_date(long date) {
        this.refuel_date = date;
    }

    public long getRefuel_date() {
        return refuel_date;
    }

    private void setRefuel_volume(double vol) {
        this.refuel_volume = vol;
    }

    public double getRefuel_volume() {
        return refuel_volume;
    }

    private void setRefuel_mileage(int mileage) {
        this.refuel_mileage = mileage;
    }

    public int getRefuel_mileage() {
        return refuel_mileage;
    }

    private void setRefuel_fuel_price(double price) {
        this.refuel_fuel_price = price;
    }

    public double getRefuel_fuel_price() {
        return refuel_fuel_price;
    }


    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(int fuel_type) {
        this.fuel_type = fuel_type;
    }
}


*/
