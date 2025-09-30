package br.com.fiapchallenge.cadastro_challenge.infrastructure.repository;

import br.com.fiapchallenge.cadastro_challenge.infrastructure.entity.EmojiEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmojiRepository extends MongoRepository<EmojiEntity, String> {
}