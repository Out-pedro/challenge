package App.bem.estar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.R

@Composable
fun HomeScreen(navController: NavController?) {
    var humorSelecionado by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        item {
            Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Título
                Text(
                    text = "Olá, como você está hoje? 😊",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                // Ações principais
                ActionCard("📝 Fazer autoavaliação") { navController?.navigate("avaliacao") }
                ActionCard("📈 Ver meu progresso") { navController?.navigate("progresso") }
                ActionCard("🗣️ Recursos de Apoio") { navController?.navigate("recursos") }
                ActionCard("💡 Dica do dia") { navController?.navigate("dicas") }

                Spacer(modifier = Modifier.height(40.dp))

                // Citação
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal =20.dp)
                ) {
                    Text(
                        text = "“Respirar fundo já é um bom recomeço.” 💭",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            //resumo do progresso

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .shadow(2.dp, RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "📊 Seu resumo",

                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "• Autoavaliações feitas: 12",

                        fontSize = 16.sp
                    )
                    Text(
                        text = "• Emoção mais comum: 🙂",

                        fontSize = 16.sp
                    )
                    Text(
                        text = "• Dias consecutivos: 4",

                        fontSize = 16.sp
                    )
                }
            }


            // Emojis de humor
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Selecione sua emoção de hoje",

                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    listOf("😄", "🙂", "😐", "😔", "😭").forEach { emoji ->
                        Surface(
                            shape = CircleShape,
                            modifier = Modifier
                                .size(72.dp)
                                .clickable { humorSelecionado = emoji }
                                .shadow(4.dp, CircleShape)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(text = emoji, fontSize = 56.sp)
                            }
                        }
                    }
                }
            }
        } }
    }
}

@Composable
fun ActionCard(text: String, onClick: () -> Unit) {
    Surface(

        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() }
            .shadow(2.dp, RoundedCornerShape(16.dp))
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Text(
                text = text,

                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
