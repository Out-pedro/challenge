package br.com.fiap.challenge.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.R

// 1. Data class
data class CanalDeSuporte(
    val nome: String,
    val telefone: String,
    val site: String,
    val detalhes: String
)

// 2. Card Composable para cada canal
@Composable
fun CanalDeSuporteCard(canal: CanalDeSuporte) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB2C8BA))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = canal.nome, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Telefone: ${canal.telefone}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Site: ${canal.site}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = canal.detalhes, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun Orientacoes() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB2C8BA))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Orientações em momentos difíceis",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "• Respire fundo e tente se concentrar na sua respiração.\n" +
                        "• Converse com alguém de confiança.\n" +
                        "• Procure um ambiente calmo e seguro.\n" +
                        "• Se estiver em crise, entre em contato com o CVV pelo número 188.\n" +
                        "• Lembre-se: pedir ajuda é um ato de coragem, não de fraqueza.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun AlertaCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFCDD2)) // vermelho claro
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Alerta Importante",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFB71C1C) // vermelho escuro
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Se você estiver em perigo imediato ou sentir que pode machucar a si mesmo ou a outra pessoa, procure ajuda profissional imediatamente ou ligue para os serviços de emergência (190).",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
        }
    }
}


// 3. Lista principal
@Composable
fun RecursosDeApoio(navController: NavController?) {
    val supportChannels = listOf(
        CanalDeSuporte(
            nome = "CVV – Centro de Valorização da Vida",
            telefone = "188",
            site = "https://www.cvv.org.br",
            detalhes = "Escuta ativa, sigilosa e gratuita. Atendimento 24h por telefone, chat ou e-mail."
        ),
        CanalDeSuporte(
            nome = "Saúde Mental Brasil (SMB)",
            telefone = "-",
            site = "https://www.saudementalbrasil.com.br",
            detalhes = "Chat online, grupos de apoio e conteúdos educativos. Atendimento gratuito ou acessível."
        ),
        CanalDeSuporte(
            nome = "Instituto Vita Alere",
            telefone = "-",
            site = "https://www.vitaalere.com.br",
            detalhes = "Prevenção do suicídio. Apoio para famílias, conteúdos educativos e atendimentos psicológicos."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Lista de canais
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                // Cabeçalho
                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { navController?.popBackStack() },
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
                        text = "Recursos de Apoio",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            item { AlertaCard() }
            item { Orientacoes() }

            items(supportChannels) { channel ->
                CanalDeSuporteCard(channel)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun RecursosDeApoioPrev() {
    RecursosDeApoio(null)
}

