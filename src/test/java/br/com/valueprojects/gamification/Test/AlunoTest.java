package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AlunoTest {

    // Cenário 1: Dado o aluno com mais contribuições, quando encerra o mês,
    // então o Aluno ganha um curso.
    @Test
    public void deveGanharCursoQuandoTemMaisContribuicoesNoMes() {
        fail("não implementado");
    }

    // Cenário 5: Dado um aluno que finalizou um curso e está com a média acima
    // de 7, quando finalizar o curso, então esse aluno ganhará mais 3 cursos.
    @Test
    public void deveGanharMaisTresCursosQuandoConcluiCursoComMediaAcimaDeSete() {
        fail("não implementado");
    }

    // Complementar ao cenário 5: média igual ou abaixo de 7 não concede cursos extras.
    @Test
    public void naoDeveGanharCursosExtrasQuandoMediaNaoUltrapassaSete() {
        fail("não implementado");
    }
}
