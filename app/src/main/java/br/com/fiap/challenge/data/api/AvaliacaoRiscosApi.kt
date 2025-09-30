package br.com.fiap.myapplication.data.api

import br.com.fiap.myapplication.data.api.model.AvaliacaoRequest
import br.com.fiap.myapplication.data.api.model.AvaliacaoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AvaliacaoRiscosApi {
    @POST("avaliacao")
    suspend fun enviarAvaliacao(@Body request: AvaliacaoRequest): Response<AvaliacaoResponse>

    @GET("perguntas")
    suspend fun obterPerguntas(): Response<List<String>>
}