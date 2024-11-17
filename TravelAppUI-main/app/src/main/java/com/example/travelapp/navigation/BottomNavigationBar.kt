package com.example.travelapp.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.travelapp.R

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val items = listOf("Profile", "Map", "Friends")

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.primary
    ) {
        items.forEachIndexed { index, title ->
            BottomNavigationItem(
                icon = {
                    when (title) {
                        "Map" -> Icon(
                            painter = painterResource(id = R.drawable.ic_map),
                            contentDescription = "Map"
                        )
                        "Friends" -> Icon(
                            painter = painterResource(id = R.drawable.ic_friends),
                            contentDescription = "Friends"
                        )
                        "Profile" -> Icon(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = "Profile"
                        )
                    }
                },
                label = { Text(title) },
                selected = selectedTab == index,
                onClick = { onTabSelected(index) }
            )
        }
    }
}
