package com.example.login.form

import DetailScreen
import com.example.login.form.ui.screens.ListScreen
import LoginScreen
import com.example.login.form.ui.screens.SplashScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.ui.unit.IntOffset
import com.example.login.form.ui.NavRoutes
import com.example.login.form.ui.theme.LoginFormTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberAnimatedNavController()

            val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioMediumBouncy)

            LoginFormTheme {
                AnimatedNavHost(
                    navController = navController,
                    startDestination = NavRoutes.Splash.route,
                ) {
                    composable(NavRoutes.Splash.route) {
                        SplashScreen(navController = navController)
                    }
                    composable(
                        NavRoutes.Login.route,
                        enterTransition = {
                            slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = springSpec)
                        },
                        exitTransition = {
                            slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = springSpec)
                        },
                        popEnterTransition = {
                            slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = springSpec)
                        },
                        popExitTransition = {
                            slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = springSpec)
                        }
                    ) {
                        LoginScreen(navController = navController)
                    }
                    composable(
                        NavRoutes.List.route,
                        enterTransition = {
                            slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = springSpec)
                        },
                        exitTransition = {
                            slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = springSpec)
                        },
                        popEnterTransition = {
                            slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = springSpec)
                        },
                        popExitTransition = {
                            slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = springSpec)
                        }
                    ) {
                        ListScreen(navController = navController)
                    }
                    composable(
                        NavRoutes.Detail.route + "/{id}",
                        enterTransition = {
                            slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = springSpec)
                        },
                        exitTransition = {
                            slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = springSpec)
                        },
                        popEnterTransition = {
                            slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = springSpec)
                        },
                        popExitTransition = {
                            slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = springSpec)
                        }
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id")
                        DetailScreen(navController = navController, id)
                    }
                }
            }
        }
    }
}



