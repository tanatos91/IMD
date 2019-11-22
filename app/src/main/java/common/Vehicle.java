/*
package common;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Vehicle {
    @PrimaryKey
    private int vehicle_id;
    private String vehicle_name = "";
    private String vehicle_vin = "";
    private int oil_reglament;    //km
    private long brake_fluid_reglament;    //date in millis
    private int fuel_filter_reglament_km;    //km
    private int air_filter_reglament;    //km
    private int salon_filter_reglament;    //km
    private int spark_plugs_reglament;    //km
    private int timing_belt_reglament;    //km
    private int strokes_reglament;    //km
    private int wheels_balancing_reglament;    //km
    private long antifreeze_change_reglament;    //date in millis

    public Vehicle(int vehicle_id,
                   String vehicle_name,
                   String vehicle_vin,
                   int oil_reglament,
                   long brake_fluid_reglament,
                   int fuel_filter_reglament_km,
                   int air_filter_reglament,
                   int salon_filter_reglament,
                   int spark_plugs_reglament,
                   int timing_belt_reglament,
                   int strokes_reglament,
                   int wheels_balancing_reglament,
                   int antifreeze_change_reglament) {
        setAir_filter_reglament(air_filter_reglament);
        setAntifreeze_change_reglament(antifreeze_change_reglament);
        setBrake_fluid_reglament(brake_fluid_reglament);
        setFuel_filter_reglament_km(fuel_filter_reglament_km);
        setOil_reglament(oil_reglament);
        setSalon_filter_reglament(salon_filter_reglament);
        setSpark_plugs_reglament(spark_plugs_reglament);
        setStrokes_reglament(strokes_reglament);
        setTiming_belt_reglament(timing_belt_reglament);
        setVehicle_id(vehicle_id);
        setVehicle_name(vehicle_name);
        setVehicle_vin(vehicle_vin);
        setWheels_balancing_reglament(wheels_balancing_reglament);

    }

    public void setReglamentsToMiddle() {
        oil_reglament = 10000;    //km	//10 000
        brake_fluid_reglament = 63072000000L;    //date in millis	//2 года
        fuel_filter_reglament_km = 30000;    //km	//30 000
        air_filter_reglament = 20000;    //km	//20 000
        salon_filter_reglament = 20000;    //km	//20 000
        spark_plugs_reglament = 40000;    //km	//40 000
        timing_belt_reglament = 60000;    //km	//60 000
        strokes_reglament = 45000;    //km //45 000
        wheels_balancing_reglament = 10000;    //km // 10 000
        antifreeze_change_reglament = 63072000000L;    //date in millis	//2 года
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_vin() {
        return vehicle_vin;
    }

    public void setVehicle_vin(String vehicle_vin) {
        this.vehicle_vin = vehicle_vin;
    }

    public int getOil_reglament() {
        return oil_reglament;
    }

    public void setOil_reglament(int oil_reglament) {
        this.oil_reglament = oil_reglament;
    }

    public long getBrake_fluid_reglament() {
        return brake_fluid_reglament;
    }

    public void setBrake_fluid_reglament(long brake_fluid_reglament) {
        this.brake_fluid_reglament = brake_fluid_reglament;
    }

    public int getFuel_filter_reglament_km() {
        return fuel_filter_reglament_km;
    }

    public void setFuel_filter_reglament_km(int fuel_filter_reglament_km) {
        this.fuel_filter_reglament_km = fuel_filter_reglament_km;
    }

    public int getAir_filter_reglament() {
        return air_filter_reglament;
    }

    public void setAir_filter_reglament(int air_filter_reglament) {
        this.air_filter_reglament = air_filter_reglament;
    }

    public int getSalon_filter_reglament() {
        return salon_filter_reglament;
    }

    public void setSalon_filter_reglament(int salon_filter_reglament) {
        this.salon_filter_reglament = salon_filter_reglament;
    }

    public int getSpark_plugs_reglament() {
        return spark_plugs_reglament;
    }

    public void setSpark_plugs_reglament(int spark_plugs_reglament) {
        this.spark_plugs_reglament = spark_plugs_reglament;
    }

    public int getTiming_belt_reglament() {
        return timing_belt_reglament;
    }

    public void setTiming_belt_reglament(int timing_belt_reglament) {
        this.timing_belt_reglament = timing_belt_reglament;
    }

    public int getStrokes_reglament() {
        return strokes_reglament;
    }

    public void setStrokes_reglament(int strokes_reglament) {
        this.strokes_reglament = strokes_reglament;
    }

    public int getWheels_balancing_reglament() {
        return wheels_balancing_reglament;
    }

    public void setWheels_balancing_reglament(int wheels_balancing_reglament) {
        this.wheels_balancing_reglament = wheels_balancing_reglament;
    }

    public long getAntifreeze_change_reglament() {
        return antifreeze_change_reglament;
    }

    public void setAntifreeze_change_reglament(long antifreeze_change_reglament) {
        this.antifreeze_change_reglament = antifreeze_change_reglament;
    }
}
*/
