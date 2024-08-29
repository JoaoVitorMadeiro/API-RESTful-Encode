package com.loja_online.loja_online.model.Usuario;
import lombok.Getter;

@Getter
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private EnumRole role;
}
