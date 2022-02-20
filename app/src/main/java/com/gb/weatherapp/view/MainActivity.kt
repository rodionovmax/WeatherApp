package com.gb.weatherapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.weatherapp.R
import com.gb.weatherapp.databinding.MainActivityBinding
import com.gb.weatherapp.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.getRoot()
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}