package com.appsv.noteswithnode.presentation.add_notes

import androidx.compose.foundation.background
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.noteswithnode.R
import com.appsv.noteswithnode.domain.models.Notes
import com.appsv.noteswithnode.domain.models.getSampleNotes
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun AddNoteScreen(notes: Notes) {
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.medium_blue)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Row (
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End
            ){
                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            color = when (notes.notesPriority) {
                                "High" -> Color.Red.copy(alpha = 0.4f)
                                "Medium" -> Color.Yellow.copy(alpha = 0.4f)
                                "Low" -> Color.Green.copy(alpha = 0.4f)
                                else -> Color.Gray.copy(alpha = 0.2f)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = notes.notesPriority,
                        color = when (notes.notesPriority) {
                            "High" -> Color.Red.copy(alpha = 1f)
                            "Medium" -> Color.Yellow.copy(alpha = 1f)
                            "Low" -> Color.Green.copy(alpha = 1f)
                            else -> Color.Gray.copy(alpha = 0.7f)
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = notes.notesTitle,
                color = colorResource(id = R.color.splash_back),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = notes.notesDescription,
                color = colorResource(id = R.color.splash_back),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                text = notes.notesAddedDate,
                color = Color.Cyan,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )

        }
    }
}


@Preview
@Composable
fun Note() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(13.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        verticalItemSpacing = 1.dp
    ) {
        items(getSampleNotes()) {
            AddNoteScreen(it)
        }
    }
}