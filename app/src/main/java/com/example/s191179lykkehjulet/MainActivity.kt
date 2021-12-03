package com.example.s191179lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.s191179lykkehjulet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get the navigation host fragment from this activity
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.NavHost) as NavHostFragment
        //instantiate the navController using the NavHostFragment
        navController = navHostFragment.navController
    }
}

