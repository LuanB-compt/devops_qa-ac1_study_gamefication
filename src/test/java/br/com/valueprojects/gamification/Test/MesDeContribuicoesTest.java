package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class MesDeContribuicoesTest {

    // Cenário 4: Dado um jogo acontecendo e um Participante válido, quando notar
    // dois ou mais resultados deste participante, então o segundo resultado
    // deve ser ignorado.
    @Test
    public void naoDeveAceitarDuasContribuicoesDoMesmoAlunoNoMesmoMes() {
        fail("não implementado");
    }

    // Cenário 1: Dado o aluno com mais contribuições, quando encerra o mês,
    // então o Aluno ganha um curso.
    @Test
    public void deveApurarAlunoComMaisContribuicoesComoVencedorDoMes() {
        fail("não implementado");
    }

    // Cenário 3: Dado um empate em contribuições de alunos, quando o mês
    // encerra, então o aluno escolhido do mês será sorteado.
    @Test
    public void deveSortearAlunoVencedorEmCasoDeEmpateDeContribuicoes() {
        fail("não implementado");
    }

    // Cenário 1: ao encerrar o mês, o aluno vencedor deve ganhar um curso.
    @Test
    public void deveConcederCursoAoAlunoVencedorAoEncerrarOMes() {
        fail("não implementado");
    }
}
