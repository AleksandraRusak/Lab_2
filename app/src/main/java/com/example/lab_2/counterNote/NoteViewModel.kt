package com.example.lab_2.counterNote

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NoteViewModel : ViewModel() {

    // Setup mutableStateFlow
    // LiveData
    // Expose UI to Screen
    private val _notes = MutableStateFlow(NoteUiState())
    val notes: StateFlow<NoteUiState> = _notes.asStateFlow()

    fun addNote() {
        _notes.update {
            state -> state.copy(
            counterNoteValue = state.counterNoteValue + 1
            )

        }

    }

    fun removeNote() {
        _notes.update {
                state -> state.copy(
            counterNoteValue = state.counterNoteValue - 1
        )

        }

    }
}

