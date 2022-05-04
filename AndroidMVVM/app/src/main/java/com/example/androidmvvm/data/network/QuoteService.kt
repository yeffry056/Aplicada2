package com.example.androidmvvm.data.network

import com.example.androidmvvm.core.RetrofitHelper
import com.example.androidmvvm.data.Model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{

        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}