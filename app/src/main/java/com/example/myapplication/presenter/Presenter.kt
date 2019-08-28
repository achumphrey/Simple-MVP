package com.example.myapplication.presenter

import com.example.myapplication.PresenterInterface
import com.example.myapplication.ViewInterface
import com.example.myapplication.model.Model

class Presenter(_view: ViewInterface?): PresenterInterface {

    var view: ViewInterface? = _view
    var model = Model()

    override fun processLogin(email: String, password: String) {
       if (email.equals(model.getEmail()) && password.equals(model.getPassword())){
           view?.onLoginSucess()
       } else{
           view?.showError()
       }
    }

    override fun onDestroy() {
        view = null
    }
}