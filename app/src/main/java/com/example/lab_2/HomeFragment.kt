package com.example.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.lab_2.databinding.ActivityMainBinding
import com.example.lab_2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    // Initialize
    private var _binding: FragmentHomeBinding? = null       // Can be NULL
    private val binding get() = _binding!!                    // Getter ??

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Setup ViewBinding

        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        // ID's
        val btnAbout = binding.aboutButton
        val btnSignIn = binding.signInButton

        // onClick
        btnAbout.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.aboutFragment)
        }

        // onClick
        btnSignIn.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.newsletterFragment)
        }

        return view
    }


}