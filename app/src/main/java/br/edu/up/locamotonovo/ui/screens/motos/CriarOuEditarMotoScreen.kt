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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun CriarOuEditarMotoScreen(
    state: DrawerState,
    navController: NavController,
    adicionarMoto: (Moto) -> Unit
) {
    var modelo by remember { mutableStateOf("") }
    var cor by remember { mutableStateOf("") }
    var valorlocacao by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    var isSaving by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = { PlannerTopBar(state, navController) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
            ) {
                Text(text = "Modelo", fontSize = 20.sp)
                OutlinedTextField(
                    value = modelo,
                    onValueChange = { modelo = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text("Digite o modelo") }
                )
                Text(text = "Cor", fontSize = 20.sp)
                OutlinedTextField(
                    value = cor,
                    onValueChange = { cor = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text("Digite a cor") }
                )
                Text(text = "Valor Locação (R\$)", fontSize = 20.sp)
                OutlinedTextField(
                    value = valorlocacao,
                    onValueChange = { valorlocacao = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text("Digite o valor da locação") }
                )
                Text(text = "Descrição", fontSize = 20.sp)
                OutlinedTextField(
                    value = descricao,
                    onValueChange = { descricao = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    placeholder = { Text("Digite uma descrição") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                errorMessage?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        color = androidx.compose.ui.graphics.Color.Red
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (modelo.isBlank() || cor.isBlank() || valorlocacao.isBlank()) {
                        errorMessage = "Todos os campos devem ser preenchidos."
                        return@FloatingActionButton
                    }

                    val valorLocacaoDouble = valorlocacao.toDoubleOrNull()
                    if (valorLocacaoDouble == null || valorLocacaoDouble <= 0) {
                        errorMessage = "Valor da locação inválido."
                        return@FloatingActionButton
                    }

                    isSaving = true
                    errorMessage = null

                    val novaMoto = Moto(
                        modelo = modelo,
                        cor = cor,
                        valorlocacao = valorLocacaoDouble,
                        descricao = descricao
                    )

                    val db = Firebase.firestore
                    db.collection("motos")
                        .add(novaMoto)
                        .addOnSuccessListener {
                            navController.navigate(TelaUmARotas.LISTAR_MOTO_ROUTE)
                            adicionarMoto(novaMoto)
                        }
                        .addOnFailureListener {
                            errorMessage = "Erro ao salvar a moto. Tente novamente."
                        }
                        .addOnCompleteListener {
                            isSaving = false
                        }
                },
                modifier = Modifier.size(60.dp) // Controla o tamanho do botão
            ) {
                if (isSaving) {
                    Text("Salvando...")
                } else {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Salvar",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    )
}

