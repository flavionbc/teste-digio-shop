package br.com.digio.testdigioshop.repository;

import br.com.digio.testdigioshop.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
