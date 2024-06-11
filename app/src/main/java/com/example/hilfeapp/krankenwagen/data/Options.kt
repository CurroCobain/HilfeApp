// -------------------------- COMENTADO!!! -----------------------------

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

/**
 * Clase opciones que vamos a usar para configurar el tema de la app
 * @property color1 almacena el primer valor rgb del color principal de la app
 * @property color2 almacena el segundo valor rgb del color principal de la app
 * @property color3 almacena el tercer valor rgb del color principal de la app
 * @property fondo almacena el valor por el que se asignará el fondo de la app
 * @property image almacena el valor por el que se asignará la pantalla de carga de la app
 */
@Entity(tableName = "options")
data class Options(
    var color1: Float,
    var color2: Float,
    var color3: Float,
    var color4: Float,
    var color5: Float,
    var color6: Float,
    //var fondo: Int,
    var image: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}

/**
 * Data Access Object (DAO) para interactuar con las opciones de la base de datos.
 */
@Dao
interface OptionsDao {
    @Insert
    suspend fun insertOptions(options: Options)

    @Query("SELECT * FROM options LIMIT 1")
    suspend fun getOptions(): Options?


    @Query("DELETE FROM options")
    suspend fun deleteAllOptions()
}

/**
 * Clase abstracta que representa la base de datos de la aplicación.
 */
@Database(entities = [Options::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun optionsDao(): OptionsDao
}

/**
 * Constructor de la base de datos.
 */
object DatabaseBuilder {

    @Volatile
    private var INSTANCE: AppDatabase? = null // Instancia de la base de datos

    /**
     * Devuelve una instancia única de la base de datos.
     * @param context Contexto de la aplicación.
     * @return Instancia de la base de datos.
     */
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


