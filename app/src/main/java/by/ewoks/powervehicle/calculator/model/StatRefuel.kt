package by.ewoks.powervehicle.calculator.model

import by.ewoks.powervehicle.common.entities.Refuel


data class StatRefuel(
        val refuel: Refuel,
        val incrementMileage: Int?,
        val incrementMoney: Double,
        val currentConsumption: Double?
)