package com.loja_online.loja_online.model.Usuario;

public enum UsuarioRole {
    ADMIN(true),
    USER(false);
    
    private Boolean role;

    UsuarioRole  (Boolean role) {
        this.role = role;
    }

    public Boolean getRole() {
        return this.role;
    }
}
