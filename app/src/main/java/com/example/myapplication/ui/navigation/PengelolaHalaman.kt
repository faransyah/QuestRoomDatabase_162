package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.view.mahasiswa.DestinasiInsert
import com.example.myapplication.ui.view.mahasiswa.HomeMhsView
import com.example.myapplication.ui.view.mahasiswa.InsertMhsView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier : Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route) {
        composable(
            route = DestinasiHome.route
        ) {
            HomeMhsView(
                onDetailClick = { nim ->
                    navController.navigate("${DestinationDetail.route}/$nim")
                    println(
                        "PengelolaHalaman: nim = $nim"
                    )
                },
                onAddMhs = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier
            )
        }
    }
}