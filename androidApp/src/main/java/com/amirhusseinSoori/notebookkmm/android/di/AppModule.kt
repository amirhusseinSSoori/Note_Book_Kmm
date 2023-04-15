package com.amirhusseinSoori.notebookkmm.android.di


import com.amirhusseinSoori.notebookkmm.android.note_detail.NoteDetailViewModel
import com.amirhusseinSoori.notebookkmm.android.note_list.NoteListViewModel
import com.amirhusseinSoori.notebookkmm.data.local.DatabaseDriverFactory
import com.amirhusseinSoori.notebookkmm.data.note.SqlDelightNoteDataSource
import com.amirhusseinSoori.notebookkmm.database.NoteDatabase
import com.amirhusseinSoori.notebookkmm.domain.note.NoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val mainModule = module {
    factory<NoteDataSource> {
        SqlDelightNoteDataSource(NoteDatabase(get()))
    }
    single { DatabaseDriverFactory(androidContext()).createDriver() }

    viewModelOf(::NoteListViewModel)
    viewModelOf(::NoteDetailViewModel)
}