package adapter;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.GregorianCalendar;
import java.util.List;

@Entity
public class Refuel {

    @PrimaryKey
    @ColumnInfo(name = "refuel_date")
    @TypeConverters({GregorianCalendarConverter.class})
    private GregorianCalendar refuelDate;

    @ColumnInfo(name = "refuel_volume")
    private double refuelVolume;

    @ColumnInfo(name = "refuel_mileage")
    private int refuelMileage;

    @ColumnInfo(name = "refuel_fuel_price")
    private double refuelFuelPrice;

    @ColumnInfo(name = "refuel_full_tank_flag")
    private boolean fullTankFlag;

    public static final boolean FULL_TANK = true;
    public static final boolean NOT_FULL_TANK = false;


    public Refuel(GregorianCalendar refuelDate, int refuelMileage, double refuelVolume, double refuelFuelPrice, boolean fullTankFlag) {
        setRefuelDate(refuelDate);
        setRefuelMileage(refuelMileage);
        setRefuelVolume(refuelVolume);
        setRefuelFuelPrice(refuelFuelPrice);
        setFullTankFlag(fullTankFlag);
    }

    public static class GregorianCalendarConverter {

        @TypeConverter
        public long fromGregorianCalendar(GregorianCalendar refuelDate) {
            return refuelDate.getTimeInMillis();
        }

        @TypeConverter
        public GregorianCalendar toGregorianCalendar(long longTime) {
            GregorianCalendar gregCal = new GregorianCalendar();
            gregCal.setTimeInMillis(longTime);
            return gregCal;
        }

    }



    private void setFullTankFlag(boolean fullTankFlag) {
        this.fullTankFlag = fullTankFlag;
    }

    public boolean getFullTankFlag() {
        return fullTankFlag;
    }


    private void setRefuelDate(GregorianCalendar date) {
        this.refuelDate = date;
    }

    public GregorianCalendar getRefuelDate() {
        return refuelDate;
    }

    private void setRefuelVolume(double vol) {
        this.refuelVolume = vol;
    }

    public double getRefuelVolume() {
        return refuelVolume;
    }

    private void setRefuelMileage(int mileage) {
        this.refuelMileage = mileage;
    }

    public int getRefuelMileage() {
        return refuelMileage;
    }

    private void setRefuelFuelPrice(double price) {
        this.refuelFuelPrice = price;
    }

    public double getRefuelFuelPrice() {
        return refuelFuelPrice;
    }


}


