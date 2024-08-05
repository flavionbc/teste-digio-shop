package br.com.digio.testdigioshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "compra_vinho")
public class VinhoCompraEntity {

    @EmbeddedId
    private VinhoCompraPK id;

    @MapsId("compra")
    @ManyToOne
    @JoinColumn(name = "compra_id")
    private CompraEntity compra;

    @MapsId("vinho")
    @ManyToOne
    @JoinColumn(name = "vinho_id")
    private VinhoEntity vinho;

    private Integer quantidade;

    @Column(name = "valor_total")
    private Double valorTotal;

}
