package com.example.firstdemoprojectcompose.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstdemoprojectcompose.navigation.Graph
import com.example.firstdemoprojectcompose.navigation.screens.main.MainScreen

@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()
    NavHost(
        navController = rootNavController,
        route = Graph.RootGraph,
        startDestination = Graph.AuthGraph
    ) {
        authNavGraph(rootNavController)
        composable(route = Graph.MainScreenGraph){
            MainScreen(rootNavController)
        }
        homeNavGraph(rootNavController)
        notificationNavGraph(rootNavController)
        settingNavGraph(rootNavController)
    }
}