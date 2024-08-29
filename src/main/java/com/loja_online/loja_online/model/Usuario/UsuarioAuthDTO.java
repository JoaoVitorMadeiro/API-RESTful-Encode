package com.loja_online.loja_online.model.Usuario;

public record UsuarioAuthDTO(String Username, String senha) {

    public Object password() {
        throw new UnsupportedOperationException("Unimplemented method 'password'");
    }}