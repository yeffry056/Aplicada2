package com.example.androidmvvm.UI.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.androidmvvm.databinding.ActivityMainBinding
import com.example.androidmvvm.UI.viewModel.QuoteViewModel


//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuto.text = currentQuote.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}


