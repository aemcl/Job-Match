package com.example.jobmatch.employer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jobmatch.Routes

@Composable
fun JobCredentials(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Add Credentials")

        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "Add",
            tint = Color.LightGray,
            modifier = Modifier
                .size(100.dp)
                .clickable { navController.navigate(Routes.workinformation) }
        )

        Button(onClick = { navController.navigate(Routes.recoWorkers) }) {
            Text(text = "Create")
        }
    }
}