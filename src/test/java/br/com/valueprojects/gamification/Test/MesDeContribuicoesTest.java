package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.valueprojects.gamification.domain.Aluno;
import br.com.valueprojects.gamification.domain.Contribuicao;
import br.com.valueprojects.gamification.domain.MesDeContribuicoes;

// RED - TDD
public class MesDeContribuicoesTest {

    // Cenário 1: Dado o aluno com mais contribuições, quando encerra o mês,
    // então o Aluno ganha um curso.
    @Test
    public void deveApurarAlunoComMaisContribuicoesComoVencedorDoMes() {
        // Given
        MesDeContribuicoes mes = new MesDeContribuicoes("Setembro/2026");
        Aluno alunoA = new Aluno("Helena");
        Aluno alunoB = new Aluno("Igor");

        // When (Helena contribui duas vezes, Igor apenas uma)
        mes.registrar(new Contribuicao(alunoA, 1));
        mes.registrar(new Contribuicao(alunoB, 1));
        mes.registrar(new Contribuicao(alunoA, 1));

        // Then
        assertEquals(alunoA, mes.apurarVencedor());
    }

    // Cenário 3: Dado um empate em contribuições de alunos, quando o mês
    // encerra, então o aluno escolhido do mês será sorteado.
    @Test
    public void deveSortearAlunoVencedorEmCasoDeEmpateDeContribuicoes() {
        // Given
        MesDeContribuicoes mes = new MesDeContribuicoes("Setembro/2026");
        Aluno alunoA = new Aluno("Julia");
        Aluno alunoB = new Aluno("Kevin");
        mes.registrar(new Contribuicao(alunoA, 1));
        mes.registrar(new Contribuicao(alunoB, 1));

        // When
        Aluno vencedor = mes.apurarVencedor();

        // Then (sorteio deve escolher um dos dois empatados)
        assertTrue(vencedor.equals(alunoA) || vencedor.equals(alunoB));
    }

    // Cenário 1: ao encerrar o mês, o aluno vencedor deve ganhar um curso.
    @Test
    public void deveConcederCursoAoAlunoVencedorAoEncerrarOMes() {
        // Given
        MesDeContribuicoes mes = new MesDeContribuicoes("Setembro/2026");
        Aluno alunoA = new Aluno("Larissa");
        Aluno alunoB = new Aluno("Marcos");
        mes.registrar(new Contribuicao(alunoA, 1));
        mes.registrar(new Contribuicao(alunoB, 1));
        mes.registrar(new Contribuicao(alunoA, 1));
        int cursosAntes = alunoA.getCursosConcluidos();

        // When
        Aluno vencedor = mes.encerrar();

        // Then
        assertEquals(alunoA, vencedor);
        assertEquals(cursosAntes + 1, alunoA.getCursosConcluidos());
    }
}
