package br.com.digio.testdigioshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteFielDTO {

    private String cpf;
    private String name;
    private Double totalValor;

}
