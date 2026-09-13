package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AssinaturaTest {

    // Cenário 2: Dada uma mensalidade não paga e o aluno está ativo, quando
    // encerra o mês e não é realizado o pagamento, então a assinatura do
    // aluno é cancelada.
    @Test
    public void deveCancelarAssinaturaAtivaQuandoMesEncerraSemPagamento() {
        fail("não implementado");
    }

    // Complementar ao cenário 2: assinatura permanece ativa quando o
    // pagamento é realizado antes do encerramento do mês.
    @Test
    public void deveManterAssinaturaAtivaQuandoPagamentoForRealizado() {
        fail("não implementado");
    }
}
