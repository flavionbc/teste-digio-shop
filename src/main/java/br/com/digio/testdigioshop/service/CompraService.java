package br.com.digio.testdigioshop.service;

import br.com.digio.testdigioshop.dto.ClienteFielDTO;
import br.com.digio.testdigioshop.dto.CompraDTO;
import br.com.digio.testdigioshop.dto.VinhoCompraDTO;
import br.com.digio.testdigioshop.dto.VinhoDTO;
import br.com.digio.testdigioshop.entity.CompraEntity;
import br.com.digio.testdigioshop.entity.VinhoCompraEntity;
import br.com.digio.testdigioshop.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraRepository compraRepository;

    public List<ClienteFielDTO> getTopClientesByTotalCompras() {
        List<Object[]> results = compraRepository.findTopClientesByTotalCompras();
        return results.stream()
                .map(result -> {
                    ClienteFielDTO clienteFielDTO = new ClienteFielDTO();
                    clienteFielDTO.setCpf((String) result[0]);
                    clienteFielDTO.setName((String) result[1]);
                    clienteFielDTO.setTotalValor((Double) result[2]);
                    return clienteFielDTO;
                })
                .collect(Collectors.toList());
    }

    public CompraDTO getMaiorCompraPorAno(Integer ano) {
        CompraEntity compraEntity = compraRepository.findMaiorCompraPorAno(ano);
        return compraEntity != null ? convertToDTO(compraEntity) : null;
    }

    public List<CompraDTO> findAllComprasOrderedByTotalValue(Pageable pageable) {
        Page<CompraEntity> page = compraRepository.findAllComprasOrderedByTotalValue(pageable);
        return page.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CompraDTO convertToDTO(CompraEntity compraEntity) {
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setNomeCliente(compraEntity.getCliente().getNome());
        compraDTO.setCpfCliente(compraEntity.getCliente().getCpf());
        compraDTO.setVinhos(compraEntity.getVinhos().stream()
                .map(this::convertToVinhoDTO)
                .collect(Collectors.toList()));
        compraDTO.setValorTotal(calculateTotalValue(compraEntity));
        return compraDTO;
    }

    private VinhoCompraDTO convertToVinhoDTO(VinhoCompraEntity vinhoCompraEntity) {
        VinhoCompraDTO vinhoDTO = new VinhoCompraDTO();
        vinhoDTO.setQuantidade(vinhoCompraEntity.getQuantidade());
        vinhoDTO.setAnoCompra(vinhoCompraEntity.getVinho().getAnoCompra());
        vinhoDTO.setTipoVinho(vinhoCompraEntity.getVinho().getTipoVinho());
        vinhoDTO.setSafra(vinhoCompraEntity.getVinho().getSafra());
        vinhoDTO.setPreco(vinhoCompraEntity.getVinho().getPreco());
        return vinhoDTO;
    }

    private double calculateTotalValue(CompraEntity compraEntity) {
        return compraEntity.getVinhos().stream()
                .mapToDouble(VinhoCompraEntity::getValorTotal)
                .sum();
    }
}
