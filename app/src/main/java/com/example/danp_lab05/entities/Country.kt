package com.example.danp_lab05.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class Country(
    @PrimaryKey(autoGenerate = true)
    val countrieId: Int,
    val name_en: String,
    val name_es:String,
    val continent_en: String,
    val continent_es:String,
    val capital_en: String,
    val capital_es:String,
    val dial_code: String,
    val code_2:String,
    val code_3: String,
    val tld:String,
    val km2:Int
)
