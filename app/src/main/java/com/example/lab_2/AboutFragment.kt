package com.example.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.lab_2.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    // Initialize ViewBinding
    private lateinit var binding: FragmentAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Setup ViewBinding

        binding = FragmentAboutBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        // ID's
        val btnBack = binding.backButton

        // onClick
        btnBack.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.homeFragment)
        }

        return view

    }
}