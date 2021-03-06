package org.d3if1053.hitungzakatpenghasilan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ZakatEntity::class], version = 1, exportSchema = false)
abstract class ZakatDatabase : RoomDatabase() {
    abstract val dao: ZakatDao

    companion object {
        @Volatile
        private var INSTANCE: ZakatDatabase? = null

        fun getInstance(context: Context): ZakatDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ZakatDatabase::class.java,
                        "zakat.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}