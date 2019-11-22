package by.ewoks.powervehicle.common.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ServiceType(
        @PrimaryKey val id: Long,
        @ColumnInfo(name = "name") val name: String
)