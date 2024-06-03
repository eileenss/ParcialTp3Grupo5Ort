package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.parcialtp3grupo5ort.R




class ProfileDetailsFragment : Fragment() {

    private lateinit var viewProfileDetails: View
    private lateinit var buttonSettingsProfile : EditText

    companion object {
        val BUTTON_SETTINGS_PROFILE = R.id.profileSettingsText
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewProfileDetails = inflater.inflate(R.layout.fragment_profile_details, container, false)
        initViews()

    return viewProfileDetails
    }
    override fun onStart() {
        super.onStart()
        initListeners()
    }
    private fun initViews(){
        buttonSettingsProfile = viewProfileDetails.findViewById(BUTTON_SETTINGS_PROFILE)
    }
    private fun initListeners(){
        buttonSettingsProfile.setOnClickListener {navigateToSettings()}
    }

    private fun navigateToSettings(){
        val action = ProfileDetailsFragmentDirections.actionProfileDetailsFragmentToSettings()
        viewProfileDetails.findNavController().navigate(action)
    }
}