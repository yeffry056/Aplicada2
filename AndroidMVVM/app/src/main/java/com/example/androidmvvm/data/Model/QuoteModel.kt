package com.example.androidmvvm.data.Model

import com.google.gson.annotations.SerializedName

class QuoteModel(@SerializedName("quote") val quote:String,@SerializedName("author") val author:String)
