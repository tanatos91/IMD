package by.ewoks.powervehicle.common.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ewoks.powervehicle.common.entities.Vehicle

@Dao
interface VehicleDao {

    @Insert
    fun insertVehicle(vehicle: Vehicle)

    @Query("SELECT * FROM Vehicle")
    fun getAllVehicles(vehicleId: Long): LiveData<Vehicle>
}