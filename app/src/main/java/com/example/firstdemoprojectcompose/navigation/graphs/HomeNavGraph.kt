package com.example.firstdemoprojectcompose.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.firstdemoprojectcompose.navigation.Graph
import com.example.firstdemoprojectcompose.navigation.HomeRouteScreen
import com.example.firstdemoprojectcompose.navigation.SettingRouteScreen
import com.example.firstdemoprojectcompose.navigation.screens.home.HomeDetail
import com.example.firstdemoprojectcompose.navigation.screens.setting.SettingDetailScreen

fun NavGraphBuilder.homeNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.HomeGraph,
        startDestination = HomeRouteScreen.HomeDetail.route
    ) {
        composable(route =  HomeRouteScreen.HomeDetail.route) {
            HomeDetail(navController = rootNavController)
        }
    }
    }