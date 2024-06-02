package com.example.parcialtp3grupo5ort

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var bottomNavView: BottomNavigationView

    private val fragmentsWithoutBottomNavAndActionBar = setOf(
        // Use descriptive fragment IDs for better readability (e.g., R.id.fragment_search_results)
        R.id.searchResults
        //fragmento de Borocay/Detail
    )
    private val fragmentsWithoutActionBar = setOf(
        // Use descriptive fragment IDs for better readability (e.g., R.id.fragment_search)
        R.id.search,
        R.id.offers,
        R.id.profile
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.drawer_nav)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_var)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //Mostrar icono hamburguesa
        // Oculto el título de la Toolbar
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val navController = navHostFragment.navController

        val headerView = layoutInflater.inflate(R.layout.header_nav, navigationView, false)
        navigationView.addHeaderView(headerView)

        // Vinculo la navegación del drawer con la del graph
        navigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburguesa)
        }

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            hiddenActionBarAndBottomBar(destination) // Use the combined function
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return false
    }

    private fun hiddenActionBarAndBottomBar(destination: NavDestination) {
        if (destination.id in fragmentsWithoutBottomNavAndActionBar) {
            bottomNavView.visibility = View.GONE
            supportActionBar?.hide()
        } else if (destination.id in fragmentsWithoutActionBar) {
            bottomNavView.visibility = View.VISIBLE  // Show bottom nav for other fragments in fragmentsWithoutActionBar
            supportActionBar?.hide()
        } else {
            bottomNavView.visibility = View.VISIBLE
            supportActionBar?.show()
        }
    }
}
