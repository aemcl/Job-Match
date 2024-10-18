package com.example.jobmatch

import android.graphics.Outline
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

fun SignUp(navController: NavController){
    var UserName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var checked by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Text(text = "Work Match", fontSize = 24.sp)
        Image(
            painter = painterResource(id = R.drawable.m),
            contentDescription = "LOGO",
            modifier = Modifier.size(200.dp)
        )
        
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Already have an account? Login.",
            fontSize = 16.sp,
            modifier = Modifier.clickable { navController.navigate(Routes.login) }
        )

        OutlinedTextField(
            value = UserName,
            onValueChange = { UserName = it },
            label = { Text(text = "User Name:") })

        Spacer(modifier = Modifier.height(2.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email:") })

        Spacer(modifier = Modifier.height(2.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password:") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(checked = checked, onCheckedChange ={ checked = it})
            Text(text = "I agree to the app's Terms and Conditions")
        }

        Button(onClick = {
            Log.i("Credential", "UserName:$UserName email:$email Password:$password")
        }) {
            Text(text = "Sign Up")
        }
    }
}
