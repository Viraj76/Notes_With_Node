package com.appsv.noteswithnode.presentation.navhost

import kotlinx.serialization.Serializable

//@Serializable
//object HomeScreen
//
//@Serializable
//object AddNoteScreen
sealed class Routes(val route : String){
    object HomeScreen : Routes(route = "home")
    object AddNoteScreen : Routes(route = "add_note_screen")
}