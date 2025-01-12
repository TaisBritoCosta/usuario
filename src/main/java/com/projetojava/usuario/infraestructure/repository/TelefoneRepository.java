package com.projetojava.usuario.infraestructure.repository;

import com.projetojava.usuario.infraestructure.entity.Telefone;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
