package br.edu.up.locamotonovo.ui.screens.util

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
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
import br.edu.up.locamotonovo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlannerTopBar(state: DrawerState){

    val scope = rememberCoroutineScope()
    //TopAppBar(
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name),
                fontSize = 35.sp,
                fontWeight = FontWeight(
                    integerResource(id = R.integer.peso)
                ),
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.purple_500)
        )
    )
}
