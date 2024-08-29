package com.loja_online.loja_online.service;

import org.springframework.stereotype.Service;
import com.loja_online.loja_online.model.Usuario.Usuario;
import com.loja_online.loja_online.model.Usuario.UsuarioDTO;
import com.loja_online.loja_online.model.Usuario.UsuarioRepository;
import com.loja_online.loja_online.model.Usuario.EnumRole;
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(UsuarioDTO usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        // if(setEmail(usuarioDto.getEmail()) == "@gmail.com"){
        //     return null;
        // }
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());
        usuario.setRole(EnumRole.ROLE_USER);
        return usuarioRepository.save(usuario);
    }
    public Usuario salvarAdm(UsuarioDTO usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());
        usuario.setRole(EnumRole.ROLE_ADMIN);
        return usuarioRepository.save(usuario);
    }

    public void TrocarCargo(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
       if (usuario.getRole() == EnumRole.ROLE_USER){
        usuario.setRole(EnumRole.ROLE_ADMIN);
       }
       else{
            usuario.setRole(EnumRole.ROLE_USER);
       }
       usuarioRepository.save(usuario);
    }
    

}