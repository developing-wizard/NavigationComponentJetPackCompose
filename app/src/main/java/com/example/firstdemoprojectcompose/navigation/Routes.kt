package com.example.firstdemoprojectcompose.navigation

object Graph{
    const val RootGraph = "rootgraph"
    const val AuthGraph = "authgraph"
    const val MainScreenGraph = "mainscreengraph"
    const val NotificationGraph = "notificationgraph"
    const val HomeGraph = "homegraph"
    const val SettingGraph = "settinggraph"
}

sealed class AuthRouteScreen(val route : String ){
    object Login : AuthRouteScreen("login")
    object Signup : AuthRouteScreen("signUp")
    object Forgot : AuthRouteScreen("forgot")
}
sealed class MainRouteScreen(val route : String ){
    object Home : MainRouteScreen("home")
    object Profile : MainRouteScreen("profile")
    object Notification : MainRouteScreen("notification")
    object Setting : MainRouteScreen("setting")
}

sealed class HomeRouteScreen(val route :String){
    object HomeDetail:HomeRouteScreen("homeDetail")
}
sealed class NotificationRouteScreen(val route : String ){
    object NotificationDetail : NotificationRouteScreen("notificationDetail")
}

sealed class SettingRouteScreen(val route : String ){
    object SettingDetail : SettingRouteScreen("settingDetail")
}