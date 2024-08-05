package br.com.digio.testdigioshop.api.v1;

import br.com.digio.testdigioshop.dto.ClienteFielDTO;
import br.com.digio.testdigioshop.dto.CompraDTO;
import br.com.digio.testdigioshop.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/compras")
public class CompraResource {

    private final CompraService compraService;

    @GetMapping
    public ResponseEntity<List<CompraDTO>> findAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(compraService.findAllComprasOrderedByTotalValue(pageable));
    }

    @GetMapping("/maior-compra/{ano}")
    public ResponseEntity<CompraDTO> getMaiorCompraPorAno(@PathVariable Integer ano) {
        CompraDTO compraDTO = compraService.getMaiorCompraPorAno(ano);
        if (compraDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compraDTO);
    }

    @GetMapping("/clientes-fieis")
    public ResponseEntity<List<ClienteFielDTO>> getClientesFieis() {
        List<ClienteFielDTO> response = compraService.getTopClientesByTotalCompras();
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

}
