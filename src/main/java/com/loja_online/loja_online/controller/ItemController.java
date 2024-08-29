package com.loja_online.loja_online.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loja_online.loja_online.model.Item.Item;
import com.loja_online.loja_online.model.Item.itemDtoRecord;
import com.loja_online.loja_online.service.ItemService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    @Operation(summary = "record a new permission", description = "save a new book in database", responses = {
        @ApiResponse(responseCode = "200", ref = "ok"),
        @ApiResponse(responseCode = "400", ref = "badRequest"),
        @ApiResponse(responseCode = "403", ref = "permissionDenied"),
        @ApiResponse(responseCode = "404", ref = "ResourceNotFound"),
        @ApiResponse(responseCode = "409", ref = "conflict")
})
    @PostMapping
    public  ResponseEntity <Item>  addItem(@RequestBody itemDtoRecord dto,@RequestParam boolean isAdmin) {
      Item item = itemService.addItem(dto, isAdmin);
      return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
    @GetMapping("/nome/{nome}")
    public Item buscarPorNome(@PathVariable("nome") String nome) {
        return itemService.buscarPorNome(nome);
    }
    @GetMapping("/{id}")
    public Item buscarPorId(@PathVariable("id") Long id) {
        return itemService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Item idItem,  @RequestParam boolean isAdmin) {
        itemService.deleteItem(idItem, isAdmin);
    }
   
    
}