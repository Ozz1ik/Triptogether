package com.example.travelapp.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.travelapp.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size



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
                            contentDescription = "Map",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp) // Фиксируем размер
                        )
                        "Friends" -> Icon(
                            painter = painterResource(id = R.drawable.ic_friends),
                            contentDescription = "Friends",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp)
                        )
                        "Profile" -> Icon(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = "Profile",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp)
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
