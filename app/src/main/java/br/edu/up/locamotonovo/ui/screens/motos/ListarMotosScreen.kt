package br.edu.up.locamotonovo.ui.screens.motos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.locamotonovo.ui.model.Moto
import br.edu.up.locamotonovo.ui.screens.util.PlannerTopBar

@Composable
fun ListarMotosScreen(
    state: DrawerState,
    navController: NavController,
    motos: SnapshotStateList<Moto> // Receber a lista de motos aqui
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
                LazyColumn {
                    items(motos) { moto ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Text(
                                text = moto.titulo,
                                fontSize = 20.sp,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = "R\$ ${moto.valorlocacao}",
                                fontSize = 20.sp,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                FloatingActionButton(onClick = {
                    navController.navigate(TelaUmARotas.INCLUIR_MOTO_ROUTE)
                }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "+",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    )
}
