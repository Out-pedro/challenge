package br.com.fiap.myapplication.data.repository

import br.com.fiap.challenge.model.Pergunta
import br.com.fiap.myapplication.data.api.model.AvaliacaoRequest
import br.com.fiap.myapplication.data.api.model.AvaliacaoResponse

import kotlinx.coroutines.flow.Flow

interface AvaliacaoRepository {
    suspend fun enviarAvaliacao(respostas: List<Int>): Result<AvaliacaoResponse>
    suspend fun obterPerguntas(): Result<List<Pergunta>>
}