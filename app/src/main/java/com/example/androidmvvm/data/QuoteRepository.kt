package com.example.androidmvvm.data

import com.example.androidmvvm.data.Model.QuoteModel
import com.example.androidmvvm.data.Model.QuoteProvider
import com.example.androidmvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}