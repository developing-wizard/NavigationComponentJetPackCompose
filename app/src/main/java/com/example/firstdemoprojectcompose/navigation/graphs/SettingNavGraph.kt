package com.example.firstdemoprojectcompose.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.firstdemoprojectcompose.navigation.Graph
import com.example.firstdemoprojectcompose.navigation.SettingRouteScreen
import com.example.firstdemoprojectcompose.navigation.screens.setting.SettingDetailScreen


fun NavGraphBuilder.settingNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.SettingGraph,
        startDestination = SettingRouteScreen.SettingDetail.route
    ) {
        composable(route = SettingRouteScreen.SettingDetail.route) {
            SettingDetailScreen(navController = rootNavController)
        }
    }

}