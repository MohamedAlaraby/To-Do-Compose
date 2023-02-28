package com.example.to_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.util.Action
import com.example.to_docompose.util.Constants
import com.example.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToListScreen:(Action)->Unit){
    //here what we were doing in the xml file of the graph
    composable(
        //route is the arrow which take us from list to task and we will transfer an
        //argument ,we write the key and the type of the variable here only.
        route = TASK_SCREEN,
        arguments = listOf(navArgument(Constants.TASK_ARGUMENT_KEY){
            type= NavType.IntType
        } )
    ){

    }
}