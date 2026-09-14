package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.valueprojects.gamification.domain.Aluno;
import br.com.valueprojects.gamification.domain.Assinatura;

// RED - TDD
public class AssinaturaTest {

    // Cenário 2: Dada uma mensalidade não paga e o aluno está ativo, quando
    // encerra o mês e não é realizado o pagamento, então a assinatura do
    // aluno é cancelada.
    @Test
    public void deveCancelarAssinaturaAtivaQuandoMesEncerraSemPagamento() {
        // Given
        Aluno aluno = new Aluno("Diana");
        Assinatura assinatura = new Assinatura(aluno);
        assertTrue(assinatura.isAtiva());

        // When (sem registrarPagamento())
        assinatura.encerrarMes();

        // Then
        assertFalse(assinatura.isAtiva());
    }

    // Complementar ao cenário 2: assinatura permanece ativa quando o
    // pagamento é realizado antes do encerramento do mês.
    @Test
    public void deveManterAssinaturaAtivaQuandoPagamentoForRealizado() {
        // Given
        Aluno aluno = new Aluno("Eduardo");
        Assinatura assinatura = new Assinatura(aluno);
        assinatura.registrarPagamento();

        // When
        assinatura.encerrarMes();

        // Then
        assertTrue(assinatura.isAtiva());
    }

    // BLUE - cobertura: getAluno() expõe o aluno vinculado à assinatura.
    @Test
    public void deveExporOAlunoVinculadoAAssinatura() {
        // Given
        Aluno aluno = new Aluno("Fernanda");
        Assinatura assinatura = new Assinatura(aluno);

        // Then
        assertEquals(aluno, assinatura.getAluno());
    }

    // BLUE - cobertura: encerrar o mês de uma assinatura já cancelada não deve
    // ter efeito (mantém inativa, sem lançar exceção).
    @Test
    public void deveManterAssinaturaJaCanceladaAoEncerrarNovamenteOMes() {
        // Given
        Aluno aluno = new Aluno("Gustavo");
        Assinatura assinatura = new Assinatura(aluno);
        assinatura.encerrarMes();
        assertFalse(assinatura.isAtiva());

        // When
        assinatura.encerrarMes();

        // Then
        assertFalse(assinatura.isAtiva());
    }
}
