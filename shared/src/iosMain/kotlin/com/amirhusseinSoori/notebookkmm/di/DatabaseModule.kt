package com.amirhusseinSoori.notebookkmm.di

import com.amirhusseinSoori.notebookkmm.data.local.DatabaseDriverFactory
import com.amirhusseinSoori.notebookkmm.data.note.SqlDelightNoteDataSource
import com.amirhusseinSoori.notebookkmm.database.NoteDatabase
import com.amirhusseinSoori.notebookkmm.domain.note.NoteDataSource


class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}