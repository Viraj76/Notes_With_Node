package com.appsv.noteswithnode.presentation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsv.noteswithnode.presentation.HomeScreen
import com.appsv.noteswithnode.presentation.add_notes.AddNoteScreen

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
            AddNoteScreen()
        }
    }

}