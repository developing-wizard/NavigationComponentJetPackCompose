package com.example.firstdemoprojectcompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val yellow = Color(0xFFF3A024)
val black = Color(0xFF090909)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onClick: (NavigationItem) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(yellow, black) // Gradient colors
                )
            )
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ) {
            items.forEachIndexed { index, navigationItem ->
                NavigationBarItem(
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color.White,
                        selectedIconColor = yellow,
                        selectedTextColor = Color.White,
                        indicatorColor = black
                    ),
                    selected = currentRoute == navigationItem.route,
                    onClick = { onClick(navigationItem) },
                    icon = {
                        BadgedBox(badge = {
                            if (navigationItem.badgeCount != null) {
                                Badge {
                                    Text(text = navigationItem.badgeCount.toString())
                                }
                            } else if (navigationItem.hasBadgeDot) {
                                Badge()
                            }
                        }) {
                            Icon(
                                imageVector = if (currentRoute == navigationItem.route) {
                                    navigationItem.selectedIcon
                                } else {
                                    navigationItem.unSelectedIcon
                                }, contentDescription = navigationItem.title
                            )
                        }
                    }, label = {
                        Text(text = navigationItem.title)
                    },
                    alwaysShowLabel = false
                )
            }
        }
    }
}