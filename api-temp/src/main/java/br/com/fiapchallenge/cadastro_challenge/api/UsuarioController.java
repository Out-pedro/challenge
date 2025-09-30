package br.com.fiapchallenge.cadastro_challenge.api;

import br.com.fiapchallenge.cadastro_challenge.api.request.LoginRequestDTO;
import br.com.fiapchallenge.cadastro_challenge.api.request.UsuarioRequestDTO;
import br.com.fiapchallenge.cadastro_challenge.api.response.UsuarioResponseDTO;
import br.com.fiapchallenge.cadastro_challenge.business.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> gravaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO response = usuarioService.gravarUsuarios(usuarioRequestDTO); // chama o método
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO loginRequest) {
        boolean ok = usuarioService.verificaLogin(loginRequest.getLogin(), loginRequest.getSenha());
        Map<String, String> resposta = new HashMap<>();
        if (ok) {
            resposta.put("message", "Login realizado com sucesso!");
            return ResponseEntity.ok(resposta);
        } else {
            resposta.put("message", "Login ou senha incorretos");
            return ResponseEntity.status(401).body(resposta);
        }
    }



}
