package com.loja_online.loja_online.model.Usuario;

public record UsuarioRegisterDTO(String Username, String senha, UsuarioRole role) {

    public CharSequence password() {
        throw new UnsupportedOperationException("Unimplemented method 'password'");
    }
    }