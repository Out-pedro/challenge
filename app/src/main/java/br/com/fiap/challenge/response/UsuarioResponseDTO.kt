package br.com.fiap.challenge.response

data class UsuarioResponseDTO(
    val id: String,
    val nome: String,
    val email: String,
    val login: String,
    val telefone: String,
    val endereco: String
)
