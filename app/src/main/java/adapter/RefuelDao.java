package adapter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RefuelDao {

    // Добавление Refuel2 в бд
    @Insert
    void insert(Refuel refuel);

    // Удаление Refuel2 из бд
    @Delete
    void delete(Refuel refuel);

    // Получение всех Refuel2 из бд
    @Query("SELECT * FROM Vehicle")
    List<Refuel> getAllRefuelList();

    // Получение всех Refuel2 из бд с условием
    @Query("SELECT * FROM Vehicle WHERE refuel_full_tank_flag LIKE :fullFlag")
    List<Refuel> getAllRefuelWithFullTankFlag(boolean fullFlag);

}