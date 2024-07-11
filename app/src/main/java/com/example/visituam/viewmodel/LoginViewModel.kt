package com.example.visituam.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visituam.repository.RepositoryUsuario
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){
    private val repository = RepositoryUsuario() /*Necesita ser creada en
    carpeta Repository.
    */
    var state by mutableStateOf(State())
            private set

    //No olvidarme de agrear esta y las demas funciones con "on" en PantallaLogin
    fun onEmail(email : String){
        state = state.copy(email = email)
    }

    fun onPassword(password: String){
        state = state.copy(password = password)
    }

    fun onLogin(){
        viewModelScope.launch {
            val result = repository.login(state.email, state.password)
            if (result.isSuccessful){
                state = if (result.getOrNull() == 1){
                    state.copy(mensaje = "Usario correcto", error = false)
                }
                else{
                    state.copy(mensaje = "usuario incorrecto", error = true)
                }
            }
            else{
                state = state.copy(mensaje = "Error de conexión", error = true)
            }
        }
    }

    fun restartState(){
        state = state.copy(error = false, mensaje = null)
    }

    // Todos los valores en un data class
    // son inicializados
    data class State(
        val email : String = "",
        val password : String = "",
        val mensaje : String? = null,
        val error : Boolean = false
    )
}