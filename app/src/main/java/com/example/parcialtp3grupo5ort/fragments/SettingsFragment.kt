package com.example.parcialtp3grupo5ort.fragments

import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import com.example.parcialtp3grupo5ort.R

class SettingsFragment : Fragment() {

    private lateinit var settingsView : View
private lateinit var switchModoOscuro: Switch
    private lateinit var sharedPreferences: SharedPreferences


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
        configSwitch()
        return settingsView
    }

    override fun onStart() {
        super.onStart()

    }

    private fun configSwitch(){
        sharedPreferences = requireActivity().getSharedPreferences("app_preferences", 0)

        // Obtener el estado del modo oscuro guardado y establecer el tema correspondiente
        if (sharedPreferences.getBoolean("dark_mode", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        switchModoOscuro.isChecked = sharedPreferences.getBoolean("dark_mode", false)

        switchModoOscuro.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            sharedPreferences.edit {
                putBoolean("dark_mode", isChecked)
                apply()
            }
        }
    }

    private fun initViews(){
switchModoOscuro = settingsView.findViewById(SWITCH_MODO_OSCURO)
    }
}