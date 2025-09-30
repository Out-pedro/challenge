package br.com.fiap.challenge.Screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challenge.interfece.ApiClient
import br.com.fiap.challenge.request.UsuarioRequestDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cadastro(navController: NavController?) {

    val context = LocalContext.current

    // Estados para os campos
    var yourNameState = remember { mutableStateOf("") }
    var yourEmailState = remember { mutableStateOf("") }
    var yourAddressState = remember { mutableStateOf("") }
    var yourLoginCadState = remember { mutableStateOf("") }
    var yourPhoneState = remember { mutableStateOf("") }
    var yourKeyCadState = remember { mutableStateOf("") }

    // Estados de erro
    val erroLogin = remember { mutableStateOf(false) }
    val erroSenha = remember { mutableStateOf(false) }
    val erroNome = remember { mutableStateOf(false) }
    val erroEmail = remember { mutableStateOf(false) }
    val erroTelefone = remember { mutableStateOf(false) }
    val erroEndereco = remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFB2C8BB)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Realize o seu cadastro",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(15.dp)
            )

            // Card com os campos
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .fillMaxHeight(),
                colors = CardDefaults.cardColors(Color(0xFFB2C8BB))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // --- Campo Nome ---
                    TextField(
                        value = yourNameState.value,
                        onValueChange = { yourNameState.value = it },
                        label = { Text("Qual seu nome") },
                        isError = erroNome.value
                    )
                    if (erroNome.value) ErrorText("O nome é obrigatório")

                    Spacer(modifier = Modifier.height(5.dp))

                    // --- Campo Email ---
                    TextField(
                        value = yourEmailState.value,
                        onValueChange = { yourEmailState.value = it },
                        label = { Text("Qual o seu e-mail") },
                        isError = erroEmail.value
                    )
                    if (erroEmail.value) ErrorText("O e-mail é obrigatório")

                    Spacer(modifier = Modifier.height(5.dp))

                    // --- Campo Telefone ---
                    TextField(
                        value = yourPhoneState.value,
                        onValueChange = { yourPhoneState.value = it },
                        label = { Text("Qual o seu telefone") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        isError = erroTelefone.value
                    )
                    if (erroTelefone.value) ErrorText("O telefone é obrigatório")

                    Spacer(modifier = Modifier.height(5.dp))

                    // --- Campo Endereço ---
                    TextField(
                        value = yourAddressState.value,
                        onValueChange = { yourAddressState.value = it },
                        label = { Text("Qual o seu endereço") },
                        isError = erroEndereco.value
                    )
                    if (erroEndereco.value) ErrorText("O endereço é obrigatório")

                    Spacer(modifier = Modifier.height(5.dp))

                    // --- Campo Login ---
                    TextField(
                        value = yourLoginCadState.value,
                        onValueChange = { yourLoginCadState.value = it },
                        label = { Text("Qual o seu login") },
                        isError = erroLogin.value
                    )
                    if (erroLogin.value) ErrorText("O login é obrigatório")

                    Spacer(modifier = Modifier.height(5.dp))

                    // --- Campo Senha ---
                    TextField(
                        value = yourKeyCadState.value,
                        onValueChange = { yourKeyCadState.value = it },
                        label = { Text("Qual a sua senha") },
                        isError = erroSenha.value
                    )
                    if (erroSenha.value) ErrorText("A senha é obrigatória")

                    Spacer(modifier = Modifier.height(10.dp))

                    // --- Botão Cadastrar ---
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { navController?.navigate("login") },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF1C704C))
                        ) {
                            Text(text = "Voltar", fontSize = 12.sp)
                        }

                        Button(
                            onClick = {
                                val loginDigitado = yourLoginCadState.value.trim()
                                val senhaDigitada = yourKeyCadState.value
                                val nomeDigitado = yourNameState.value.trim()
                                val emailDigitado = yourEmailState.value.trim()
                                val telefoneDigitado = yourPhoneState.value
                                val enderecoDigitado = yourAddressState.value.trim()

                                // Valida campos
                                erroLogin.value = loginDigitado.isEmpty()
                                erroSenha.value = senhaDigitada.isEmpty()
                                erroNome.value = nomeDigitado.isEmpty()
                                erroEmail.value = emailDigitado.isEmpty()
                                erroTelefone.value = telefoneDigitado.isEmpty()
                                erroEndereco.value = enderecoDigitado.isEmpty()

                                if (!erroLogin.value &&
                                    !erroSenha.value &&
                                    !erroNome.value &&
                                    !erroEmail.value &&
                                    !erroTelefone.value &&
                                    !erroEndereco.value
                                ) {
                                    // Cria DTO
                                    val usuario = UsuarioRequestDTO(
                                        nome = nomeDigitado,
                                        email = emailDigitado,
                                        login = loginDigitado,
                                        senha = senhaDigitada,
                                        telefone = telefoneDigitado,
                                        endereco = enderecoDigitado
                                    )

                                    // Chama API
                                    CoroutineScope(Dispatchers.IO).launch {
                                        try {
                                            val response = ApiClient.usuarioApi.criaUsuario(usuario)
                                            withContext(Dispatchers.Main) {
                                                if (response.isSuccessful) {
                                                    Toast.makeText(
                                                        context,
                                                        "Cadastro feito com sucesso!",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                    navController?.navigate("login")
                                                } else {
                                                    Toast.makeText(
                                                        context,
                                                        "Erro ao cadastrar: ${response.code()}",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                            }
                                        } catch (e: Exception) {
                                            withContext(Dispatchers.Main) {
                                                Toast.makeText(
                                                    context,
                                                    "Erro: ${e.message}",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    }
                                }
                            },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF1C704C))
                        ) {
                            Text(text = "Cadastrar", fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorText(msg: String) {
    Text(
        text = msg,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 14.sp,
        color = Color.Red,
        textAlign = TextAlign.End
    )
}

@Preview(showBackground = true)
@Composable
private fun CadastroPrev() {
    Cadastro(null)
}
