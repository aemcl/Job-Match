package com.example.jobmatch.pages

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jobmatch.MainTopBar
import com.example.jobmatch.Routes

@Composable
fun MainProfile(
    @DrawableRes profilePic: Int,
    username: String,
    email: String,
    profileDescription: String,
    navController: NavController
) {
    // Create a scrollable state for the layout
    val scrollState = rememberScrollState()
    var isExpanded by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState) // Enable vertical scrolling
            .padding(top = 10.dp, bottom = 50.dp), // General padding for the screen
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, top = 40.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )

            Spacer(modifier = Modifier.width(16.dp))

            BasicTextField(
                value = "Profile",
                onValueChange = {},
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
                enabled = false
            )

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                modifier = Modifier.padding(end = 25.dp)
            )
        }
        // Profile Picture Card with Circular Shape
        OutlinedCard(
            border = BorderStroke(5.dp, Color.White),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEBDA98)),
            modifier = Modifier
                .size(200.dp) // Adjust size of the card
                .padding(top = 16.dp),
            shape = CircleShape // Make it circular
        ) {
            Image(
                painter = painterResource(profilePic),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        // Username and Email with Circle Borders
        Text(
            text = "Username: $username",
            fontSize = 14.sp,
            //style = MaterialTheme.typography.h5,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(listOf(Color.Gray, Color.LightGray)),
                    shape = CircleShape
                )
                .width(300.dp)
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Email Adress: $email",
            fontSize = 14.sp,
            //style = MaterialTheme.typography.body1,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(listOf(Color.Gray, Color.LightGray)),
                    shape = CircleShape
                )
                .width(300.dp)
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedCard(
            border = BorderStroke(2.dp, Color.LightGray),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth() // Full width of the screen
                .padding(horizontal = 16.dp) // Padding for the card
        ) {
            Text(
                text = "Description:\n\n" + profileDescription,
                //style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Justify,
                fontSize = 18.sp,// Justified text for paragraph formatting
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { isExpanded = !isExpanded }, // Toggle text expansion on click
            maxLines = if (isExpanded) Int.MAX_VALUE else 4, // Show all lines if expanded, else 3 lines
            overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.height(70.dp))

        // Bottom Buttons (Change Password and Log Out)
        Button(
            onClick = { navController.navigate(Routes.changepass) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
        ) {
            Text(text = "Change Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Routes.login) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
        ) {
            Text(text = "Log Out")
        }

        Spacer(modifier = Modifier.height(50.dp)) // Extra space at the bottom if needed
    }
}
