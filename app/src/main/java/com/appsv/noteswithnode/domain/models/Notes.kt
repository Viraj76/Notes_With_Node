package com.appsv.noteswithnode.domain.models

data class Notes(
    val notesTitle : String,
    val notesDescription : String  = "",
    val notesPriority : String = "Low",
    val notesAddedDate : String = "12-04-2024"
)

fun getSampleNotes(): List<Notes> {
    return listOf(
        Notes(
            notesTitle = "Buy Groceries afvadfvadf aervaervqervqrevqrv",
            notesDescription = "Need to buy milk, bread, and eggs.",
            notesPriority = "High",
            notesAddedDate = "03-07-2024"
        ),
        Notes(
            notesTitle = "Study for Exams",
            notesDescription = "Revise chapters 4, 5, and 6 for the upcoming test. rfaerf qer q qer reer  qer dafvdrfvqervqerv",
            notesPriority = "Medium",
            notesAddedDate = "02-07-2024"
        ),
        Notes(
            notesTitle = "Workout",
            notesDescription = "Complete the morning workout routine.",
            notesPriority = "Low",
            notesAddedDate = "01-07-2024"
        ),
        Notes(
            notesTitle = "Call Mom",
            notesDescription = "Catch up with mom over the phone.",
            notesPriority = "Low",
            notesAddedDate = "04-07-2024"
        )
    )
}