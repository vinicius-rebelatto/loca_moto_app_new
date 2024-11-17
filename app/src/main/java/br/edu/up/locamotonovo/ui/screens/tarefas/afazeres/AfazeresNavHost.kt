package br.edu.up.locamotonovo.ui.screens.tarefas.afazeres

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.locamotonovo.ui.screens.util.PlannerTopBar

object TelaUmARotas {
    val LISTAR_AFAZARES_ROUTE = "listar_afazeres"
    val VISUALIZAR_AFAZER_ROUTE = "visualizar_afazer"
    val EDITAR_AFAZER_ROUTE = "editar_afazer"
    val INCLUIR_AFAZER_ROUTE = "incluir_afazer"
}

@Composable
fun AfazeresNavHost(state: DrawerState, bottonNavBar: @Composable () -> Unit) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TelaUmARotas.LISTAR_AFAZARES_ROUTE
    ) {
        composable(TelaUmARotas.LISTAR_AFAZARES_ROUTE) {
            ListarAfazeresScreen(state, navController, bottonNavBar)
        }
        composable(TelaUmARotas.VISUALIZAR_AFAZER_ROUTE) {

        }
        composable(TelaUmARotas.EDITAR_AFAZER_ROUTE) {

        }
        composable(TelaUmARotas.INCLUIR_AFAZER_ROUTE) {
            CriarOuEditarAfazerScreen(state, navController, bottonNavBar)
        }
    }

}

@Composable
fun CriarOuEditarAfazerScreen(
    state: DrawerState,
    navController: NavController,
    bottonNavBar: @Composable () -> Unit
) {
    Scaffold(
        topBar = { PlannerTopBar(state) },
        content = { iPad ->
            iPad
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(130.dp))
                Text(text = "Título", fontSize = 20.sp)
                OutlinedTextField(
                    value = "", onValueChange = {

                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Descrição", fontSize = 20.sp)
                OutlinedTextField(
                    value = "", onValueChange = {

                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

        },
        floatingActionButton = {

            FloatingActionButton(onClick = {
                navController.navigate(TelaUmARotas.INCLUIR_AFAZER_ROUTE)
            }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "x",
                    modifier = Modifier.size(40.dp)
                )
            }

        }
    )
}

data class Afazer(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    var id: Int? = null
)

@Composable
fun ListarAfazeresScreen(
    state: DrawerState,
    navController: NavController,
    bottonNavBar: @Composable () -> Unit
) {
    var afazeres = remember {
        mutableStateListOf(
            Afazer(
                titulo = "Afazer 1",
                descricao = "Descricao 1",
                concluido = false,
                id = 1
            ),
            Afazer(
                titulo = "Afazer 2",
                descricao = "Descricao 2",
                concluido = false,
                id = 2
            ),
            Afazer(
                titulo = "Afazer 3",
                descricao = "Descricao 3",
                concluido = false,
                id = 3
            )
        )
    }

    Scaffold(
        topBar = { PlannerTopBar(state) },
        content = { iPad ->
            iPad
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(130.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(afazeres) { afazer ->
                        Row {
                            Checkbox(checked = afazer.concluido, onCheckedChange = {
                                //todo
                            })
                            Text(text = afazer.titulo, fontSize = 50.sp)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
        },
        floatingActionButton = {

            FloatingActionButton(onClick = {
                navController.navigate(TelaUmARotas.INCLUIR_AFAZER_ROUTE)
            }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "+",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        bottomBar = { bottonNavBar() }
    )
}
