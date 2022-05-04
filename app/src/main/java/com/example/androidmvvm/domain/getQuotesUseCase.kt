package com.example.androidmvvm.domain

import com.example.androidmvvm.data.Model.QuoteModel
import com.example.androidmvvm.data.QuoteRepository


class getQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}