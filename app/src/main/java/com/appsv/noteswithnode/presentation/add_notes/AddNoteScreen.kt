package com.appsv.noteswithnode.presentation.add_notes

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appsv.noteswithnode.R
import com.appsv.noteswithnode.presentation.add_notes.component.AddNoteToolBar
import com.appsv.noteswithnode.presentation.add_notes.component.CustomFilterChip


@Composable
fun AddNoteScreen(
    modifier: Modifier = Modifier,
    state: StateAddNoteScreen,
    event: (EventAddNoteScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var lowSelected by remember { mutableStateOf(false) }
        var mediumSelected by remember { mutableStateOf(false) }
        var highSelected by remember { mutableStateOf(false) }

        Column {

            AddNoteToolBar()

            Column(
                modifier = Modifier.padding(5.dp)
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.notesTitle,
                    onValueChange = { newTitle ->
                        event(EventAddNoteScreen.NotesTitle(newTitle))
                    },
                    label = { Text(text = "Enter notes title...") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.medium_blue),
                        unfocusedBorderColor = colorResource(id = R.color.medium_blue),
                        focusedTextColor = colorResource(id = R.color.white),
                        unfocusedTextColor = colorResource(id = R.color.white),
                        focusedContainerColor = colorResource(id = R.color.medium_blue),
                        unfocusedContainerColor = colorResource(id = R.color.medium_blue),

                        ),
                    maxLines = 2,
                    shape = RoundedCornerShape(5.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    value = state.notesDescription,
                    onValueChange = {
                        event(EventAddNoteScreen.NotesDescription(it))
                    },
                    label = { Text(text = "Enter note description...") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.medium_blue),
                        unfocusedBorderColor = colorResource(id = R.color.medium_blue),
                        focusedTextColor = colorResource(id = R.color.white),
                        unfocusedTextColor = colorResource(id = R.color.white),
                        focusedContainerColor = colorResource(id = R.color.medium_blue),
                        unfocusedContainerColor = colorResource(id = R.color.medium_blue),
                    ),
                    maxLines = 10,
                    shape = RoundedCornerShape(5.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.End),
                ) {
                    CustomFilterChip(
                        label = "Low",
                        color = Color.Green,
                        selected = state.notesPriority == "Low",
                        onClick = {
                            event(EventAddNoteScreen.NotesPriority("Low"))
                        }
                    )
                    CustomFilterChip(
                        label = "Medium",
                        color = Color.Yellow,
                        selected = state.notesPriority == "Medium",
                        onClick = {
                            event(EventAddNoteScreen.NotesPriority("Medium"))
                        }
                    )
                    CustomFilterChip(
                        label = "High",
                        color = Color.Red,
                        selected = state.notesPriority == "High",
                        onClick = {
                            event(EventAddNoteScreen.NotesPriority("High"))
                        }
                    )

                }


            }
        }

        FloatingActionButton(
            onClick = {
                      Log.d("notessss" , "${state.notesTitle}  ${state.notesDescription}")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = colorResource(id = R.color.medium_blue)
        ) {
            Icon(
                Icons.Filled.Done,
                contentDescription = "Add",
                tint = colorResource(id = R.color.white)
            )
        }

    }
}