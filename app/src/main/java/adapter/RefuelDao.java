package adapter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RefuelDao {

    // Добавление Refuel в бд
    @Insert
    void insert(Refuel refuel);

    // Удаление Refuel из бд
    @Delete
    void delete(Refuel refuel);

    // Получение всех Refuel из бд
    @Query("SELECT * FROM Refuel")
    List<Refuel> getAllRefuelList();

    // Получение всех Refuel из бд с условием
    @Query("SELECT * FROM Refuel WHERE refuel_full_tank_flag LIKE :fullFlag")
    List<Refuel> getAllRefuelWithFullTankFlag(boolean fullFlag);

}