package com.loja_online.loja_online.service;

import com.loja_online.loja_online.model.Usuario.Usuario;
import com.loja_online.loja_online.model.Usuario.UsuarioDetails;
import com.loja_online.loja_online.model.Usuario.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizathionService implements UserDetailsService{
    
    @Autowired
    UsuarioRepository usuariorepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuariorepo.findByNome(username);
        return new UsuarioDetails(usuario);
    }


}
