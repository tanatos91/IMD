package by.ewoks.powervehicle.common.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Refuel(
        @PrimaryKey val id: Long,
        val date: Long,
        @ColumnInfo(name = "vehicle_id") val vehicleId: Long,
        @ColumnInfo(name = "fuel_volume") val fuelVolume: Double,
        @ColumnInfo(name = "mileage") val mileage: Int,
        @ColumnInfo(name = "fuel_price") val fuelPrice: Double,
        @ColumnInfo(name = "full_tank_flag") val fullTankFlag: Boolean
)