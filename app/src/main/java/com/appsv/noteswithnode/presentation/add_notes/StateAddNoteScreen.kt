package com.appsv.noteswithnode.presentation.add_notes

data class StateAddNoteScreen(

    val notesTitle : String = "",
    val notesDescription: String = "",
    val notesPriority : String = "Low"
)