package adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Refuel {
    private GregorianCalendar refuelDate;
    private double refuelVolume;
    private int refuelMileage;
    private double refuelFuelPrice;
    private boolean fullTankFlag;
    public static final boolean FULL_TANK = true;
    public static final boolean NOT_FULL_TANK = false;


    public void setFullTankFlag(boolean fullTankFlag){this.fullTankFlag = fullTankFlag;}
    public boolean getFullTankFlag(){return fullTankFlag;}


    public void setRefuelDate(GregorianCalendar date){refuelDate = date;}
    public GregorianCalendar getRefuelDate(){return refuelDate;}

    public void setRefuelVolume(double vol){refuelVolume = vol;}
    public double getRefuelVolume(){return refuelVolume;}

    public void setRefuelMileage(int mileage){refuelMileage = mileage;}
    public int getRefuelMileage(){return refuelMileage;}

    public void setRefuelFuelPrice(double price){refuelFuelPrice = price;}
    public double getRefuelFuelPrice(){return refuelFuelPrice;}

    public String getRefuelDateString(){
        String dateString = refuelDate.get(Calendar.DAY_OF_MONTH) + "." + refuelDate.get(Calendar.MONTH) + "." + refuelDate.get(Calendar.YEAR);
        return dateString;

    }

    public String getFullTankFlagString(){
        if(this.getFullTankFlag()){
            return "Full tank";
        }
        else{
            return "Not full tank";
        }
    }

    public Refuel(GregorianCalendar date, int mileage, double vol, double price, boolean fullTankFlag){
        setRefuelDate(date);
        setRefuelMileage(mileage);
        setRefuelVolume(vol);
        setRefuelFuelPrice(price);
        setFullTankFlag(fullTankFlag);
    }

}
