package com.example.jobmatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

fun SignUp(navController: NavController){
    var userName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var securityQuestion by remember {
        mutableStateOf("")
    }

    var securityAnswer by remember {
        mutableStateOf("")
    }

    var checked by remember {
        mutableStateOf(true)
    }

    var roleSelected by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
        AppName(30)
        
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Already have an account? Log in.",
            fontSize = 16.sp,
            modifier = Modifier.clickable { navController.navigate(Routes.login) }
        )

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
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

        Spacer(modifier = Modifier.height(2.dp))

        OutlinedTextField(
            value = securityQuestion,
            onValueChange = { securityQuestion = it },
            label = { Text(text = "Security Question:") }
        )

        Spacer(modifier = Modifier.height(2.dp))

        OutlinedTextField(
            value = securityAnswer,
            onValueChange = { securityAnswer = it },
            label = { Text(text = "Security Question Answer:") }
        )

        Spacer(modifier = Modifier.height(6.dp))

        Dropdown(roleSelect = {roleSelected = it})

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(checked = checked, onCheckedChange ={ checked = it})
            Text(text = "I agree to the app's Terms and Conditions")
        }

        Button(
            onClick = {
                when (roleSelected){
                    "Employee" -> navController.navigate(Routes.employeeHome)
                    "Employer" -> navController.navigate(Routes.employerHome)
                }
                navController.navigate(Routes.home)},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFF2E77AE)),
            modifier = Modifier.width(280.dp)
            ) {
            Text(text = "Sign Up")
        }
    }
}
