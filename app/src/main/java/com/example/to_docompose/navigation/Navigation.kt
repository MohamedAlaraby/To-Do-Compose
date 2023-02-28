package com.example.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_docompose.navigation.destinations.listComposable
import com.example.to_docompose.navigation.destinations.taskComposable
import com.example.to_docompose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navController: NavHostController) {
    //this variable will keep track of all our composables.
    val screen = remember(navController) {
        Screens(navController)
    }
    //in the nav host we define our nav graph
    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(navigateToTaskScreen =screen.task)
        taskComposable (navigateToListScreen =screen.list )

    }

}