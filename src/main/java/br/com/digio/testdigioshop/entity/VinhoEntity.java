package br.com.digio.testdigioshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "vinho")
public class VinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "tipo_vinho", nullable = false)
    private String tipoVinho;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String safra;

    @Column(name = "ano_compra", nullable = false)
    private Integer anoCompra;

    @OneToMany(mappedBy = "vinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VinhoCompraEntity> compras;

}
