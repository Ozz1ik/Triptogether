package com.example.travelapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Friend(val id: Int, val name: String, val isActive: Boolean)

@Composable
fun FriendsScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val friends = remember {
        listOf(
            Friend(1, "Алиса", true),
            Friend(2, "Егор", false),
            Friend(3, "Олег", true),
            Friend(4, "Диана", false),
            Friend(5, "Игнат", true)
        )
    }

    val filteredFriends = friends.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search by name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(filteredFriends) { friend ->
                FriendItem(friend) {
                    navController.navigate("chat/${friend.id}/${friend.name}")
                }
            }
        }
    }
}

@Composable
fun FriendItem(friend: Friend, onMessageClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { /* Add additional actions if needed */ }
            .padding(8.dp)
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                text = friend.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = if (friend.isActive) "Online" else "Offline",
                color = if (friend.isActive) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
            )
        }
        Button(
            onClick = onMessageClick,
            modifier = Modifier.alignByBaseline()
        ) {
            Text("Message")
        }
    }
}
