package br.com.valueprojects.gamification.dto;

import java.util.List;

public record RankingMesResponse(String descricao, List<ContribuicaoResponse> contribuicoes) {
}
