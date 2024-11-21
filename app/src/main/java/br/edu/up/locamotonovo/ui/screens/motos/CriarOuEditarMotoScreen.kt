package br.edu.up.locamotonovo.ui.screens.motos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.locamotonovo.ui.model.Moto
import br.edu.up.locamotonovo.ui.screens.util.PlannerTopBar

@Composable
fun CriarOuEditarMotoScreen(
    state: DrawerState,
    navController: NavController,
    adicionarMoto: (Moto) -> Unit // Receber a função para adicionar moto
) {
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var valorlocacao by remember { mutableStateOf("") }

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
                    value = titulo,
                    onValueChange = { titulo = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Descrição", fontSize = 20.sp)
                OutlinedTextField(
                    value = descricao,
                    onValueChange = { descricao = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Valor Locação", fontSize = 20.sp)
                OutlinedTextField(
                    value = valorlocacao,
                    onValueChange = { valorlocacao = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val novaMoto = Moto(
                    titulo = titulo,
                    descricao = descricao,
                    valorlocacao = valorlocacao.toDoubleOrNull() ?: 0.0
                )
                adicionarMoto(novaMoto) // Adicionando a nova moto
                navController.navigate(TelaUmARotas.LISTAR_MOTO_ROUTE)
            }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Salvar",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    )
}
