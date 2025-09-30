package br.com.fiapchallenge.cadastro_challenge.api.converter;

import br.com.fiapchallenge.cadastro_challenge.api.response.UsuarioResponseDTO;
import br.com.fiapchallenge.cadastro_challenge.infrastructure.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", source = "usuario.id")
    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "email", source = "usuario.email")
    @Mapping(target = "senha", source = "usuario.senha")
    @Mapping(target = "telefone", source = "usuario.telefone")
    @Mapping(target = "endereco", source = "usuario.endereco")
    UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity usuario);

}