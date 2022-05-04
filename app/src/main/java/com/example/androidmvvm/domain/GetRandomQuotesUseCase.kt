package com.example.androidmvvm.domain

import com.example.androidmvvm.data.Model.QuoteModel
import com.example.androidmvvm.data.Model.QuoteProvider



//@Inject constructor()
class GetRandomQuotesUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes:List<QuoteModel> = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val random: Int = (quotes.indices).random()
            return quotes[random]
        }
        return null
    }
}