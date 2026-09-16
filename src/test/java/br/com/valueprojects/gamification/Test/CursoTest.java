package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.valueprojects.gamification.domain.Aluno;
import br.com.valueprojects.gamification.domain.Curso;

// RED - TDD
public class CursoTest {

    // Cenário 4: Dado um aluno que finalizou um curso e está com a média
    // acima de 7, quando finalizar o curso, então esse aluno ganhará mais 3
    // cursos.
    @Test
    public void deveIdentificarCursoConcluidoComMediaAcimaDeSete() {
        // Given
        Aluno aluno = new Aluno("Fábio");
        Curso curso = new Curso("Spring Boot Avançado");
        int cursosAntes = aluno.getCursosConcluidos();

        // When
        aluno.concluirCurso(curso, 9.0);

        // Then
        assertEquals("Spring Boot Avançado", curso.getNome());
        assertEquals(cursosAntes + 4, aluno.getCursosConcluidos());
    }
}
