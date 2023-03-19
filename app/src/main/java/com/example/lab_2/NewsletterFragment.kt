package com.example.lab_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import com.example.lab_2.counterNote.NoteViewModel
import com.example.lab_2.databinding.FragmentNewsletterBinding
import kotlinx.coroutines.launch

class NewsletterFragment : Fragment() {
    // Initialize ViewBinding
    private lateinit var binding: FragmentNewsletterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        // Inflate the layout for this fragment
        binding = FragmentNewsletterBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        // ID's
        val btnBack = binding.backButton
        val btnContinue = binding.continueButton

        // buttons add note +1 or -1
        val btnAddNote = binding.btnAddNote
        val btnRemoveNote = binding.removeNote

        // text view counter note
        val counterNoteValue = binding.counterNoteValue


        counterNoteValue.setOnClickListener() {}

        // ViewModel
        val noteViewModel by viewModels<NoteViewModel> ()

        // ViewModel lIFE Cycle

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                noteViewModel.notes.collect() {

                    // Update UI elements
                    counterNoteValue.text = noteViewModel.notes.value.counterNoteValue.toString()
                }
            }
        }

        // OnClick ViewModel Value +1
        btnAddNote.setOnClickListener() {
            noteViewModel.addNote()
        }

        // OnClick ViewModel Value -1
        btnRemoveNote.setOnClickListener() {
            noteViewModel.removeNote()
        }



        btnBack.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.homeFragment)
        }


        btnContinue.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.functionalityFragment)
        }
        return view
    }
}