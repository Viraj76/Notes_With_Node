package com.appsv.noteswithnode.presentation.add_notes.component

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import com.appsv.noteswithnode.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteToolBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(text = "Add Note", color = Color.White)
        },
        colors = TopAppBarDefaults.topAppBarColors()
            .copy(
                containerColor = colorResource(id = R.color.dark_blue)
            ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "", tint = Color.White)
            }
        },

    )
}