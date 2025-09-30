package br.com.fiap.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.R

@Composable
fun TelaConfirmacaoEnvio(
    navController: NavController?,
    onNovaAvaliacao: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Cabeçalho fixo
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController?.navigate("home") },
                modifier = Modifier.align(Alignment.CenterStart),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF))
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = "Voltar",
                    tint = Color(0xFF000000)
                )
            }
            Text(
                text = "Confirmação",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Conteúdo rolável
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Avaliação Enviada com Sucesso!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF457B9D),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🔒 Dados Protegidos",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF457B9D),
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    Text(
                        text = "Suas respostas foram enviadas de forma completamente anônima para o nosso RH!",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF6D6875),
                        modifier = Modifier.padding(bottom = 8.dp),
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Nenhuma informação pessoal foi compartilhada.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF6D6875)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE6E6FA))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "📊 Próximos Passos:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF457B9D),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "• O RH analisará os dados coletados de forma agregada\n" +
                                "• Serão identificadas oportunidades de melhoria\n" +
                                "• Ações preventivas poderão ser implementadas\n" +
                                "• Sua contribuição ajuda a melhorar o ambiente de trabalho",
                        fontSize = 14.sp,
                        color = Color(0xFF6D6875),
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onNovaAvaliacao,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB2C8BA))
            ) {
                Text(
                    "Fazer Nova Avaliação",
                    fontSize = 18.sp,
                    color = Color(0xFF6D6875),
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Obrigado por sua participação!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF6D6875),
                textAlign = TextAlign.Center
            )
        }
    }
}
