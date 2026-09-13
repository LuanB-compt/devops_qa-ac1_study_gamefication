package br.com.valueprojects.gamification.domain;

/**
 * Vínculo entre um {@link Aluno} e o plano de assinatura mensal.
 * Atende o cenário 2: "Dada uma mensalidade não paga e o aluno está
 * ativo, quando encerra o mês e não é realizado o pagamento, então a
 * assinatura do aluno é cancelada".
 */
public class Assinatura {

    private Aluno aluno;
    private boolean ativa;
    private boolean pagamentoRealizado;

    public Assinatura(Aluno aluno) {
        throw new UnsupportedOperationException("não implementado");
    }

    public Aluno getAluno() {
        throw new UnsupportedOperationException("não implementado");
    }

    public boolean isAtiva() {
        throw new UnsupportedOperationException("não implementado");
    }

    public void registrarPagamento() {
        throw new UnsupportedOperationException("não implementado");
    }

    /**
     * Cenário 2: encerra o mês da assinatura; se o pagamento não foi realizado
     * e a assinatura estava ativa, ela é cancelada.
     */
    public void encerrarMes() {
        throw new UnsupportedOperationException("não implementado");
    }
}
