package br.com.fiapchallenge.cadastro_challenge.api.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class LoginRequestDTO {
    private String login;
    private String senha;
    // getters e setters
}
