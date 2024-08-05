package br.com.digio.testdigioshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VinhoCompraDTO extends VinhoGeneric {

    private Integer anoCompra;
    private Integer quantidade;

}
