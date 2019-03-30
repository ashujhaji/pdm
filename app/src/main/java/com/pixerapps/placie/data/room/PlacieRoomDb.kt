package com.pixerapps.placie.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.pixerapps.placie.utils.Constants

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
abstract class PlacieRoomDb : RoomDatabase() {
    abstract fun daoAccess(): PlacieRoomDao
    private var instance: PlacieRoomDb? = null

    fun getAppDatabase(context: Context): PlacieRoomDb {
        if (instance == null) {
            instance = Room.databaseBuilder<PlacieRoomDb>(
                context,
                PlacieRoomDb::class.java,
                Constants.ROOM_DB_NAME
            )
                .allowMainThreadQueries()
                .build()

        }
        return instance as PlacieRoomDb
    }
}