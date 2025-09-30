package com.example.telaprojeto12345

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.R


@Composable
fun WellbeingDashboard(navController: NavController?) {
    var selectedPeriod by remember { mutableStateOf("Semanal") }
    val periods = listOf("Semanal", "Mensal", "Trimestral")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TopoComVoltar(titulo = "Dashboard de Bem-estar", navController = navController)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sua Jornada de Bem-estar",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF457B9D)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            periods.forEach { period ->
                val backgroundColor by animateColorAsState(
                    targetValue = if (selectedPeriod == period) Color(0xFFB2C8BA) else Color(0xFFE6E6FA),
                    label = "buttonColor"
                )
                Button(
                    onClick = { selectedPeriod = period },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = backgroundColor,
                        contentColor = Color(0xFF457B9D)
                    ),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(period)
                }
            }
        }

        MoodChart()
        StressChart()
        ResourceUsageChart()
        InsightsSection()
    }
}

@Composable
fun MoodChart() {
    CardSection(title = "Humor Diário", icon = Icons.Default.Mood) {
        BarGraph(data = listOf(40, 60, 45, 35, 60, 80, 65), barColor = Color(0xFF457B9D))
        Text("Evolução semanal do seu humor", fontSize = 14.sp, color = Color(0xFF6D6875))
    }
}

@Composable
fun StressChart() {
    CardSection(title = "Nível de Estresse", icon = Icons.Default.BarChart) {
        BarGraph(data = listOf(70, 50, 65, 40, 30, 20, 25), barColor = Color(0xFF457B9D))
        Text("Tendência de estresse durante a semana", fontSize = 14.sp, color = Color(0xFF6D6875))
    }
}

@Composable
fun ResourceUsageChart() {
    CardSection(title = "Uso de Recursos de Apoio", icon = Icons.Default.SupportAgent) {
        BarGraph(data = listOf(1, 3, 2, 0, 4, 2, 1), barColor = Color(0xFF457B9D))
        Text("Frequência de uso dos recursos disponíveis", fontSize = 14.sp, color = Color(0xFF6D6875))
    }
}

@Composable
fun InsightsSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
            .clickable { /* Ação futura */ }
            .background(Color(0xFFE0F7FA), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Comparativos da Semana",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF457B9D),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CardSection(title: String, icon: ImageVector, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .background(color = Color(0xFFE0F7FA), shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF457B9D),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(title, fontWeight = FontWeight.Bold, color = Color(0xFF457B9D))
        }
        content()
    }
}

@Composable
fun BarGraph(data: List<Int>, barColor: Color) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        data.forEach { value ->
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(value.dp)
                    .background(barColor, shape = RoundedCornerShape(4.dp))
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun TopoComVoltar(titulo: String, navController: NavController?) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { navController?.popBackStack() },
            modifier = Modifier.align(Alignment.CenterStart),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back ),
                contentDescription = "Voltar",
                tint = Color.Black
            )
        }
        Text(
            text = titulo,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
