package com.example.firstdemoprojectcompose.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.firstdemoprojectcompose.navigation.Graph
import com.example.firstdemoprojectcompose.navigation.NotificationRouteScreen
import com.example.firstdemoprojectcompose.navigation.screens.notification.NotificationDetailScreen

fun NavGraphBuilder.notificationNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.NotificationGraph,
        startDestination = NotificationRouteScreen.NotificationDetail.route
    ) {
        composable(route = NotificationRouteScreen.NotificationDetail.route) {
            NotificationDetailScreen(navController = rootNavController)
        }
    }

}