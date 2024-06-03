package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.findNavController
import com.example.parcialtp3grupo5ort.R


class Profile : Fragment() {

    private lateinit var profileView: View
    private lateinit var buttonBackProfile : ImageView


    companion object {
val BUTTON_BACK_PROFILE = R.id.backProfileIcon

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        profileView = inflater.inflate(R.layout.fragment_profile, container, false)
        initViews()

        return profileView
    }
    override fun onStart() {
        super.onStart()
        initListeners()
    }

    private fun initViews(){
        buttonBackProfile = profileView.findViewById(BUTTON_BACK_PROFILE)

    }
private fun initListeners(){
buttonBackProfile.setOnClickListener { navigateBack() }

}

    private fun navigateBack(){

    }


}