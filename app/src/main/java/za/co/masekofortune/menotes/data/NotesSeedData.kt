package za.co.masekofortune.menotes.data

import za.co.masekofortune.menotes.models.Note
import za.co.masekofortune.menotes.models.NoteItem
import java.util.*

object NotesSeedData {
    val notes = mutableListOf(
        Note(
            id = 1,
            title = "Learn Kotlin",
            items = listOf(
                NoteItem(text = "Learn about sealed classes"),
                NoteItem(text = "Learn about scope functions"),
                NoteItem(text = "Learn about coroutines")
            ),
            dueDate = generateDueDate(1)
        ),
        Note(
            id = 2,
            title = "Learn Android",
            items = listOf(
                NoteItem(text = "Learn about intents"),
                NoteItem(text = "Learn about views"),
                NoteItem(text = "Learn about notifications")
            ),
            dueDate = generateDueDate(0, 2, 0)
        ),
        Note(
            id = 3,
            title = "Learn Jetpack libraries",
            items = listOf(
                NoteItem(text = "Learn about room"),
                NoteItem(text = "Learn about compose"),
                NoteItem(text = "Learn about work manager")
            ),
            dueDate = generateDueDate(0, 0, 3)
        )
    )

    private fun generateDueDate(addDay: Int = 0, addWeek: Int = 0, addMonth: Int = 0): Date {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, addDay)
        calendar.add(Calendar.WEEK_OF_MONTH, addWeek)
        calendar.add(Calendar.MONTH, addMonth)

        return calendar.time
    }
}