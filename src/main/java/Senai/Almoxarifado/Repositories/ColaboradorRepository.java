package Senai.Almoxarifado.Repositories;

import Senai.Almoxarifado.Entitis.ColaboradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {

    Optional<ColaboradorEntity> findByEmail(String email);
    Optional<ColaboradorEntity> findByEmailAndSenha(String email, String senha);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);
}
