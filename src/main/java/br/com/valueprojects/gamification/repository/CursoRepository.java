package br.com.valueprojects.gamification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.valueprojects.gamification.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

    Optional<CursoEntity> findByNome(String nome);
}
