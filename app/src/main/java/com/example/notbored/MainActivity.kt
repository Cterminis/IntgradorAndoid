package com.example.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navController = Navigation.findNavController(this,
            R.id.fragment
        )
        val navBottomNavController = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        val appBarConfiguration= AppBarConfiguration(setOf(R.id.mainFragment,R.id.action_mainFragment_to_detail))

        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration)

        navBottomNavController.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {

        return NavigationUI.navigateUp(navController, null)
    }
}