package za.co.masekofortune.menotes.ui.notelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import za.co.masekofortune.menotes.R
import za.co.masekofortune.menotes.models.Note
import java.text.SimpleDateFormat
import java.util.*

class NoteListAdapter(
    private val notesData: List<Note>,
    val noteClickListener: (noteId: Int) -> Unit
) : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNoteTitle: TextView = view.findViewById(R.id.tvNoteTitle)
        val tvDueDate: TextView = view.findViewById(R.id.tvDueDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_list_item_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesData[position]
        val formatter = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
        holder.tvNoteTitle.text = note.title
        holder.tvDueDate.text = formatter.format(note.dueDate!!)
        holder.itemView.setOnClickListener { noteClickListener(note.id) }
    }

    override fun getItemCount(): Int = notesData.size
}