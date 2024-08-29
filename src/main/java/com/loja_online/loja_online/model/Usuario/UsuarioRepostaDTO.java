package com.loja_online.loja_online.model.Usuario;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioRepostaDTO {

    private Long id;
    private String nome;
    private String email;
    private boolean admin;

    public static UsuarioRepostaDTO transformaEmDTO(Usuario usuario) {
        return new UsuarioRepostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRole().equals(EnumRole.ROLE_ADMIN));
    }
}