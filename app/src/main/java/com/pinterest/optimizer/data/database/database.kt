package com.pinterest.optimizer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pinterest.optimizer.data.models.*

@Database(
    entities = [
        PinterestAccount::class,
        NicheProfile::class,
        PinterestPost::class,
        PostAnalytics::class,
        Trend::class
    ],
    version = 2,
    exportSchema = false
)
abstract class PinterestOptimizerDatabase : RoomDatabase() {
    abstract fun pinterestAccountDao(): PinterestAccountDao
    abstract fun nicheProfileDao(): NicheProfileDao
    abstract fun pinterestPostDao(): PinterestPostDao
    abstract fun analyticsDao(): AnalyticsDao
    abstract fun trendDao(): TrendDao
    
    companion object {
        @Volatile
        private var INSTANCE: PinterestOptimizerDatabase? = null
        
        fun getDatabase(context: Context): PinterestOptimizerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PinterestOptimizerDatabase::class.java,
                    "pinterest_optimizer_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
