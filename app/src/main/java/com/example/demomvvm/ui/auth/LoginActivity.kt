package com.example.demomvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.demomvvm.R
import com.example.demomvvm.databinding.ActivityLoginBinding
import com.example.demomvvm.util.hide
import com.example.demomvvm.util.show
import com.example.demomvvm.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.loginViewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress.show()
    }

    override fun onSuccess(loginResponse: String) {
        progress.hide()
        toast(loginResponse)
    }

    override fun onFailure(message: String) {
        progress.hide()
        toast("Login Failed: $message")
    }

}
