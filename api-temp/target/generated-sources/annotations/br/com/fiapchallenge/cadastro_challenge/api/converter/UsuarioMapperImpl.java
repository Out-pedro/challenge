package br.com.fiapchallenge.cadastro_challenge.api.converter;

import br.com.fiapchallenge.cadastro_challenge.api.response.UsuarioResponseDTO;
import br.com.fiapchallenge.cadastro_challenge.infrastructure.entity.UsuarioEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-29T18:47:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Microsoft)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity usuario) {
        if ( usuario == null ) {
            return null;
        }

        String id = null;
        String nome = null;
        String email = null;
        String senha = null;
        String telefone = null;
        String endereco = null;
        String login = null;

        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        senha = usuario.getSenha();
        telefone = usuario.getTelefone();
        endereco = usuario.getEndereco();
        login = usuario.getLogin();

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO( id, nome, email, senha, login, telefone, endereco );

        return usuarioResponseDTO;
    }
}
