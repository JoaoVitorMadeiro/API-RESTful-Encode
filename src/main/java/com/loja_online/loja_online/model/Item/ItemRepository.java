package com.loja_online.loja_online.model.Item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 



public interface ItemRepository extends JpaRepository<Item, Long>{

    Optional<Item> findByNome(String nome);

    
}