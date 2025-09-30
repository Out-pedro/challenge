package br.com.fiap.myapplication.data.repository

import br.com.fiap.challenge.model.Pergunta
import br.com.fiap.myapplication.data.api.model.AvaliacaoRequest
import br.com.fiap.myapplication.data.api.model.AvaliacaoResponse

import kotlinx.coroutines.delay

class MockAvaliacaoRepository : AvaliacaoRepository {

    private val perguntasMock = listOf(
        "Você se sente pressionado a cumprir prazos inalcançáveis?",
        "Você sente apoio dos seus colegas de trabalho?",
        "Você consegue equilibrar trabalho e vida pessoal?",
        "Você sente que tem controle sobre suas tarefas?",
        "O ambiente de trabalho é estressante com frequência?",
        "Você recebe feedback construtivo do seu gestor?",
        "Você se sente valorizado pela organização?",
        "Há oportunidades de crescimento profissional?",
        "Você sente que sua carga de trabalho é adequada?",
        "O ambiente físico de trabalho é confortável?"
    ).map { Pergunta(it) }

    override suspend fun obterPerguntas(): Result<List<Pergunta>> {
        delay(800)
        return Result.success(perguntasMock)
    }

    override suspend fun enviarAvaliacao(respostas: List<Int>): Result<AvaliacaoResponse> {
        delay(1500)


        return Result.success(
            AvaliacaoResponse(
                id = "avl-${System.currentTimeMillis()}",
                mensagem = "Avaliação enviada com sucesso para análise do RH",
                nivelRisco = "", // não usado mais
                recomendacoes = emptyList() // não usado mais
            )
        )
    }
}