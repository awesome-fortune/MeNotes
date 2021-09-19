package za.co.masekofortune.menotes.models

import java.util.*

data class Note(
    val id: Int,
    val title: String,
    val items: List<NoteItem>? = null,
    val dueDate: Date? = null
)