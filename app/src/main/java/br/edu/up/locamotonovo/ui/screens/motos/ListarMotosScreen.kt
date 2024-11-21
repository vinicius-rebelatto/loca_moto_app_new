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
import androidx.compose.material3.Button
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
import androidx.compose.runtime.LaunchedEffect
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun ListarMotosScreen(
    state: DrawerState,
    navController: NavController,
    motos: SnapshotStateList<Moto>
) {
    val db = Firebase.firestore

    // Recuperar motos do Firestore em tempo real
    LaunchedEffect(Unit) {
        val motosRef = db.collection("motos")
        motosRef.addSnapshotListener { snapshot, error ->
            if (error != null) {
                // Tratar erro
                return@addSnapshotListener
            }
            snapshot?.let {
                motos.clear()
                for (document in it.documents) {
                    val moto = document.toObject(Moto::class.java)
                    moto?.let { motos.add(it) }
                }
            }
        }
    }

    Scaffold(
        topBar = { PlannerTopBar(state, navController) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Lista de Motos",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                if (motos.isEmpty()) {
                    Text(
                        text = "Nenhuma moto cadastrada.",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                } else {
                    LazyColumn {
                        items(motos) { moto ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Text(text = "Modelo: ${moto.modelo}", fontSize = 20.sp)
                                Text(text = "Cor: ${moto.cor}", fontSize = 18.sp)
                                Text(text = "Valor Locação: R\$ ${moto.valorlocacao}", fontSize = 18.sp)
                                Text(text = "Descrição: ${moto.descricao}", fontSize = 16.sp)

                                Spacer(modifier = Modifier.height(8.dp))

                                Button(onClick = {
                                    // Navegar para a tela de visualização passando a moto selecionada
                                    navController.navigate("visualizar_moto/${moto.modelo}")
                                }) {
                                    Text("Visualizar")
                                }
                            }
                        }
                    }


                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(TelaUmARotas.INCLUIR_MOTO_ROUTE)
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Adicionar Moto",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    )
}
