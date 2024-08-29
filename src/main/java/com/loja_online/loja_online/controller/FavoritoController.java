package com.loja_online.loja_online.controller;

import com.loja_online.loja_online.service.FavoritoService;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/favorito")
public class FavoritoController {
    private FavoritoService favoritoService;
    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    @PostMapping
    public void addFavorito(@RequestBody Long idItem) {
        favoritoService.addFavorito(idItem);
    }
    @DeleteMapping
    public void removeFavorito(@RequestBody Long idLong){
        favoritoService.removeFavorito(idLong);
    }
}
