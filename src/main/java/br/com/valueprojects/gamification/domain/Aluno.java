package br.com.valueprojects.gamification.domain;

/**
 * Representa o aluno da plataforma de educação continuada gamificada.
 * Atende, ao menos em parte, todos os 5 cenários:
 * - Cenário 1: aluno com mais contribuições ganha um curso ao encerrar o mês.
 * - Cenário 2: aluno vinculado a uma {@link Assinatura} que pode ser cancelada.
 * - Cenário 3: aluno pode ser o escolhido do mês em caso de sorteio por empate.
 * - Cenário 4: aluno é o "participante" cujas contribuições duplicadas são ignoradas.
 * - Cenário 5: aluno que conclui um curso com média acima de 7 ganha mais 3 cursos.
 */
public class Aluno {

    public enum Plano {
        BASICO,
        PREMIUM
    }

    private String nome;
    private int cursosConcluidos;
    private int moedas;
    private Plano plano;

    public Aluno(String nome) {
        throw new UnsupportedOperationException("não implementado");
    }

    public String getNome() {
        throw new UnsupportedOperationException("não implementado");
    }

    public int getCursosConcluidos() {
        throw new UnsupportedOperationException("não implementado");
    }

    public int getMoedas() {
        throw new UnsupportedOperationException("não implementado");
    }

    public Plano getPlano() {
        throw new UnsupportedOperationException("não implementado");
    }

    /**
     * Cenário 1: "Dado o aluno com mais contribuições, quando encerra o mês,
     * então o Aluno ganha um curso".
     */
    public void ganharCurso() {
        throw new UnsupportedOperationException("não implementado");
    }

    /**
     * Cenário 5: "Dado um aluno que finalizou um curso e está com a média acima
     * de 7, quando finalizar o curso, então esse aluno ganhará mais 3 cursos".
     */
    public void concluirCurso(Curso curso, double media) {
        throw new UnsupportedOperationException("não implementado");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("não implementado");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("não implementado");
    }
}
