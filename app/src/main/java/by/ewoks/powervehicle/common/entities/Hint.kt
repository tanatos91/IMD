package by.ewoks.powervehicle.common.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hint(
        @PrimaryKey val id: Long,
        @ColumnInfo(name = "service_id") val serviceId: Long,
        @ColumnInfo(name = "header_text") val headerText: String,
        @ColumnInfo(name = "body_text") val bodyText: String,
        @ColumnInfo(name = "hint_url") val hintUrl: String,
        @ColumnInfo(name = "condition_mileage") val conditionMileage: Int
)