package com.example.jobmatch

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun LogIn(navController: NavController){
    var UserName by remember {
        mutableStateOf("")
    }
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
            painter = painterResource(id = R.drawable.m),
            contentDescription = "LOGO",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Work Match", fontSize = 24.sp)

        Text(
            text = "Don't have an account? Sign Up.",
            fontSize = 16.sp,
            modifier = Modifier.clickable { navController.navigate(Routes.signup) }
        )

        Spacer(modifier = Modifier.height(4.dp))

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

        Button(
            onClick = { navController.navigate(Routes.createprofile) /*Log.i("Credential", "UserName:$UserName email:$email Password:$password")*/
        }
        ) {
            Text(text = "Log in")
        }

        Text(
            text = "Forgot Password?",
            fontSize = 16.sp,
            modifier = Modifier.clickable { navController.navigate(Routes.forgotpass) })
    }
}



