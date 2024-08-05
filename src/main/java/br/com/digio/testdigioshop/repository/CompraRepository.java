package br.com.digio.testdigioshop.repository;

import br.com.digio.testdigioshop.entity.CompraEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long> {

    @Query("SELECT c FROM CompraEntity c JOIN VinhoCompraEntity vce ON c.id = vce.compra.id GROUP BY c.id ORDER BY SUM(vce.valorTotal) ASC")
    Page<CompraEntity> findAllComprasOrderedByTotalValue(Pageable pageable);

    @Query("SELECT c FROM CompraEntity c JOIN VinhoCompraEntity vce ON c.id = vce.compra.id " +
            "WHERE c.ano = :ano " +
            "GROUP BY c.id ORDER BY SUM(vce.valorTotal) DESC LIMIT 1")
    CompraEntity findMaiorCompraPorAno(@Param("ano") Integer ano);

    @Query("SELECT c.cliente.cpf, c.cliente.nome, SUM(vce.valorTotal) AS totalCompras " +
            "FROM CompraEntity c JOIN VinhoCompraEntity vce ON c.id = vce.compra.id " +
            "GROUP BY c.cliente.cpf, c.cliente.nome " +
            "ORDER BY totalCompras DESC LIMIT 3")
    List<Object[]> findTopClientesByTotalCompras();

    @Query("SELECT v.tipoVinho, SUM(vce.quantidade) AS totalQuantidade " +
            "FROM CompraEntity c " +
            "JOIN c.vinhos vce " +
            "JOIN vce.vinho v " +
            "WHERE c.cliente.cpf = :cpf " +
            "GROUP BY v.tipoVinho " +
            "ORDER BY totalQuantidade DESC")
    List<Object[]> findTiposVinhoPreferidos(@Param("cpf") String cpf);

}
