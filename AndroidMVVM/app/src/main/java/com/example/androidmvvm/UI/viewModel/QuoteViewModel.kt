package com.example.androidmvvm.UI.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmvvm.data.Model.QuoteModel
import com.example.androidmvvm.data.Model.QuoteProvider
import com.example.androidmvvm.domain.GetRandomQuotesUseCase
import com.example.androidmvvm.domain.getQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
   private val GetQuotesUseCase:getQuotesUseCase,
   private val getRandomQuotesUseCase:GetRandomQuotesUseCase
): ViewModel() {
    //private val GetQuotesUseCase: getQuotesUseCase,
   // private val getRandomQuotesUseCase: GetRandomQuotesUseCase

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    /*
        var GetQuotesUseCase = getQuotesUseCase()
    var getRandomQuotesUseCase = GetRandomQuotesUseCase()
     */

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            //val result:List<QuoteModel>? = getQuotesUseCase()
            val result= GetQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
    fun randomQuote(){
        isLoading.postValue(true)
        val quote:QuoteModel? = getRandomQuotesUseCase()
        if(quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
       // val currenntQuote: QuoteModel = QuoteProvider.random()
      //  quoteModel.postValue(currenntQuote)
    }

}