package by.ewoks.powervehicle.common

import android.content.Context
import androidx.room.Room

object AppDbManager {

    private lateinit var appDb: AppDb

    fun initDb(appContext: Context) {
        appDb = Room
                .databaseBuilder(
                        appContext,
                        AppDb::class.java,
                        "PowerVehicleDb")
                .build()
    }

    fun getDb() = appDb
}