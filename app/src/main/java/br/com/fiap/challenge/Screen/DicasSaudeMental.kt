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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.R

// Modelo de dados para dica
data class DicaSaudeMental(val titulo: String, val mensagem: String)

// Composable do Card da dica
@Composable
fun DicaCard(dica: DicaSaudeMental) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE)) // azul claro
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = dica.titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dica.mensagem,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun DicasSaudeMental(navController: NavController?) {
    val dicas = listOf(
        DicaSaudeMental(
            "Respire com calma",
            "Inspire pelo nariz por 4 segundos, segure por 4 segundos e expire lentamente pela boca. Repita por 1 minuto."
        ),
        DicaSaudeMental(
            "Hidrate-se",
            "A água ajuda seu corpo a funcionar melhor e influencia diretamente seu humor e energia."
        ),
        DicaSaudeMental(
            "Movimente-se",
            "Uma caminhada leve pode liberar endorfinas e melhorar seu bem-estar emocional."
        ),
        DicaSaudeMental(
            "Fale com alguém",
            "Converse com um amigo, familiar ou profissional. Você não está sozinho(a)."
        ),
        DicaSaudeMental(
            "Permita-se descansar",
            "Você não precisa ser produtivo o tempo todo. O descanso também é autocuidado."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Cabeçalho fixo no topo
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
                text = "Dicas de Saúde Mental",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espaço entre o topo e a lista

        // Lista de dicas
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(dicas) { dica ->
                DicaCard(dica)
            }
        }
    }
}

