package br.com.valueprojects.gamification.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Acumula as {@link Contribuicao}s de um mês (equivalente ao "Jogo" do domínio
 * de referência). Atende os cenários:
 * - Cenário 1: apura quem tem mais contribuições e concede um curso ao vencedor.
 * - Cenário 3: em caso de empate, o aluno do mês é escolhido por sorteio.
 * - Cenário 4: ignora o segundo registro de contribuição do mesmo aluno na mesma rodada.
 */
public class MesDeContribuicoes {

    private String descricao;
    private List<Contribuicao> contribuicoes;

    public MesDeContribuicoes(String descricao) {
        throw new UnsupportedOperationException("não implementado");
    }

    /**
     * Cenário 4: "Dado um jogo acontecendo e um Participante válido, quando notar
     * dois ou mais resultados deste participante, então o segundo resultado deve
     * ser ignorado".
     */
    public void registrar(Contribuicao contribuicao) {
        throw new UnsupportedOperationException("não implementado");
    }

    public List<Contribuicao> getContribuicoes() {
        throw new UnsupportedOperationException("não implementado");
    }

    /**
     * Cenário 3: "Dado um empate em contribuições de alunos, quando o mês encerra,
     * então o aluno escolhido do mês será sorteado".
     */
    public Aluno apurarVencedor() {
        throw new UnsupportedOperationException("não implementado");
    }

    /**
     * Cenário 1: "Dado o aluno com mais contribuições, quando encerra o mês,
     * então o Aluno ganha um curso". Apura o vencedor e concede o curso a ele.
     */
    public Aluno encerrar() {
        throw new UnsupportedOperationException("não implementado");
    }
}
