package br.com.digio.testdigioshop.api.v1;

import br.com.digio.testdigioshop.dto.VinhoRecomendacaoDTO;
import br.com.digio.testdigioshop.service.RecomendacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/recomendacao/cliente")
@RequiredArgsConstructor
public class RecomendacaoResource {

    private final RecomendacaoService recomendacaoService;

    @GetMapping("/tipo/{cpf}")
    public List<VinhoRecomendacaoDTO> recomendarVinhos(@PathVariable String cpf) {
        return recomendacaoService.recomendarVinhos(cpf);
    }
}
