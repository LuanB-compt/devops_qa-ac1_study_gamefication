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
        this.aluno = aluno;
        this.ativa = true;
        this.pagamentoRealizado = false;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void registrarPagamento() {
        pagamentoRealizado = true;
    }

    /**
     * Cenário 2: encerra o mês da assinatura; se o pagamento não foi realizado
     * e a assinatura estava ativa, ela é cancelada.
     */
    public void encerrarMes() {
        if (ativa && !pagamentoRealizado) {
            ativa = false;
        }
        pagamentoRealizado = false;
    }
}
