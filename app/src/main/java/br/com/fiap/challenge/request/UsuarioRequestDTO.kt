package br.com.fiap.challenge.request

data class UsuarioRequestDTO(
    val nome: String,
    val email: String,
    val login: String,
    val senha: String,
    val telefone: String,
    val endereco: String
)
