package com.example.jobmatch.employee

import android.app.Notification
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import com.example.jobmatch.employee.pages.HomePage
import com.example.jobmatch.employee.pages.MessagePage
import com.example.jobmatch.employee.pages.NotificationPage
import com.example.jobmatch.employee.pages.Profile

@Composable
fun MainScreen(modifier: Modifier=Modifier){

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Message", Icons.Default.Email, 5),
        NavItem("Notification", Icons.Default.Notifications, 5),
        NavItem("Profile", Icons.Default.AccountCircle, 0)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed{ index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index},
                        icon = {
                            BadgedBox(badge = {
                                if( navItem.badgeCount>0)
                                    Badge(){
                                        Text(text = navItem.badgeCount.toString())
                                    }
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            } ) {

                            }
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                        )
                }
            }
        }
    ) {innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen (modifier: Modifier = Modifier, selectedIndex : Int){
    when(selectedIndex){
        0-> HomePage()
        1 -> MessagePage()
        2 -> NotificationPage()
        3 -> Profile()
    }
}