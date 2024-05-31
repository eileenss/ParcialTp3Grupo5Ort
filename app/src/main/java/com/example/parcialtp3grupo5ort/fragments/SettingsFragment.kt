package com.example.parcialtp3grupo5ort.fragments

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.annotation.RequiresApi
import com.example.parcialtp3grupo5ort.R

class SettingsFragment : Fragment() {

    private lateinit var settingsView : View
private lateinit var switchModoOscuro: Switch


    companion object {
val SWITCH_MODO_OSCURO =R.id.switch_dark_mode

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        settingsView= inflater.inflate(R.layout.fragment_settings, container, false)
        initViews()

        return settingsView
    }

    override fun onStart() {
        super.onStart()

    }

    private fun initViews(){
switchModoOscuro = settingsView.findViewById(SWITCH_MODO_OSCURO)
    }
}