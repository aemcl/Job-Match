package com.example.jobmatch.forms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jobmatch.AppLogo
import com.example.jobmatch.AppName
import com.example.jobmatch.R
import com.example.jobmatch.Routes

@Composable
fun EmployeeForm(navController: NavController){

    var fname by remember {
        mutableStateOf("")
    }

    var lname by remember {
        mutableStateOf("")
    }

    var dateofBirth by remember {
        mutableStateOf("")
    }

    var address by remember {
        mutableStateOf("")
    }

    var educationalAttainment by remember {
        mutableStateOf("")
    }

    var skills by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 45.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppLogo(200)
        AppName(30)

        Text(text = "Provide the following informations:",
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Gray
        )

        OutlinedTextField(
            value = fname,
            onValueChange = { fname = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "First Name:") }
        )

        OutlinedTextField(
            value = lname,
            onValueChange = { lname = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Last Name:") }
        )

        OutlinedTextField(
            value = dateofBirth,
            onValueChange = { dateofBirth = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Date of Birth:") }
        )

        OutlinedTextField(
            value = address,
            onValueChange = { address = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Address:") }
        )

        OutlinedTextField(
            value = educationalAttainment,
            onValueChange = { educationalAttainment = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Educational Attainment:") }
        )

        OutlinedTextField(
            value = skills,
            onValueChange = { fname = it},
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Skills:") }
        )

        Button(
            onClick = { navController.navigate(Routes.employeeMainScreen) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFff8e2b)),
            modifier = Modifier.width(280.dp).height(40.dp)
        ) {
            Text(text = "Submit", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }



    }
}