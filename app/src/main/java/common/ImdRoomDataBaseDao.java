/*
package common;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ImdRoomDataBaseDao {

    @Query("SELECT * FROM Vehicle")
    List<Vehicle> getAllVehiclesList();

    @Insert
    void insertVehicle(Vehicle vehicle);

    @Update
    void updateVehicle(Vehicle Vehicle);

    @Query("SELECT * FROM Vehicle WHERE vehicle_id = :id LIMIT 1")
    Vehicle getVehicleByID(int id);

    //удаление авто потом будет с удалением его заправок и сервисов

  */
/*  // Добавление Refuel2 в бд
    @Insert
    void insert(Refuel refuel);

    // Удаление Refuel2 из бд
    @Delete
    void delete(Refuel refuel);

    // Получение всех Refuel2 из бд
    @Query("SELECT * FROM Refuel")
    List<Refuel> getAllRefuelList();

    // Получение всех Refuel2 из бд с условием
    @Query("SELECT * FROM Refuel WHERE refuel_full_tank_flag LIKE :fullFlag")
    List<Refuel> getAllRefuelWithFullTankFlag(boolean fullFlag); *//*

}
*/
