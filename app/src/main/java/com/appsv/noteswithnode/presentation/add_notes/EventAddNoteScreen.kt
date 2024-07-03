package com.appsv.noteswithnode.presentation.add_notes

sealed class EventAddNoteScreen{


    data class NotesTitle(val notesTitle: String) : EventAddNoteScreen()
    data class NotesDescription(val notesDescription: String) : EventAddNoteScreen()
    data class NotesPriority(val notesPriority: String = "Low") : EventAddNoteScreen()


}