package br.edu.up.locamotonovo.ui.screens.motos

import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import br.edu.up.locamotonovo.R
import br.edu.up.locamotonovo.ui.model.Moto
import br.edu.up.locamotonovo.ui.screens.util.PlannerTopBar



@Composable
fun VisualizarMotoScreen(
    state: DrawerState,
    navController: NavController,
    moto: Moto
) {
    Scaffold(
        topBar = { PlannerTopBar(state, navController) },
        content = { paddingValues ->
            // The Column element goes here
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.moto),
                contentDescription = "Foto da moto",
                modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Modelo: ${moto.modelo}", fontSize = 24.sp)
                Text(text = "Modelo: ${moto.modelo}", fontSize = 24.sp)
                Text(text = "Cor: ${moto.cor}", fontSize = 20.sp)
                Text(text = "Valor Locação: R\$ ${moto.valorlocacao}", fontSize = 20.sp)
                Text(text = "Descrição: ${moto.descricao}", fontSize = 16.sp)

                Spacer(modifier = Modifier.height(20.dp))

                var showDialog by remember { mutableStateOf(false) }
                var showSuccessDialog by remember { mutableStateOf(false) }

                Button(onClick = { showDialog = true }) {
                    Text("Alugar Moto")
                }

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Confirmação") },
                        text = { Text("Tem certeza que deseja alugar esta moto?") },
                        confirmButton = {
                            Button(onClick = {
                                // Lógica para alugar a moto
                                showDialog = false
                                showSuccessDialog = true
                            }) {
                                Text("Sim")
                            }
                        },
                        dismissButton = {
                            Button(onClick = { showDialog = false }) {
                                Text("Não")
                            }
                        }
                    )
                }
            }
        }
    )
}
