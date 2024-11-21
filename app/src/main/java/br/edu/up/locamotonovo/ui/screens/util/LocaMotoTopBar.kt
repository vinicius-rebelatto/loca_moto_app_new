package br.edu.up.locamotonovo.ui.screens.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.locamotonovo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlannerTopBar(state: DrawerState, navController: NavController) {

    val scope = rememberCoroutineScope()

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 35.sp,
                fontWeight = FontWeight(
                    integerResource(id = R.integer.peso)
                ),
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.purple_500)
        ),
        navigationIcon = {
            // Botão de voltar, se estiver na tela com possibilidade de navegação
            IconButton(onClick = {
                navController.popBackStack() // Volta para a tela anterior
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White // Garantir que o ícone tenha a cor certa
                )
            }
        }
    )
}
