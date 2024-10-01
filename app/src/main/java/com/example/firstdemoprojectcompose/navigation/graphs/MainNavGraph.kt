package com.example.firstdemoprojectcompose.navigation.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firstdemoprojectcompose.navigation.Graph
import com.example.firstdemoprojectcompose.navigation.MainRouteScreen
import com.example.firstdemoprojectcompose.navigation.screens.main.HomeScreen
import com.example.firstdemoprojectcompose.navigation.screens.main.NotificationScreen
import com.example.firstdemoprojectcompose.navigation.screens.main.ProfileScreen
import com.example.firstdemoprojectcompose.navigation.screens.main.SettingScreen

@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = homeNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainRouteScreen.Home.route
    ) {
        composable(route = MainRouteScreen.Home.route) {
            HomeScreen(rootNavController,innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.Profile.route) {
            ProfileScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.Notification.route) {
            NotificationScreen(navController = rootNavController, innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.Setting.route) {
            SettingScreen(navController = rootNavController, innerPadding = innerPadding)
        }
    }
}

