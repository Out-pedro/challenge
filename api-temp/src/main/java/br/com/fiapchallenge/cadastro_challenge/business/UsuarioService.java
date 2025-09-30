package br.com.fiapchallenge.cadastro_challenge.business;

import br.com.fiapchallenge.cadastro_challenge.api.converter.UsuarioConverter;
import br.com.fiapchallenge.cadastro_challenge.api.converter.UsuarioMapper;
import br.com.fiapchallenge.cadastro_challenge.api.request.UsuarioRequestDTO;
import br.com.fiapchallenge.cadastro_challenge.api.response.UsuarioResponseDTO;
import br.com.fiapchallenge.cadastro_challenge.infrastructure.entity.UsuarioEntity;
import br.com.fiapchallenge.cadastro_challenge.infrastructure.exceptions.BusinessException;
import br.com.fiapchallenge.cadastro_challenge.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final UsuarioMapper usuarioMapper;

    // Método para gravar usuário
    public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO) {
        try {
            notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");

            // Converte DTO para Entity
            UsuarioEntity usuarioEntity = usuarioConverter.paraUsuarioEntity(usuarioRequestDTO);

            // Salva no MongoDB
            usuarioEntity = usuarioRepository.save(usuarioEntity);

            // Converte Entity de volta para DTO de resposta
            return usuarioMapper.paraUsuarioResponseDTO(usuarioEntity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }

    public UsuarioResponseDTO buscaDadosUsuario(String email) {
        try {
            UsuarioEntity entity = usuarioRepository.findByEmail(email);
            notNull(entity, "Usuário não encontrado");
            return usuarioMapper.paraUsuarioResponseDTO(entity);
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar dados de usuário", e);
        }
    }

    public boolean verificaLogin(String login, String senha) {
        UsuarioEntity usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) return false;
        return usuario.getSenha().equals(senha);
    }

    @Transactional
    public void deletaDadosUsuario(String email) {
        usuarioRepository.deleteByEmail(email);
    }
}
