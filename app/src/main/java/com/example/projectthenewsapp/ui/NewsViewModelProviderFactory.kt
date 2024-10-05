package com.example.projectthenewsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projectthenewsapp.repository.NewRepository

class NewsViewModelProviderFactory(val app: Application, val newsRepository: NewRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create (modelClass: Class<T>): T {
        return NewsViewModel(app,newsRepository) as T
    }
}