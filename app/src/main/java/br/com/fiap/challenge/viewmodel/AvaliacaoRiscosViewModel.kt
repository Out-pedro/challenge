package br.com.fiap.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import br.com.fiap.challenge.model.Pergunta
import br.com.fiap.myapplication.data.repository.AvaliacaoRepository
import br.com.fiap.myapplication.data.repository.MockAvaliacaoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AvaliacaoRiscosViewModel(
    private val repository: AvaliacaoRepository = MockAvaliacaoRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _perguntas = mutableStateListOf<Pergunta>()
    val perguntas: List<Pergunta> get() = _perguntas

    val respostas = mutableStateListOf<Int?>()


    var mostrarConfirmacao by mutableStateOf(false)
        private set


    var formularioEnviado by mutableStateOf(false)
        private set

    var formValido by mutableStateOf(false)
        private set

    val opcoes = listOf("Nunca", "Raramente", "Às vezes", "Frequentemente", "Sempre")

    init {
        carregarPerguntas()
    }

    private fun carregarPerguntas() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            try {
                val resultado = repository.obterPerguntas()

                resultado.fold(
                    onSuccess = { listaPerguntas ->
                        _perguntas.clear()
                        _perguntas.addAll(listaPerguntas)

                        respostas.clear()
                        repeat(listaPerguntas.size) { respostas.add(null) }

                        _uiState.value = UiState.Success
                    },
                    onFailure = { exception ->
                        _uiState.value = UiState.Error("Erro ao carregar perguntas: ${exception.message}")
                    }
                )
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Erro inesperado: ${e.message}")
            }
        }
    }

    fun selecionarOpcao(perguntaIndex: Int, opcaoIndex: Int) {
        respostas[perguntaIndex] = opcaoIndex
        verificarFormulario()
    }

    fun enviarFormulario() {
        verificarFormulario()

        if (formValido) {
            viewModelScope.launch {
                _uiState.value = UiState.Loading

                try {
                    val result = repository.enviarAvaliacao(respostas.map { it!! })

                    result.fold(
                        onSuccess = { response ->

                            formularioEnviado = true
                            mostrarConfirmacao = true
                            _uiState.value = UiState.Success
                        },
                        onFailure = { exception ->
                            _uiState.value = UiState.Error("Erro ao enviar avaliação: ${exception.message}")
                        }
                    )
                } catch (e: Exception) {
                    _uiState.value = UiState.Error("Erro inesperado: ${e.message}")
                }
            }
        }
    }


    fun resetarFormulario() {
        mostrarConfirmacao = false
        formularioEnviado = false


        respostas.clear()
        repeat(_perguntas.size) { respostas.add(null) }

        formValido = false
    }

    fun recarregarPerguntas() {
        carregarPerguntas()
    }

    private fun verificarFormulario() {
        formValido = respostas.all { it != null }
    }

    sealed class UiState {
        object Loading : UiState()
        object Success : UiState()
        data class Error(val message: String) : UiState()
    }
}