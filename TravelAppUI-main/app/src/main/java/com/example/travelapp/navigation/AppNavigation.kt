package com.example.travelapp.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.travelapp.components.TravelAppTopBar
import com.example.travelapp.screens.*
import com.example.travelapp.ui.theme.TravelAppTheme
import com.example.travelapp.screens.Trip


// Модель данных для путешествия
data class Trip(
    val destination: String,
    val duration: Int,
    val numberOfPeople: Int
)

enum class Routes {
    Register, Login, Home, Bali, Paris, Singapore, Profile, Map, Friends, Chat, CreateTrip
}
@Composable
fun AppNavigation() {
    val navCtrl = rememberNavController()
    val currBackStack by navCtrl.currentBackStackEntryAsState()
    val currDest = currBackStack?.destination?.route.toString()

    // Список для сохранения путешествий (объявлен внутри Composable)
    val trips = remember { mutableStateListOf<Trip>() }

    TravelAppTheme {
        var selectedTab by remember { mutableStateOf(0) }

        Scaffold(
            topBar = {
                if (currDest in listOf(
                        Routes.Home,
                        Routes.Bali,
                        Routes.Paris,
                        Routes.Singapore,
                        Routes.Profile,
                        Routes.Map,
                        Routes.Friends
                    ).map { it.name }
                ) {
                    TravelAppTopBar(
                        logout = {
                            navCtrl.navigate(Routes.Login.name) {
                                popUpTo(currDest) { inclusive = true }
                            }
                        },
                        onBackPressed = {
                            navCtrl.popBackStack()
                        }
                    )
                }
            },
            bottomBar = {
                if (currDest in listOf(
                        Routes.Home,
                        Routes.Profile,
                        Routes.Map,
                        Routes.Friends
                    ).map { it.name }
                ) {
                    BottomNavigationBar(
                        selectedTab = selectedTab,
                        onTabSelected = { index ->
                            selectedTab = index
                            when (index) {
                                0 -> navCtrl.navigate(Routes.Profile.name)
                                1 -> navCtrl.navigate(Routes.Map.name)
                                2 -> navCtrl.navigate(Routes.Friends.name)
                            }
                        }
                    )
                }
            }
        ) { contentPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                color = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface
            ) {
                NavHost(navController = navCtrl, startDestination = Routes.Login.name) {
                    composable(Routes.Register.name) {
                        RegisterScreen(goToLogin = {
                            navCtrl.navigate(Routes.Login.name) {
                                popUpTo(Routes.Register.name) { inclusive = true }
                            }
                        })
                    }
                    composable(Routes.Login.name) {
                        LoginScreen(
                            goToHome = { navCtrl.navigate(Routes.Home.name) { popUpTo(Routes.Login.name) { inclusive = true } } },
                            goToRegister = { navCtrl.navigate(Routes.Register.name) { popUpTo(Routes.Login.name) { inclusive = true } } }
                        )
                    }
                    composable(Routes.Home.name) {
                        HomeScreen(
                            goToPlace = { place -> navCtrl.navigate(place) },
                            trips = trips, // Передаем список путешествий в HomeScreen
                            goToCreateTrip = { navCtrl.navigate(Routes.CreateTrip.name) },
                            selectTrip = { trip ->
                                // Логика для выбора поездки, например, добавление её в список
                                trips.add(trip)
                            }
                        )
                    }
                    composable(Routes.Bali.name) { BaliScreen() }
                    composable(Routes.Paris.name) { ParisScreen() }
                    composable(Routes.Singapore.name) { SingaporeScreen() }
                    composable(Routes.Profile.name) {
                        ProfileScreen(onLogout = {
                            navCtrl.navigate(Routes.Login.name) {
                                popUpTo(Routes.Profile.name) { inclusive = true }
                            }
                        })
                    }
                    composable(Routes.Friends.name) {
                        FriendsScreen(navController = navCtrl)
                    }
                    composable(
                        route = "${Routes.Chat.name}/{friendId}/{friendName}",
                        arguments = listOf(
                            navArgument("friendId") { type = NavType.IntType },
                            navArgument("friendName") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val friendId = backStackEntry.arguments?.getInt("friendId") ?: 0
                        val friendName = backStackEntry.arguments?.getString("friendName") ?: "Unknown"
                        ChatScreen(friendId, friendName, navCtrl)
                    }
                    composable(Routes.Map.name) {
                        MapScreen(onBackPressed = { navCtrl.popBackStack() })
                    }
                    composable(Routes.CreateTrip.name) {
                        CreateTripScreen(
                            navController = navCtrl,
                            onSaveTrip = { trip -> trips.add(trip) } // Сохраняем новое путешествие
                        )
                    }
                }
            }
        }
    }
}
