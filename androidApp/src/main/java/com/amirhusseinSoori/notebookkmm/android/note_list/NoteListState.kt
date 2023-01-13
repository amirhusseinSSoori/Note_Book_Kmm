package com.amirhusseinSoori.notebookkmm.android.note_list

import com.amirhusseinSoori.notebookkmm.domain.note.Note


data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
