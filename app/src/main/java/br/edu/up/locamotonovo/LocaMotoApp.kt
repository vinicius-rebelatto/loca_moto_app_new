package br.edu.up.locamotonovo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.up.locamotonovo.ui.screens.motos.MotosNavHost
import kotlinx.coroutines.launch

object MotoRotas {
    const val TELA_MOTOS = "Motos"
}

@Preview
@Composable
fun MotosNavDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: MotoRotas.TELA_MOTOS
    val isMotoScreenSelected = currentRoute == MotoRotas.TELA_MOTOS

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                navController = navController,
                isMotoScreenSelected = isMotoScreenSelected,
                closeDrawer = { coroutineScope.launch { drawerState.close() } }
            )
        },
        content = {
            LocaMotoNavHost(navController)
        }
    )
}

@Composable
fun DrawerContent(
    navController: NavHostController,
    isMotoScreenSelected: Boolean,
    closeDrawer: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
            .background(Color(0xFFC0E0FA)),
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = getBack(isMotoScreenSelected)
            ),
            onClick = {
                navController.navigate(MotoRotas.TELA_MOTOS)
                closeDrawer()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.checklist),
                contentDescription = "Tela Motos",
                modifier = Modifier.size(40.dp),
                tint = getTint(isMotoScreenSelected)
            )
            Text(
                color = getTint(isMotoScreenSelected),
                text = "Tarefas",
                fontSize = 30.sp,
                modifier = Modifier.padding(30.dp, 5.dp)
            )
        }
    }
}

@Composable
fun LocaMotoNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MotoRotas.TELA_MOTOS
    ) {
        composable(MotoRotas.TELA_MOTOS) {
            MotosNavHost(rememberDrawerState(DrawerValue.Closed))
        }
    }
}

fun getTint(selected: Boolean): Color {
    return if (selected) Color.Black else Color.DarkGray
}

fun getBack(selected: Boolean): Color {
    return if (selected) Color.Yellow else Color.Transparent
}
