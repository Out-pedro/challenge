package br.com.fiap.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel

@Composable
fun TelaAvaliacaoRiscos(
    navController: NavController?,
    viewModel: AvaliacaoRiscosViewModel,
    onSubmit: (List<Int>) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is AvaliacaoRiscosViewModel.UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is AvaliacaoRiscosViewModel.UiState.Error -> {
            val errorMessage = (uiState as AvaliacaoRiscosViewModel.UiState.Error).message

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Erro",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Red
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = errorMessage,
                        modifier = Modifier.padding(8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = { viewModel.recarregarPerguntas() }) {
                        Text("Tentar Novamente")
                    }
                }
            }
        }

        is AvaliacaoRiscosViewModel.UiState.Success -> {

            if (viewModel.formularioEnviado && viewModel.mostrarConfirmacao) {
                TelaConfirmacaoEnvio(
                    navController = navController,
                    onNovaAvaliacao = { viewModel.resetarFormulario() }
                )
            } else {
                ExibirFormularioAvaliacao(viewModel, onSubmit)
            }
        }
    }
}

@Composable
fun ExibirFormularioAvaliacao(

    viewModel: AvaliacaoRiscosViewModel,
    onSubmit: (List<Int>) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
    ) {

        Text(
            text = "Autoavaliação de Riscos Psicossociais \uD83D\uDCDD",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color(0xFF457B9D)
        )

        Text(
            text = "Entenda como fatores do seu ambiente de trabalho podem estar afetando sua " +
                    "saúde mental.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color(0xFF6D6875)
        )

        viewModel.perguntas.forEachIndexed { index, pergunta ->
            QuestionCard(
                question = pergunta.texto,
                options = viewModel.opcoes,
                selectedOption = viewModel.respostas.getOrNull(index),
                onOptionSelected = { viewModel.selecionarOpcao(index, it) }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.enviarFormulario()
                if (viewModel.formValido) {
                    onSubmit(viewModel.respostas.map { it!! })
                }
            },
            enabled = viewModel.formValido,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB2C8BA),
                disabledContainerColor = Color(0xFFD8D8D8)
            )
        ) {
            Text(
                "Enviar",
                fontSize = 18.sp,
                color = if (viewModel.formValido) Color(0xFF6D6875) else Color(0xFF9E9E9E)
            )
        }
    }
}

@Composable
fun QuestionCard(
    question: String,
    options: List<String>,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE0F7FA)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = question,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            options.forEachIndexed { index, option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { onOptionSelected(index) }
                ) {
                    RadioButton(
                        selected = selectedOption == index,
                        onClick = { onOptionSelected(index) }
                    )

                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = option)
                }
            }
        }
    }
}