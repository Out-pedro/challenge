package br.com.fiapchallenge.cadastro_challenge.infrastructure.repository;

import br.com.fiapchallenge.cadastro_challenge.infrastructure.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

    UsuarioEntity findByEmail(String email);

    UsuarioEntity findByLogin(String login);


    @Transactional
    void deleteByEmail(String email);
}
