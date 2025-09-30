package br.com.fiap.challenge.interfece

import br.com.fiap.challenge.request.LoginRequestDTO
import br.com.fiap.challenge.request.UsuarioRequestDTO
import br.com.fiap.challenge.response.LoginResponseDTO
import br.com.fiap.challenge.response.UsuarioResponseDTO
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UsuarioApi {

    data class LoginResponseDTO(val message: String)

    @POST("user")
    suspend fun criaUsuario(@Body usuario: UsuarioRequestDTO): Response<UsuarioResponseDTO>



    @POST("user/login")
    suspend fun login(@Body request: LoginRequestDTO): Response<LoginResponseDTO>



}
