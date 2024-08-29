package com.loja_online.loja_online.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_online.loja_online.model.Carrinho.Carrinho;
import com.loja_online.loja_online.model.Item.Item;
import com.loja_online.loja_online.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;
    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @Operation(summary = "record a new permission", description = "save a new book in database", responses = {
        @ApiResponse(responseCode = "200", ref = "ok"),
        @ApiResponse(responseCode = "400", ref = "badRequest"),
        @ApiResponse(responseCode = "403", ref = "permissionDenied"),
        @ApiResponse(responseCode = "404", ref = "ResourceNotFound"),
        @ApiResponse(responseCode = "409", ref = "conflict")
})

    @PostMapping
    public  ResponseEntity <Item>  addItem(@RequestBody Long id, Carrinho carrinho, Integer quantidade) {
        carrinhoService.addItem(id, carrinho, quantidade);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public void clearCarrinho(@RequestBody Long id, Carrinho carrinho){
        carrinhoService.clearCarrinho(id, carrinho);
    }
    

    
    

}
