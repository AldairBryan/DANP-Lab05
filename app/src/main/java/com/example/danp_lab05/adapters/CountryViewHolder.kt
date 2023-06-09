package com.example.danp_lab05.adapters;

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.danp_lab05.entities.Country
import org.idnp.jetpackpagingsample.R

class CountryViewHolder(view: View) : RecyclerView. ViewHolder(view) {

    private val cuiText = view.findViewById<TextView>(R.id.textViewCui) as TextView
    private val firstNameText = view.findViewById<TextView>(R.id.textViewFirstName) as TextView
    private val secondNameText = view.findViewById<TextView>(R.id.textViewSecondName) as TextView

    fun bind(user: Country) {
        with(user) {
            cuiText.text = countrieId.toString()
            firstNameText.text = name_en.toString()
            secondNameText.text = name_es.toString()
        }
    }
}