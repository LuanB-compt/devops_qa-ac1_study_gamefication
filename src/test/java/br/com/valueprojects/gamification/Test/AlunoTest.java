package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.valueprojects.gamification.domain.Aluno;
import br.com.valueprojects.gamification.domain.Curso;

// RED - TDD
public class AlunoTest {

    // Cenário 1: Dado o aluno com mais contribuições, quando encerra o mês,
    // então o Aluno ganha um curso.
    @Test
    public void deveGanharCursoQuandoTemMaisContribuicoesNoMes() {
        // Given
        Aluno aluno = new Aluno("Ana");
        int cursosAntes = aluno.getCursosConcluidos();

        // When
        aluno.ganharCurso();

        // Then
        assertEquals(cursosAntes + 1, aluno.getCursosConcluidos());
    }

    // Cenário 4: Dado um aluno que finalizou um curso e está com a média acima
    // de 7, quando finalizar o curso, então esse aluno ganhará mais 3 cursos.
    @Test
    public void deveGanharMaisTresCursosQuandoConcluiCursoComMediaAcimaDeSete() {
        // Given
        Aluno aluno = new Aluno("Bruno");
        Curso curso = new Curso("Docker na prática");
        int cursosAntes = aluno.getCursosConcluidos();

        // When
        aluno.concluirCurso(curso, 8.5);

        // Then (o curso concluído conta 1 + bônus de 3 pela média acima de 7)
        assertEquals(cursosAntes + 4, aluno.getCursosConcluidos());
    }

    // Complementar ao cenário 4: média igual ou abaixo de 7 não concede cursos extras.
    @Test
    public void naoDeveGanharCursosExtrasQuandoMediaNaoUltrapassaSete() {
        // Given
        Aluno aluno = new Aluno("Carlos");
        Curso curso = new Curso("Java Básico");
        int cursosAntes = aluno.getCursosConcluidos();

        // When
        aluno.concluirCurso(curso, 7.0);

        // Then (apenas o curso concluído é contabilizado, sem bônus)
        assertEquals(cursosAntes + 1, aluno.getCursosConcluidos());
    }
}
