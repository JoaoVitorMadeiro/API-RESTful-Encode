package com.loja_online.loja_online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.loja_online.loja_online.model.Carrinho.Carrinho;
import com.loja_online.loja_online.model.Carrinho.CarrinhoRepository;
import com.loja_online.loja_online.model.Favorito.Favorito;
import com.loja_online.loja_online.model.Favorito.FavoritoRepository;



@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository fAvoritoRepository;
    
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public void addFavorito(@RequestBody Long idItem) {
        Favorito favorito = new Favorito();
        favorito.setIdItem(idItem);
        fAvoritoRepository.save(favorito);
        
        Carrinho carrinho = new Carrinho();
        carrinho.addItemAoCarrinho(idItem, null);
        carrinhoRepository.save(carrinho);
    }
    
    public void removeFavorito(@RequestBody Long idLong) {
        fAvoritoRepository.deleteById(idLong);
        carrinhoRepository.deleteById(idLong);
    }

}
