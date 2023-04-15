package com.amirhusseinSoori.notebookkmm.android

import android.app.Application
import com.amirhusseinSoori.notebookkmm.android.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NoteApp: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@NoteApp)
            modules(mainModule)
        }
    }
}