package br.com.fiapchallenge.cadastro_challenge.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "usuario_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity {
    @Id
    private String id;
    private String email;
    private String nome;
    private String login;
    private String senha;
    private String telefone;
    private String endereco;
}
