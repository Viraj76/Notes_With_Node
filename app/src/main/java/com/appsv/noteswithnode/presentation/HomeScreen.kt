package com.appsv.noteswithnode.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.appsv.noteswithnode.R
import com.appsv.noteswithnode.presentation.add_notes.AddNoteScreen

import com.appsv.noteswithnode.presentation.navhost.Routes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Your other content goes here
        }

        FloatingActionButton(
            onClick = {
                    navController.navigate(Routes.AddNoteScreen.route)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd).padding(30.dp),
            containerColor = colorResource(id = R.color.medium_blue)
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add",
                tint = colorResource(id = R.color.white),
            )
        }
    }
}
