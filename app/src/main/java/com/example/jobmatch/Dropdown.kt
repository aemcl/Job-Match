@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobmatch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController

@Composable
fun Dropdown(roleSelect: (String) -> Unit){
    var dropdownList = listOf(
        "Employee",
        "Employer"
    )

   var selectedText by remember {
       mutableStateOf("")
   }

    var textfieldSize by remember {
        mutableStateOf(Size.Zero)
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }

    val icon = if (isExpanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text(text = "What are you?")},
            trailingIcon ={ Icon(icon, "contentDescription",
                Modifier.clickable { isExpanded = !isExpanded })
            }
    )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {isExpanded = false},
            modifier = Modifier.width(with(LocalDensity.current){textfieldSize.width.toDp()})
            ) {
            dropdownList.forEach{ label ->
                DropdownMenuItem( text = {Text(text = label)},
                    onClick = {
                    selectedText = label
                    isExpanded = false
                    roleSelect(label)
                })
            }
        }
    }
}