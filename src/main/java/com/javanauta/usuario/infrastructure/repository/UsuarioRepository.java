package com.javanauta.usuario.infrastructure.repository;


import com.javanauta.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Script do JPA que verifica se um email já existe, se sim, retorna true
    boolean existsByEmail(String email);

    //Optional evita retorno de informações nulas, evitando erros NullpointerException
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
