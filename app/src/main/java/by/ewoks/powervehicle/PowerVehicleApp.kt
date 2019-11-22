package by.ewoks.powervehicle

import android.app.Application
import by.ewoks.powervehicle.common.AppDbManager

class PowerVehicleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDbManager.initDb(this)
    }
}