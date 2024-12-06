package com.example.travelapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Message(val sender: String, val content: String)

@Composable
fun ChatScreen(friendId: Int, friendName: String, navController: NavController) {
    var message by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<Message>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Добавляем AppBar с кнопкой "Назад"
        TopAppBar(
            title = { Text("Chat with $friendName") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )

        // История сообщений
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true // Для отображения последних сообщений внизу
        ) {
            items(messages) { message ->
                MessageItem(message)
            }
        }

        // Поле для ввода сообщения
        Row(Modifier.fillMaxWidth()) {
            TextField(
                value = message,
                onValueChange = { message = it },
                placeholder = { Text("Type a message...") },
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    if (message.isNotEmpty()) {
                        messages.add(Message(sender = "You", content = message)) // Добавляем новое сообщение
                        message = "" // Очищаем поле ввода
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Send")
            }
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = message.sender,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Text(text = message.content, fontSize = 16.sp)
    }
}
