package com.example.danp_lab05.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.danp_lab05.entities.Country
import com.example.danp_lab05.model.CountryDao


@Database(entities = [Country::class], version = 3)
abstract class CountryDatabase: RoomDatabase(){
    abstract fun countryDao(): CountryDao

    companion object {
        private var INSTANCE: CountryDatabase? = null

        fun getInstance(context: Context): CountryDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CountryDatabase::class.java,
                        "countries"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance

                }

                return instance
            }
        }
    }
}