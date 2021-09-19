package za.co.masekofortune.menotes.models

data class NoteItem(val text: String, var status: NoteItemStatus = NoteItemStatus.TODO)

