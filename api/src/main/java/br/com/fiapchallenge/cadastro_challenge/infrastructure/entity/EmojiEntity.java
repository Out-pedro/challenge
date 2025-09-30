package br.com.fiapchallenge.cadastro_challenge.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emoji_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmojiEntity {

    @Id
    private String id;
    private String emoji;
}
