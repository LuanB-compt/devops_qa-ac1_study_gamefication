package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // BLUE - cobertura: estado inicial de um aluno recém-criado (nome, moedas
    // e plano padrão), usado como base pelos cenários 2 (assinatura/plano) e
    // futura conversão de moedas.
    @Test
    public void deveIniciarComNomeMoedasZeroEPlanoBasico() {
        // Given / When
        Aluno aluno = new Aluno("Nina");

        // Then
        assertEquals("Nina", aluno.getNome());
        assertEquals(0, aluno.getMoedas());
        assertEquals(Aluno.Plano.BASICO, aluno.getPlano());
    }

    // BLUE - cobertura: equals/hashCode usados pela apuração de vencedores em
    // MesDeContribuicoes (comparação de alunos pelo nome).
    @Test
    public void deveSerIgualAOutroAlunoComMesmoNome() {
        Aluno aluno1 = new Aluno("Otavio");
        Aluno aluno2 = new Aluno("Otavio");

        assertTrue(aluno1.equals(aluno1));
        assertTrue(aluno1.equals(aluno2));
        assertEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    public void naoDeveSerIgualANuloOuAOutroTipoOuANomeDiferente() {
        Aluno aluno = new Aluno("Paula");

        assertFalse(aluno.equals(null));
        assertFalse(aluno.equals("Paula"));
        assertNotEquals(aluno, new Aluno("Quenia"));
    }

    @Test
    public void deveTratarNomeNuloAoCompararEHashear() {
        Aluno alunoSemNome1 = new Aluno(null);
        Aluno alunoSemNome2 = new Aluno(null);
        Aluno alunoComNome = new Aluno("Rafael");

        assertTrue(alunoSemNome1.equals(alunoSemNome2));
        assertFalse(alunoSemNome1.equals(alunoComNome));
        assertEquals(0, alunoSemNome1.hashCode());
    }
}
