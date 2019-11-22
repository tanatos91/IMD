package by.ewoks.powervehicle.common.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ewoks.powervehicle.common.entities.Refuel

@Dao
interface RefuelDao {

    @Insert
    fun insertRefuel(refuel: Refuel)

    @Query("SELECT * FROM Refuel")
    fun getAllRefuels(): LiveData<Refuel>
}