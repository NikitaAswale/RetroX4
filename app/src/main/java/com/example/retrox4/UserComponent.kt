package com.example.retrox4

import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserComponent() {

    val userviewmodel : UserViewModel = viewModel()
    val userlist = userviewmodel.users.collectAsState().value

    Column (
        modifier = Modifier
            .fillMaxSize(),// Make the Column take up all available screen space vertically
        //.padding(8.dp)// Optional padding around the Column
        verticalArrangement = Arrangement.Center // Optional space between rows
    ) {
        Row (modifier = Modifier.fillMaxWidth().background(color = Color.Blue),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
        ){
        Text(text = "User's details", fontSize = 22.sp, fontWeight = FontWeight.Bold)
    }
        Row {
            LazyColumn(content = {
                itemsIndexed(userlist) { index, userdetails ->
                    UserView(userdetails)
                }
            })
        }
    }
}

@Composable
fun UserView(userdetails : UserDataClass) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Row {
                Text(text = "Username : ", fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Red)
                Text(text = userdetails.username, fontSize = 18.sp, fontWeight = FontWeight.Normal)
            }
            Row {
                Text(text = "Email : ", fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Red)
                Text(text = userdetails.email, fontSize = 18.sp, fontWeight = FontWeight.Normal)
            }
            Row {
                Text(text = "City : ", fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Red)
                Text(
                    text = userdetails.address.city,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Row {
                Text(text = "Company Name : ", fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color.Red)
                Text(
                    text = userdetails.company.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
    }

}
