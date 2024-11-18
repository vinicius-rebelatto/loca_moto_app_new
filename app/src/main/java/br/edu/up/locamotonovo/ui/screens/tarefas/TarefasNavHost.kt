package br.edu.up.locamotonovo.ui.screens.tarefas

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.locamotonovo.ui.screens.tarefas.afazeres.AfazeresNavHost
import br.edu.up.locamotonovo.ui.screens.util.LocaMotoNavBar

object MotosRotas {
    const val TelaMotos = "motos"
}

@Composable
fun MotosNavHost(state: DrawerState) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MotosRotas.TelaMotos
    ) {
        composable(MotosRotas.TelaMotos) {
            AfazeresNavHost(state, { LocaMotoNavBar(navController) })
        }
    }
}
