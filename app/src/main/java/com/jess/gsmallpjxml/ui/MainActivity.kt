package com.jess.gsmallpjxml.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.jess.gsmallpjxml.R
import com.jess.gsmallpjxml.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navControler: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initBottomNavigation()

        setContentView ( binding.root )
    }
    private fun initBottomNavigation() {
        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment
        val navController = navHost.navController
        binding.bottomNav.setupWithNavController(navController)
    }
}