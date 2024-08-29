package com.loja_online.loja_online.model.Item;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int preco;
    private Integer quantidade;
    private  LocalDate dataCadastro = LocalDate.now();
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoryEnum categoria;
}