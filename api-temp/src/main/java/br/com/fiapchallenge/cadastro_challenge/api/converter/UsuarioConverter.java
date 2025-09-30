package br.com.fiapchallenge.cadastro_challenge.api.converter;

import br.com.fiapchallenge.cadastro_challenge.api.request.UsuarioRequestDTO;
import br.com.fiapchallenge.cadastro_challenge.infrastructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioConverter {

    public UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO usuarioDTO) {
        return UsuarioEntity.builder()
                .id(UUID.randomUUID().toString())
                .nome(usuarioDTO.getNome())
                .senha(usuarioDTO.getSenha())
                .email(usuarioDTO.getEmail())
                .login(usuarioDTO.getLogin())
                .endereco(usuarioDTO.getEndereco())
                .telefone(usuarioDTO.getTelefone())
                .build();
    }
}
