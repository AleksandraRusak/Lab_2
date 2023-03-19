package com.example.lab_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.lab_2.databinding.FragmentFunctionalityBinding
import com.google.android.material.snackbar.Snackbar


class FunctionalityFragment : Fragment() {
    // Initialize ViewBinding
    private lateinit var binding: FragmentFunctionalityBinding
    // Initialize arrayList
    private val emailList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Setup ViewBinding

        binding = FragmentFunctionalityBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        // ID's
        val btnSubmit = binding.submitButton
        val emailEditText = binding.emailEditText
        val btnLogOut = binding.logOutButton

        // Log Out button navigate to home screen
        btnLogOut.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.homeFragment)
        }

        // onClick Submit button + Snackbar med UNDO action + Toast
        btnSubmit.setOnClickListener {
            val email = emailEditText.text.toString()
            if (email.isNotEmpty()) {
                emailList.add(email)
                println("Email added: $email")
                Snackbar.make(binding.root, "Email saved", Snackbar.LENGTH_LONG)
                    .setAction("UNDO") {
                        emailList.remove(email)
                        println("Email removed: $email")
                    }.show()
                emailEditText.text?.clear() // to empty placeholder
            } else {
                Toast.makeText(context, "Please enter an email", Toast.LENGTH_SHORT).show()
            }

        }

        return view
    }

}







