package com.example.danp_lab05.model;

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.danp_lab05.entities.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<Country>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountrie(noteEntity: Country)

    @Query("SELECT * FROM countries")
    fun pagingSource(): PagingSource<Int, Country>

    @Query("SELECT * FROM countries")
    fun getAll(): Flow<List<Country>>

    @Query("DELETE FROM countries")
    suspend fun clearAll()
 }