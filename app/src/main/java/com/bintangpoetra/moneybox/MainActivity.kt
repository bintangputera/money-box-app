package com.bintangpoetra.moneybox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bintangpoetra.moneybox.databinding.ActivityMainBinding
import com.bintangpoetra.moneybox.utils.extension.gone
import com.bintangpoetra.moneybox.utils.extension.hide
import com.bintangpoetra.moneybox.utils.extension.show

class MainActivity : AppCompatActivity() {

    private lateinit var _activityMainBinding: ActivityMainBinding
    private val binding get() = _activityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_activityMainBinding.root)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navHostBottomBar =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navControllerBottomBar = navHostBottomBar.navController

        binding.mainBottomNavigation.setupWithNavController(navControllerBottomBar)
        navControllerBottomBar.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.walletFragment ||
                destination.id == R.id.settingsFragment
            ) {
                binding.mainBottomNavigation.show()
            } else {
                binding.mainBottomNavigation.gone()
            }
        }
    }

}