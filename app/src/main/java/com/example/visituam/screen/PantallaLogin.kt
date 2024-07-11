package com.example.visituam.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.visituam.viewmodel.LoginViewModel

@Composable
fun PantallaLogin(padding: PaddingValues){
    var PaswordVisible  by remember { mutableStateOf(false)}

    val loginViewModel : LoginViewModel = viewModel()

    val state = loginViewModel.state



}