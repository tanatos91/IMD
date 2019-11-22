package by.ewoks.powervehicle.common.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ewoks.powervehicle.common.entities.Service

@Dao
interface ServiceDao {

    @Insert
    fun insertService(service: Service)

    @Query("SELECT * FROM Service")
    fun getAllServices(): LiveData<Service>
}