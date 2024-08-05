package br.com.digio.testdigioshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraDTO {

    private String nomeCliente;
    private String cpfCliente;
    private Double valorTotal;
    private List<VinhoCompraDTO> vinhos;

}
