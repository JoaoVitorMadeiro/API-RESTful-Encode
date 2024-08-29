package com.loja_online.loja_online.controller;

import com.loja_online.loja_online.model.Usuario.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_online.loja_online.service.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioRepostaDTO> SalvarUsuario(@RequestBody UsuarioDTO dto){
        Usuario usuario = usuarioService.salvar(dto);
        return new ResponseEntity<>(UsuarioRepostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
    }
    @PostMapping("/adm")
    public ResponseEntity<UsuarioRepostaDTO> SalvarAdm(@RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioService.salvarAdm(dto);
        return new ResponseEntity<>(UsuarioRepostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
}
    @SuppressWarnings("rawtypes")
    @PutMapping("/{id}")
    public ResponseEntity TrocarCargo(@PathVariable("id") Long idString) {
        usuarioService.TrocarCargo(idString);
        return new ResponseEntity(HttpStatus.OK);
    }
}