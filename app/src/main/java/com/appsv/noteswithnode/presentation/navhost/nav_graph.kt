package com.appsv.noteswithnode.presentation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsv.noteswithnode.presentation.HomeScreen
import com.appsv.noteswithnode.presentation.add_notes.AddNoteScreen
import com.appsv.noteswithnode.presentation.add_notes.ViewModelAddNotes

@Composable
fun SetupNavHost(modifier: Modifier = Modifier) {


    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen.route){

        composable(
            route = Routes.HomeScreen.route
        ) {
           HomeScreen(navController = navController)
        }

        composable(
            route = Routes.AddNoteScreen.route
        ) {
            val viewModel = viewModel<ViewModelAddNotes>()
            val state by viewModel.notesState.collectAsState()
            AddNoteScreen(state = state , event = viewModel::onEvent)
        }
    }

}