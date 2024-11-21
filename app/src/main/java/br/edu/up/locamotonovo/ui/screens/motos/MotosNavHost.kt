package br.edu.up.locamotonovo.ui.screens.motos

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.locamotonovo.ui.model.Moto

@Composable
fun MotosNavHost(state: DrawerState) {
    val navController = rememberNavController()
    val motos = remember { mutableStateListOf<Moto>() }

    NavHost(
        navController = navController,
        startDestination = TelaUmARotas.LISTAR_MOTO_ROUTE
    ) {
        composable(TelaUmARotas.LISTAR_MOTO_ROUTE) {
            ListarMotosScreen(state, navController, motos)
        }
        composable(TelaUmARotas.INCLUIR_MOTO_ROUTE) {
            CriarOuEditarMotoScreen(state, navController, { motos.add(it) })
        }
    }
}