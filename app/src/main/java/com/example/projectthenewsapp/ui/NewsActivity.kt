package com.example.projectthenewsapp.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projectthenewsapp.R
import com.example.projectthenewsapp.databinding.ActivityNewsBinding
import com.example.projectthenewsapp.db.ArticleDatabase
import com.example.projectthenewsapp.repository.NewRepository

class NewsActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_news)

        val newsRepository = NewRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

    }
}