package br.com.valueprojects.gamification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.valueprojects.gamification.entity.AlunoEntity;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    Optional<AlunoEntity> findByNome(String nome);
}
