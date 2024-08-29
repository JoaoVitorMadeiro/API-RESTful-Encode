package com.loja_online.loja_online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.loja_online.loja_online.model.Carrinho.Carrinho;
import com.loja_online.loja_online.model.Carrinho.CarrinhoRepository;


@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepo;
    public void addItem(long Id, Carrinho carrinho, Integer quantidade) {
        carrinho.addItemAoCarrinho(Id, quantidade);
        carrinhoRepo.save(carrinho);
    }
    public void clearCarrinho(Long id, Carrinho carrinho) {
        carrinho.preRemove(id);
        carrinhoRepo.save(carrinho);    
    }

   

   
}