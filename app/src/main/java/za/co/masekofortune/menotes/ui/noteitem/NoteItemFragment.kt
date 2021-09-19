package za.co.masekofortune.menotes.ui.noteitem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import za.co.masekofortune.menotes.databinding.FragmentNoteItemBinding

class NoteItemFragment : Fragment() {
    private val args: NoteItemFragmentArgs by navArgs()

    private var _binding: FragmentNoteItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteItemBinding.inflate(inflater, container, false)

        populateNoteScreen()

        return binding.root
    }

    private fun populateNoteScreen() {
        /**
         * If the noteId is 0, we have a new note...otherwise populate the screen with whatever
         * note data that we have from the DB
         */
        if (args.noteId != -1) {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}