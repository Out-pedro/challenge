package br.com.fiapchallenge.cadastro_challenge.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UsuarioRequestDTO {

    private String nome;

    @JsonProperty(required = true)
    private String email;


    private String endereco;

    private String telefone;

    private String senha;

    private String login;


}
