package br.edu.up.locamotonovo.ui.screens.motos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(text = "Modelo: ${moto.modelo}", fontSize = 24.sp)
                Text(text = "Cor: ${moto.cor}", fontSize = 20.sp)
                Text(text = "Valor Locação: R\$ ${moto.valorlocacao}", fontSize = 20.sp)
                Text(text = "Descrição: ${moto.descricao}", fontSize = 16.sp)

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        // Lógica para alugar a moto
                        navController.navigate(TelaUmARotas.LISTAR_MOTO_ROUTE)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Alugar Moto")
                }
            }
        }
    )
}
