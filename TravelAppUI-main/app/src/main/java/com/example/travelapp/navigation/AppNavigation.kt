package com.example.travelapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.travelapp.components.TravelAppTopBar
import com.example.travelapp.screens.*
import com.example.travelapp.ui.theme.TravelAppTheme

enum class Routes {
    Register, Login, Home, Bali, Paris, Singapore, Profile, Map, Friends
}

@Composable
fun AppNavigation() {
    val navCtrl = rememberNavController()
    val currBackStack by navCtrl.currentBackStackEntryAsState()
    val currDest = currBackStack?.destination?.route.toString()

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
                ) TravelAppTopBar(logout = {
                    navCtrl.navigate(Routes.Login.name) {
                        popUpTo(currDest) { inclusive = true }
                    }
                })
            },
            bottomBar = {
                if (currDest in listOf(
                        Routes.Home,
                        Routes.Profile,
                        Routes.Map,
                        Routes.Friends
                    ).map { it.name }
                ) BottomNavigationBar(
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
                        HomeScreen(goToPlace = { place -> navCtrl.navigate(place) })
                    }
                    composable(Routes.Bali.name) { BaliScreen() }
                    composable(Routes.Paris.name) { ParisScreen() }
                    composable(Routes.Singapore.name) { SingaporeScreen() }
                    composable(Routes.Profile.name) { ProfileScreen() }
                    composable(Routes.Map.name) { MapScreen() }
                    composable(Routes.Friends.name) { FriendsScreen() }
                }
            }
        }
    }
}
