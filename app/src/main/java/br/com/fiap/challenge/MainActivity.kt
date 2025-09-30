package br.com.fiap.challenge

import App.bem.estar.HomeScreen
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.challenge.Screen.Cadastro
import br.com.fiap.challenge.Screen.DicasSaudeMental
import br.com.fiap.challenge.Screen.RecursosDeApoio
import br.com.fiap.challenge.ui.theme.ChallengeTheme
import br.com.fiap.myapplication.data.repository.MockAvaliacaoRepository
import br.com.fiap.myapplication.ui.screens.TelaAvaliacaoRiscos
import br.com.fiap.myapplication.ui.screens.TelaConfirmacaoEnvio
import br.com.fiap.myapplication.viewmodel.AvaliacaoRiscosViewModel
import br.com.fiap.projetofiap.screen.Login
import com.example.telaprojeto12345.WellbeingDashboard

class MainActivity : ComponentActivity() {

    private val viewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AvaliacaoRiscosViewModel::class.java)) {
                return AvaliacaoRiscosViewModel(MockAvaliacaoRepository()) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    private val viewModel: AvaliacaoRiscosViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChallengeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable(route = "recursos") { RecursosDeApoio(navController) }
                    composable(route = "home") { HomeScreen(navController) }
                    composable(route = "login") { Login(navController) }
                    composable(route = "cadastro") { Cadastro(navController) }
                    composable(route = "dicas") { DicasSaudeMental(navController) }
                    composable(route = "progresso") { WellbeingDashboard(navController) }
                    composable(route = "avaliacao") {
                        TelaAvaliacaoRiscos(
                            navController = navController,
                            viewModel = viewModel,
                            onSubmit = { respostas ->
                                Log.d("Avaliação", "Respostas: $respostas")
                                navController.navigate("confirmacao") {
                                    popUpTo("avaliacao") { inclusive = true }
                                }
                            }
                        )
                    }
                    composable(route = "confirmacao") {
                        TelaConfirmacaoEnvio(
                            navController = navController,
                            onNovaAvaliacao = {
                                navController.navigate("avaliacao") {
                                    popUpTo("confirmacao") { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }

}
