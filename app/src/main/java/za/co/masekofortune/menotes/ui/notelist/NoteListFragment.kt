package za.co.masekofortune.menotes.ui.notelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import za.co.masekofortune.menotes.data.NotesSeedData
import za.co.masekofortune.menotes.databinding.FragmentNoteListBinding
import za.co.masekofortune.menotes.models.Note

class NoteListFragment : Fragment() {
    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notesData = NotesSeedData.notes
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)

        binding.rvNoteList.adapter =
            NoteListAdapter(notesData) { noteId -> noteClickHandler(noteId) }
        binding.rvNoteList.layoutManager = LinearLayoutManager(requireContext())

        binding.fabAddNote.setOnClickListener { fabClickHandler() }

        return binding.root
    }

    private fun fabClickHandler() {
        val action = NoteListFragmentDirections.actionNoteListFragmentToNoteItemFragment()
        findNavController().navigate(action)
    }

    private fun noteClickHandler(noteId: Int) {
        val action = NoteListFragmentDirections.actionNoteListFragmentToNoteItemFragment(noteId)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}