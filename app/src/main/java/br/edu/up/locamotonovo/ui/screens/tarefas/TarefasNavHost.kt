package br.edu.up.locamotonovo.ui.screens.tarefas

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.locamotonovo.ui.screens.tarefas.afazeres.AfazeresNavHost
import br.edu.up.locamotonovo.ui.screens.tarefas.notas.TelaNotas
import br.edu.up.locamotonovo.ui.screens.tarefas.rotina.TelaRotina
import br.edu.up.locamotonovo.ui.screens.util.PlannerNavBar

object TarefasRotas {
    val TelaAfazeres = "afazeres"
    val TelaRotina = "rotina"
    val TelaNotas = "notas"
}

@Composable
fun TarefasNavHost(state: DrawerState) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TarefasRotas.TelaAfazeres
    ) {
        composable(TarefasRotas.TelaAfazeres) {
            AfazeresNavHost(state, { PlannerNavBar(navController) })
        }
        composable(TarefasRotas.TelaRotina) {
            TelaRotina(state, { PlannerNavBar(navController) })
        }
        composable(TarefasRotas.TelaNotas) {
            TelaNotas(state, { PlannerNavBar(navController) })
        }
    }
}
