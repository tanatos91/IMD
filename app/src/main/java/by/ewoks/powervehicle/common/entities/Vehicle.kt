package by.ewoks.powervehicle.common.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vehicle(
        @PrimaryKey val id: Long,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "vin") val vin: String,
        @ColumnInfo(name = "oil_reglament") val oilReglament: Int,
        @ColumnInfo(name = "brake_fluid_reglament_months") val brakeFluidReglamentMonths: Int,
        @ColumnInfo(name = "fuel_filter_reglament_km") val fuelFilterReglamentKm: Int,
        @ColumnInfo(name = "air_filter_reglament_km") val airFilterReglamentKm: Int,
        @ColumnInfo(name = "salon_filter_reglament_km") val salonFilterReglamentKm: Int,
        @ColumnInfo(name = "spark_plugs_reglament_km") val sparkPlugsReglamentKm: Int,
        @ColumnInfo(name = "timing_belt_km") val timingBeltKm: Int,
        @ColumnInfo(name = "strokes_reglament_km") val strokesReglamentKm: Int,
        @ColumnInfo(name = "wheels_balancing_reglament_km") val wheelsBalancingReglamentKm: Int,
        @ColumnInfo(name = "antifreeze_change_reglament_months") val antifreezeChangeReglamentMonths: Int
)