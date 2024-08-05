package br.com.digio.testdigioshop.repository;

import br.com.digio.testdigioshop.entity.VinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface VinhoRepository extends JpaRepository<VinhoEntity, Long>{

    @Query("SELECT v FROM VinhoEntity v " +
            "WHERE v.tipoVinho IN :tiposVinho " +
            "ORDER BY v.preco DESC")
    List<VinhoEntity> findVinhosPorTipo(@Param("tiposVinho") List<String> tiposVinho);
}
