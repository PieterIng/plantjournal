package org.inghelram.plantjournal.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.inghelram.plantjournal.dao.OverviewItemDao
import org.inghelram.plantjournal.database.entity.OverviewItem

@Database(entities = arrayOf(OverviewItem::class), version = 1, exportSchema = false)
public abstract class PlantJournalDatabase : RoomDatabase() {
    abstract fun overviewItemDao(): OverviewItemDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PlantJournalDatabase? = null

        fun getDatabase(context: Context): PlantJournalDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantJournalDatabase::class.java,
                    "PlantJournalDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}