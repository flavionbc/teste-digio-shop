package br.com.digio.testdigioshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class VinhoCompraPK implements Serializable {

    @Column(name = "compra_id")
    private Long compra;

    @Column(name = "vinho_id")
    private Long vinho;

}