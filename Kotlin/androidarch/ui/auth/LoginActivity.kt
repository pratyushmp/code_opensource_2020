package com.example.androidarch.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidarch.R
import com.example.androidarch.data.db.entities.User
import com.example.androidarch.databinding.ActivityLoginBinding
import com.example.androidarch.ui.home.HomeActivity
import com.example.androidarch.util.hide
import com.example.androidarch.util.show
import com.example.androidarch.util.toast
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()

    private val factory : authViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        var binding : ActivityLoginBinding  = DataBindingUtil.setContentView(this, R.layout.activity_login)

        var viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUsers().observe(this, Observer { user->

            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(it)
                }
            }
        })
    }
    

    override fun onStarted() {
        progress_Bar.show()
    }

    override fun onSucess(user: User) {
        progress_Bar.hide()
        toast("${user.name} is logged in")
    }

    override fun onFailure(message: String) {
    progress_Bar.hide()
    }

}
