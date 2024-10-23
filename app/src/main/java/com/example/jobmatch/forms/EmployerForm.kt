package com.example.jobmatch.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jobmatch.AppLogo
import com.example.jobmatch.AppName
import com.example.jobmatch.Routes

@Composable
fun EmployerForm(navController: NavController){
    var companyName by remember {
        mutableStateOf("")
    }

    var companyAddress by remember {
        mutableStateOf("")
    }

    var companyType by remember {
        mutableStateOf("")
    }

    var salary by remember {
        mutableStateOf("")
    }

    var spacebetweenField = 5.dp
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 45.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppLogo(200)
        Spacer(modifier = Modifier.height(15.dp))
        AppName(30)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Provide the following informations:",
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = companyName,
            onValueChange = { companyName = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Company Name:") }
        )
        Spacer(modifier = Modifier.height(spacebetweenField))
        OutlinedTextField(
            value = companyAddress,
            onValueChange = { companyAddress = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Company Address:") }
        )
        Spacer(modifier = Modifier.height(spacebetweenField))
        OutlinedTextField(
            value = companyType,
            onValueChange = { companyType = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Company Type:") }
        )
        Spacer(modifier = Modifier.height(spacebetweenField))
        OutlinedTextField(
            value = salary,
            onValueChange = { salary = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Salary:") }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { navController.navigate(Routes.employerMainScreen) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFff8e2b)),
            modifier = Modifier.width(280.dp).height(40.dp)
        ) {
            Text(text = "Submit", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }



    }
}