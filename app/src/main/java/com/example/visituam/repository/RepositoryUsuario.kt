package com.example.visituam.repository

import com.example.visituam.remote.ApiUsuario

class RepositoryUsuario {
    val apiusuario : ApiUsuario by lazy {
        ApiAdapter.getInstance().Create(ApiUsuario :: class.java)
    }
}