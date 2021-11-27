package com.example.s191179lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.s191179lykkehjulet.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.s191179lykkehjulet.adapter.ItemAdapter



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





        //old recyclerview
        // initialize data
        //val myDataset = Datasource().loadCategory()

        //val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        //recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //recyclerView.setHasFixedSize(true)
    }
}

