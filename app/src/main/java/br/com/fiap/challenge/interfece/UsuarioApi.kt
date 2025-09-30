package br.com.fiap.challenge.interfece

import br.com.fiap.challenge.request.LoginRequestDTO
import br.com.fiap.challenge.request.UsuarioRequestDTO
import br.com.fiap.challenge.response.UsuarioResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface UsuarioApi {

    data class LoginResponseDTO(val message: String)

    @POST("user")
    suspend fun criaUsuario(@Body usuario: UsuarioRequestDTO): Response<UsuarioResponseDTO>



    @POST("user/login")
    suspend fun login(@Body request: LoginRequestDTO): Response<LoginResponseDTO>




}
