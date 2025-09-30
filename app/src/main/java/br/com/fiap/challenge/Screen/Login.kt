package br.com.fiap.projetofiap.screen

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.NavController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.interfece.ApiClient
import br.com.fiap.challenge.request.LoginRequestDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//@OptIn(ExperimentalMaterial3Api::class)
//@OptIn(ExperimentalMaterial3Api::class)
//@OptIn(ExperimentalMaterial3Api::class)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController?) {

    val context = LocalContext.current


    val yourLoginState = remember { mutableStateOf("") }
    val yourKeyState = remember { mutableStateOf("") }
    val erroLogin = remember { mutableStateOf(false) }
    val erroSenha = remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFDFDFD)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .height(250.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Seja bem-vindo",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(50.dp)
                )
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
                    .height(300.dp),
                colors = CardDefaults.cardColors(Color(0xFFB2C8BB))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    // Campo de Login
                    TextField(
                        value = yourLoginState.value,
                        onValueChange = { yourLoginState.value = it },
                        label = { Text(text ="Qual o seu login") },
                        isError =erroLogin.value
                    )

                    if (erroLogin.value) {
                        Text(
                            text = "O login é obrigatório",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    // Campo de Senha
                    TextField(
                        value = yourKeyState.value,
                        onValueChange = { yourKeyState.value = it },
                        label = { Text(text ="Qual a sua senha") },
                        isError =erroSenha.value
                    )
                    if (erroSenha.value) {
                        Text(
                            text = "A senha é obrigatória",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 14.sp,
                            color = Color.Red,
                            textAlign = TextAlign.End
                        )
                    }
                }

                // Botões
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                        Button(
                            onClick = {
                                val loginDigitado = yourLoginState.value.trim()
                                val senhaDigitada = yourKeyState.value

                                // Validação
                                erroLogin.value = loginDigitado.isEmpty()
                                erroSenha.value = senhaDigitada.isEmpty()

                                if (!erroLogin.value && !erroSenha.value) {
                                    val request = LoginRequestDTO(
                                        login = loginDigitado,
                                        senha = senhaDigitada
                                    )

                                    CoroutineScope(Dispatchers.IO).launch {
                                        try {
                                            val response = ApiClient.usuarioApi.login(request)
                                            withContext(Dispatchers.Main) {
                                                if (response.isSuccessful) {
                                                    val body = response.body()
                                                    Toast.makeText(context, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                                                    navController?.navigate("home")
                                                } else {
                                                    Toast.makeText(context, "Login inválido", Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                        } catch (e: Exception) {
                                            withContext(Dispatchers.Main) {
                                                Toast.makeText(context, "Erro: ${e.message}", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                    }
                                }
                            },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF1C704C))
                        ) {
                            Text(text = "Continuar", fontSize = 12.sp)
                        }

                    Button(
                        onClick = { navController?.navigate("cadastro") },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF1C704C))
                    ) {
                        Text(text = "Criar conta", fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginPrev() {
    Login(null)
}