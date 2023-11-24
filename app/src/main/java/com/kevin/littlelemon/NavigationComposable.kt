package com.kevin.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import android.content.Context
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.kevin.littlelemon.screens.Home
import com.kevin.littlelemon.screens.Onboarding
import com.kevin.littlelemon.screens.Profile

@ExperimentalGlideComposeApi
@Composable
fun NavigationComposable(context: Context, navController: NavController) {
    val navController = rememberNavController()
    val sharedPreferences =
        context.getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE)
    val isLoggedIn = sharedPreferences.getBoolean(Constants.LOGGED_IN, false)
    NavHost(
        navController = navController,
        startDestination =
        if (isLoggedIn) {
            Home.route
        } else {
            Onboarding.route
        }
    ) {
        composable(Onboarding.route) {
            Onboarding(context, navController)
        }
        composable(Home.route) {
            Home(navController = navController)
        }
        composable(Profile.route) {
            Profile(context, navController)
        }
    }
}