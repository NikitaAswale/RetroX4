package com.example.retrox4

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserComponent() {

    val userviewmodel : UserViewModel = viewModel()
    val userlist = userviewmodel.users.collectAsState().value
    LazyColumn (content ={
        itemsIndexed(userlist){
            index, userdetails ->
            UserView(userdetails)
        }
    })
}

@Composable
fun UserView(userdetails : UserDataClass) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "User's Details", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
//        Column (modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.Start){
//            Text(text = userdetails.username, fontSize = 18.sp, fontWeight = FontWeight.Normal)
//            Text(text = userdetails.email, fontSize = 18.sp, fontWeight = FontWeight.Normal)
//            Text(text = userdetails.address.city, fontSize = 18.sp, fontWeight = FontWeight.Normal)
//            Text(text = userdetails.company.name, fontSize = 18.sp, fontWeight = FontWeight.Normal)
//        }

    }
}