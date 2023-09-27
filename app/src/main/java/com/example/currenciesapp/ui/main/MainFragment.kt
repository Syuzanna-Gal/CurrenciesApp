package com.example.currenciesapp.ui.main

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.currenciesapp.R
import com.example.currenciesapp.core.base.BaseFragment
import com.example.currenciesapp.core.delegate.viewBinding
import com.example.currenciesapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment() : BaseFragment<MainViewModel>(R.layout.fragment_main) {
    override val viewModel: MainViewModel by viewModels()
    private val binding by viewBinding(FragmentMainBinding::bind)
    private lateinit var navController: NavController

    override fun initView() {
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment = childFragmentManager.findFragmentById(
            R.id.mainNavContainer
        ) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
        binding.bottomNav.setOnItemReselectedListener { item ->
            // Pop everything up to the reselected item
            val selectedMenuItemNavGraph = navController.graph.findNode(item.itemId) as? NavGraph
            selectedMenuItemNavGraph?.let {
                navController.popBackStack(it.startDestinationId, inclusive = false)
            }
        }
    }
}