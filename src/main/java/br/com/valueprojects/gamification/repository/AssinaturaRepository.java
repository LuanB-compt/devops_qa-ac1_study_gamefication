package br.com.valueprojects.gamification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.valueprojects.gamification.entity.AlunoEntity;
import br.com.valueprojects.gamification.entity.AssinaturaEntity;

public interface AssinaturaRepository extends JpaRepository<AssinaturaEntity, Long> {

    Optional<AssinaturaEntity> findByAluno(AlunoEntity aluno);
}
