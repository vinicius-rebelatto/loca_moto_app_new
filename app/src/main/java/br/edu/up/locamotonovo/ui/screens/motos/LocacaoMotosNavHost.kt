package br.edu.up.locamotonovo.ui.screens.motos

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.locamotonovo.ui.model.Moto

object TelaUmARotas {
    val LISTAR_MOTO_ROUTE = "listar_motos"
    val VISUALIZAR_MOTO_ROUTE = "visualizar_moto"
    val EDITAR_MOTO_ROUTE = "editar_moto"
    val INCLUIR_MOTO_ROUTE = "incluir_moto"
}

@Composable
fun LocacaoMotosNavHost(state: DrawerState) {
    val navController = rememberNavController()
    val motos = remember { mutableStateListOf<Moto>() } // State should be remembered here

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
