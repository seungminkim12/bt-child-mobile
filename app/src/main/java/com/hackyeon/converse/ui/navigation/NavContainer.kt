package com.hackyeon.converse.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hackyeon.converse.ui.screen.LoginScreen
import com.hackyeon.converse.ui.screen.MainScreen

@Composable
fun NavContainer(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavState.Main.value
    ) {
        composable(NavState.Main.value) { MainScreen() }
        composable(NavState.Login.value) { LoginScreen() }
    }
}