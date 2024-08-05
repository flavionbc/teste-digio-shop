package br.com.digio.testdigioshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class VinhoGeneric {

    private String tipoVinho;
    private BigDecimal preco;
    private String safra;

}
