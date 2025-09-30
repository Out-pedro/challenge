package br.com.fiap.myapplication.data.api.model


data class AvaliacaoResponse(
    val id: String,
    val mensagem: String,
    val nivelRisco: String,
    val recomendacoes: List<String>
)