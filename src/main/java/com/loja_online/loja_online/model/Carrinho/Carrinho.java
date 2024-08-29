package com.loja_online.loja_online.model.Carrinho;

import java.util.List;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carrinho")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUsuario;
    private List<Long> idItem;
    private Integer quantidade;

    public Carrinho(Long idUsuario, Long idItem, Integer quantidade) {
        this.idUsuario = idUsuario;
        this.idItem = List.of(idItem);
        this.quantidade = quantidade;
    }
    public void addItemAoCarrinho(Long idItem, Integer quantidade) {
        this.idItem.add(idItem);
        this.quantidade = quantidade;
    }

    public boolean verificarEstoque() {
        return quantidade > 0;
    }
    public void preSave() {
        throw new UnsupportedOperationException("Voçê não pode mudar o preço do item!");
    }
    public void preRemove(long idItem) {
        this.idItem.remove(idItem);
    }
    public double calcularValorCarrinho(double valorItem) {
        return quantidade * valorItem;
    }



  
}

