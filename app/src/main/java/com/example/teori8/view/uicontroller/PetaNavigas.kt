package com.example.teori8.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.teori8.view.DetailSiswaScreen
import com.example.teori8.view.EntrySiswaScreen
import com.example.teori8.view.HomeScreen
import com.example.teori8.view.route.DestinasiDetailSiswa
import com.example.teori8.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.teori8.view.route.DestinasiEntry
import com.example.teori8.view.route.DestinasiHome


@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier){
    HostNavigasi(navController = navController)
}

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinasiHome.route, modifier = modifier)
    {
        composable (route = DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = { navController.navigate(route = DestinasiEntry.route)},
                navigateToItemDetail = {navController.navigate(route = "${DestinasiDetailSiswa.route}/${it}")}
            )

        }
        composable (route = DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }
        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(name = itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateBack = {navController.navigateUp()}
            )
        }
    }
}


