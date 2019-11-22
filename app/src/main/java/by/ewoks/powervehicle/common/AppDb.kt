package by.ewoks.powervehicle.common

import androidx.room.Database
import androidx.room.RoomDatabase
import by.ewoks.powervehicle.common.dao.*
import by.ewoks.powervehicle.common.entities.*

@Database(
        entities = [
            Vehicle::class, Refuel::class,
            Service::class, ServiceType::class,
            Hint::class],
        version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao

    abstract fun refuelDao(): RefuelDao

    abstract fun serviceDao(): ServiceDao

    abstract fun serviceTypeDao(): ServiceTypeDao

    abstract fun hintDao(): HintDao
}