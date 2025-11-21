package com.aiinty.courseapp.navigation

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.aiinty.core.navigation.AppNavigator
import com.aiinty.courseapp.MainActivity
import com.aiinty.courseapp.R
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(
    private val activity: MainActivity
) : AppNavigator {

    private val navController: NavController by lazy {
        activity.findNavController(R.id.nav_host_fragment)
    }

    override fun navigateToHome() {
        navController.navigate(R.id.action_loginFragment_to_homeFragment)
    }
}