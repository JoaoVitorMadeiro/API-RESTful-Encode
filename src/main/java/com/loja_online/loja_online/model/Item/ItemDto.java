// package com.loja_online.loja_online.model.Item;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import lombok.Getter;

// @Getter
// public class ItemDto {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String nome;
//     private Integer preco;
//     private String descricao;
//     CategoryEnum categoria;
//     private Integer quantidade;

//     public ItemDto(String nome, Integer preco, String descricao, CategoryEnum categoria,  Integer quantidade) {
//         this.nome = nome;
//         this.preco = preco;
//         this.descricao = descricao;
//         this.quantidade = quantidade;
//         this.categoria = categoria;
//     }

//     public Item transformaItem() {
//         return new Item(nome, descricao, preco, quantidade, categoria);
//     }
    
// }
