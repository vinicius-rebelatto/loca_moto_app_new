package br.edu.up.locamotonovo.ui.screens.projetos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import br.edu.up.locamotonovo.ui.screens.util.PlannerBottomBar
import br.edu.up.locamotonovo.ui.screens.util.PlannerTopBar


@Composable
fun TelaProjetos(state: DrawerState){
    Scaffold(
        topBar = { PlannerTopBar(state) },
        content = { p -> ConteudoDaPaginaDois(Modifier.padding(p)) },
        floatingActionButton = {  },
        bottomBar = { PlannerBottomBar() }
    )
//    { p -> ConteudoDaPagina(Modifier.padding(p)) }
}

@Composable
fun ConteudoDaPaginaDois(modifier: Modifier){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela projetos", fontSize = 50.sp)
    }
}
