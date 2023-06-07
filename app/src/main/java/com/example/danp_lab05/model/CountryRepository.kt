package com.example.danp_lab05.model;


import android.util.Log
import androidx.paging.PagingSource
import com.example.danp_lab05.database.CountryDatabase
import com.example.danp_lab05.entities.Country
import kotlinx.coroutines.flow.Flow


class CountryRepository(
    private val appDatabase: CountryDatabase
) {
    fun getUsers(nextPageNumber: Int): List<Country> {

        Log.d("nextPageNumber:", nextPageNumber.toString())

        val users = arrayListOf<Country>()
        var user: Country
        val start: Int = 100 * nextPageNumber
        val end = start + 20

        for (i in start..end) {
            user = Country(
                countrieId = i,
                name_en = "FirstName " + i,
                name_es = "SecondName " + i,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0
            );
            users.add(user)
        }

        return users
    }

     suspend fun insertAll(studentsEntity: List<Country>) {
         appDatabase.countryDao().insertAll(studentsEntity)
     }

    suspend fun insertCountrie(studentsEntity: Country) {
        appDatabase.countryDao().insertCountrie(studentsEntity)
    }
     fun pagingSource(query: String): PagingSource<Int, Country> {
         return appDatabase.countryDao().pagingSource()
     }

     fun getAll(): Flow<List<Country>>{
         return appDatabase.countryDao().getAll()
     }
     suspend fun clearAll() {
         return appDatabase.countryDao().clearAll()
     }

}

//data class ResponseUser       (val users: List<User>, val nextPageNumber: Int)