package com.example.mostafakhalifacroshet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.databinding.ActivityMainBinding
import com.example.mostafakhalifacroshet.databinding.ActivityRegisterBinding
import com.example.mostafakhalifacroshet.databinding.FragmentUserInfoBinding
import com.example.mostafakhalifacroshet.viewModels.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}