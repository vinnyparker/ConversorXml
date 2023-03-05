package br.com.tabernatech.conversorxml.repository;

import br.com.tabernatech.conversorxml.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vinny
 * Started at 05/03/2023
 **/
@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
