package za.co.masekofortune.menotes.ui.newnote

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.navigation.fragment.navArgs
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import za.co.masekofortune.menotes.databinding.FragmentNewNoteBinding
import java.text.SimpleDateFormat
import java.util.*

class NewNoteFragment : Fragment() {
    private val args: NewNoteFragmentArgs by navArgs()

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        populateNoteScreen()

        // Prevent keyboard from opening when clicking on due date input
        binding.etDueDate.editText?.inputType = InputType.TYPE_NULL
        binding.etDueDate.editText?.setOnFocusChangeListener { view, _ ->
            if (view.hasFocus()) {
                dueDateFocusHandler()
            }
        }

        binding.fabAddNewItem.setOnClickListener { addNoteItem() }

        return binding.root
    }

    private fun addNoteItem() {
        val listContainer = binding.listContainer
        val listContainerChildCount = listContainer.childCount.plus(1)
        binding.tvTotalItems.text = "Total items: $listContainerChildCount"

        val textInputLayout = TextInputLayout(requireContext())
        textInputLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textInputLayout.hint = "Item $listContainerChildCount"
        val editText = TextInputEditText(textInputLayout.context)
        textInputLayout.addView(editText)

        listContainer.addView(textInputLayout)
    }

    private fun dueDateFocusHandler() {
        val constraintsBuilder = CalendarConstraints.Builder()
            .setValidator(DateValidatorPointForward.now())

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select due date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setCalendarConstraints(constraintsBuilder.build())
            .build()

        datePicker.addOnPositiveButtonClickListener { setDueDate(it) }
        datePicker.show(childFragmentManager, "Due date date picker")
    }

    private fun setDueDate(dueDate: Long) {
        val date = Date(dueDate)
        val sdf = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())

        binding.etDueDate.editText?.setText(sdf.format(date))
    }

    private fun populateNoteScreen() {
        /**
         * If the noteId is -1, we have a new note...otherwise populate the screen with whatever
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