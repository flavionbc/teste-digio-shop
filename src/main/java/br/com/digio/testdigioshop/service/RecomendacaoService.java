package br.com.digio.testdigioshop.service;

import br.com.digio.testdigioshop.dto.VinhoRecomendacaoDTO;
import br.com.digio.testdigioshop.entity.VinhoEntity;
import br.com.digio.testdigioshop.repository.CompraRepository;
import br.com.digio.testdigioshop.repository.VinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecomendacaoService {

    private final CompraRepository compraRepository;
    private final VinhoRepository vinhoRepository;

    public List<VinhoRecomendacaoDTO> recomendarVinhos(String cpf) {
        List<Object[]> tiposPreferidos = compraRepository.findTiposVinhoPreferidos(cpf);
        List<String> tiposVinho = tiposPreferidos.stream()
                .map(result -> (String) result[0])
                .collect(Collectors.toList());
        List<VinhoEntity> vinhos = vinhoRepository.findVinhosPorTipo(tiposVinho);
        return vinhos.stream()
                .map(this::convertToVinhoDTO)
                .collect(Collectors.toList());
    }

    private VinhoRecomendacaoDTO convertToVinhoDTO(VinhoEntity vinhoCompraEntity) {
        VinhoRecomendacaoDTO vinhoDTO = new VinhoRecomendacaoDTO();
        vinhoDTO.setTipoVinho(vinhoCompraEntity.getTipoVinho());
        vinhoDTO.setSafra(vinhoCompraEntity.getSafra());
        vinhoDTO.setPreco(vinhoCompraEntity.getPreco());
        return vinhoDTO;
    }

}
