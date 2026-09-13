package br.com.valueprojects.gamification.domain;

/**
 * Representa um curso oferecido pela plataforma.
 * Atende o cenário 5 : "Dado um aluno que finalizou um curso e está
 * com a média acima de 7, quando finalizar o curso, então esse aluno ganhará
 * mais 3 cursos" — usado por {@link Aluno#concluirCurso(Curso, double)}.
 */
public class Curso {

    private String nome;

    public Curso(String nome) {
        throw new UnsupportedOperationException("não implementado");
    }

    public String getNome() {
        throw new UnsupportedOperationException("não implementado");
    }
}
