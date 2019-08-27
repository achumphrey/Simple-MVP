package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.ViewInterface
import com.example.myapplication.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ViewInterface{

 private lateinit var presenter : Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(this)

        btn_login.setOnClickListener {
         processLogin()
        }
    }

    private fun processLogin(){
        val email = et_email.text.toString()
        val password = et_password.text.toString()
        presenter.processLogin(email, password)
    }
    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun showError() {
        Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSucess() {
        Toast.makeText(this,"You're logged in",Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
