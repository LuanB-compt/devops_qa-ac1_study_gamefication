package br.com.valueprojects.gamification.dto;

public record AlunoResponse(Long id, String nome, int cursosConcluidos, int moedas, String plano) {
}
