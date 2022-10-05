package com.example.login.form.ui

sealed class NavRoutes(val route: String) {
    object Login : NavRoutes("login")
    object List : NavRoutes("list")
    object Detail : NavRoutes("detail")
}