package common;

import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = { RefuelN.class, Vehicle.class, VehicleService.class, Hint.class }, version = 1, exportSchema = false)
public abstract class ImdRoomDataBase extends Room {

    public abstract ImdRoomDataBaseDao getImdRoomDataBaseDao();

  /*  @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }*/

}
