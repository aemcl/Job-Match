package com.example.jobmatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

fun LogIn(navController: NavController){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
        AppName(30)

        Text(
            text = "Don't have an account? Sign Up.",
            fontSize = 16.sp,
            modifier = Modifier.clickable { navController.navigate(Routes.signup) }
        )

        Spacer(modifier = Modifier.height(30.dp))

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

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Forgot Password?",
            fontSize = 16.sp,
            modifier = Modifier.clickable { navController.navigate(Routes.forgotpass) }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate(Routes.home)},/*Log.i("Credential", "UserName:$UserName email:$email Password:$password")*/
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFff8e2b)),
            modifier = Modifier.width(280.dp)

        ) {
            Text(text = "Log in", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}



