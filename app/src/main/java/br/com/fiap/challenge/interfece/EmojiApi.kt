package br.com.fiap.challenge.interfece

import br.com.fiap.challenge.request.EmojiRequest
import br.com.fiap.challenge.response.EmojiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface EmojiApi {
    @POST("/user/emoji")
    suspend fun sendEmoji(@Body request: EmojiRequest): Response<EmojiResponse>
}