package com.example.danp_lab05.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.danp_lab05.entities.Country
import com.example.danp_lab05.model.CountryRepository
import kotlinx.coroutines.flow.Flow

class CountryViewModel : ViewModel() {
    private val userRepository: CountryRepository = CountryRepository()

    fun items(): Flow<PagingData<Country>> {

        val pager = Pager(
            PagingConfig(
                pageSize = 20,
                enablePlaceholders = false,
                prefetchDistance = 3)
        ) {
            CountryPagingSource(userRepository)
        }.flow.cachedIn(viewModelScope)

        return pager

    }

}