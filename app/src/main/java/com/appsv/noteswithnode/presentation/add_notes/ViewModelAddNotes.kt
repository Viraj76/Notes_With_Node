package com.appsv.noteswithnode.presentation.add_notes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ViewModelAddNotes  : ViewModel(){


    private val _notesState = MutableStateFlow(StateAddNoteScreen())
    val notesState = _notesState

    fun onEvent(event : EventAddNoteScreen){
        when(event){
            is EventAddNoteScreen.NotesDescription -> {
                _notesState.value = notesState.value.copy(notesDescription = event.notesDescription)
            }
            is EventAddNoteScreen.NotesPriority -> {
                _notesState.value = notesState.value.copy(notesPriority = event.notesPriority)
            }
            is EventAddNoteScreen.NotesTitle -> {
                _notesState.value = notesState.value.copy(notesTitle = event.notesTitle)
            }
        }
    }



}