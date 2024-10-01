package com.example.firstdemoprojectcompose.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.firstdemoprojectcompose.navigation.AuthRouteScreen
import com.example.firstdemoprojectcompose.navigation.Graph
import com.example.firstdemoprojectcompose.navigation.screens.auth.ForgotPasswordScreen
import com.example.firstdemoprojectcompose.navigation.screens.auth.LoginScreen
import com.example.firstdemoprojectcompose.navigation.screens.auth.RegisterScreen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(route = Graph.AuthGraph, startDestination = AuthRouteScreen.Login.route) {
        composable(route = AuthRouteScreen.Login.route) {
            LoginScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.Signup.route) {
            RegisterScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.Forgot.route) {
            ForgotPasswordScreen(navController = rootNavController)
        }
    }

}