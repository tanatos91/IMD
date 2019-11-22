package by.ewoks.powervehicle.common.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ewoks.powervehicle.common.entities.Hint

@Dao
interface HintDao {

    @Insert
    fun insertHint(hint: Hint)

    @Query("SELECT * FROM Hint")
    fun getAllHints(): LiveData<Hint>
}