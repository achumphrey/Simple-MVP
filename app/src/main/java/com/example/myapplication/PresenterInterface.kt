package com.example.myapplication

interface PresenterInterface {

    fun processLogin(email: String,password:String)
    fun onDestroy()
}