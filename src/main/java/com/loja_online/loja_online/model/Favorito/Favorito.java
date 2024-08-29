package com.loja_online.loja_online.model.Favorito;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorito")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUsuario;
    private Long idItem;
    private String nomeItem;

    public Favorito(Long idUsuario, Long idItem) {
        this.idUsuario = idUsuario;
        this.idItem = idItem;
    }
    public void addItemAoFavorito(Long idItem, String nomeItem) {
        this.idItem = idItem;
        this.nomeItem = nomeItem;
    }
    public void removeItemDoFavorito() {
        this.idItem = null;
        this.nomeItem = null;
    }

}
