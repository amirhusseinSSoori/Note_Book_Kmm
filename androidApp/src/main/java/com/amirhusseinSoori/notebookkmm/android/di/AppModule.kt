package com.amirhusseinSoori.notebookkmm.android.di

import android.app.Application
import com.amirhusseinSoori.notebookkmm.data.local.DatabaseDriverFactory
import com.amirhusseinSoori.notebookkmm.data.note.SqlDelightNoteDataSource
import com.amirhusseinSoori.notebookkmm.database.NoteDatabase
import com.amirhusseinSoori.notebookkmm.domain.note.NoteDataSource

import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}