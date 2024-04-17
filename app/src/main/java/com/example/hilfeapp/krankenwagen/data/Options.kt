package com.example.hilfeapp.krankenwagen.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Entity(tableName = "options")
data class Options(
    var color1: Float,
    var color2: Float,
    var color3: Float,
    var fondo: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}

@Dao
interface OptionsDao {
    @Insert
    suspend fun insertOptions(options: Options)

    @Query("SELECT * FROM options LIMIT 1")
    suspend fun getOptions(): Options?


    @Query("DELETE FROM options")
    suspend fun deleteAllOptions()
}

@Database(entities = [Options::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun optionsDao(): OptionsDao
}

object DatabaseBuilder {

    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}


