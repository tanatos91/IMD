package by.ewoks.powervehicle.common.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Service(
        @PrimaryKey val id: Long,
        @ColumnInfo(name = "vehicle_id") val vehicleId: Long,
        @ColumnInfo(name = "service_type_id") val serviceTypeId: Long,
        @ColumnInfo(name = "date") val date: Long,
        @ColumnInfo(name = "date_of_next_service") val dateOfNextService: Long,
        @ColumnInfo(name = "mileage") val mileage: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "service_cost") val serviceCost: Double
)