package br.edu.up.locamotonovo.ui.screens.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.up.locamotonovo.ui.screens.tarefas.MotosRotas

@Composable
fun LocaMotoNavBar(navController: NavController){

    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {
                navController.navigate(MotosRotas.TelaMotos)
            },
            icon = {
                Icon(imageVector = Icons.Filled.DateRange,
                    contentDescription = "d",
                    modifier = Modifier.size(40.dp))
            },
            label = { Text(text = "Motos")}
        )

        /*NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(TarefasRotas.TelaNotas)
            },
            icon = {
                Icon(imageVector = Icons.Filled.Call,
                    contentDescription = "c",
                    modifier = Modifier.size(40.dp))
            },
            label = { Text(text = "Anotações")}
        )*/
    }
}

@Composable
fun PlannerBottomBar(){
    BottomAppBar(
        containerColor = Color(0x752196F3)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = Icons.Filled.DateRange,
                contentDescription = "d",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(50.dp))
            Icon(imageVector = Icons.Filled.Email,
                contentDescription = "e",
                modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(50.dp))
            Icon(imageVector = Icons.Filled.Call,
                contentDescription = "c",
                modifier = Modifier.size(40.dp))
        }
    }
}