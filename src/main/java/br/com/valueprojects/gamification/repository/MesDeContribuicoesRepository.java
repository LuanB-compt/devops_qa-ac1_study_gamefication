package br.com.valueprojects.gamification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.valueprojects.gamification.entity.MesDeContribuicoesEntity;

public interface MesDeContribuicoesRepository extends JpaRepository<MesDeContribuicoesEntity, Long> {

    Optional<MesDeContribuicoesEntity> findByDescricao(String descricao);
}
