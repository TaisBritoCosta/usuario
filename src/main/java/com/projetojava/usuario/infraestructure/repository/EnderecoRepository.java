package com.projetojava.usuario.infraestructure.repository;


import com.projetojava.usuario.infraestructure.entity.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
