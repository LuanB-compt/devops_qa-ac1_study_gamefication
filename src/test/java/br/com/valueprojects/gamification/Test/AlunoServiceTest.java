package br.com.valueprojects.gamification.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.valueprojects.gamification.domain.Aluno;
import br.com.valueprojects.gamification.dto.AlunoResponse;
import br.com.valueprojects.gamification.entity.AlunoEntity;
import br.com.valueprojects.gamification.repository.AlunoRepository;
import br.com.valueprojects.gamification.service.AlunoService;
import jakarta.persistence.EntityNotFoundException;

// Testes unitários (Mockito) da camada service - AlunoService não duplica
// regra de negócio do domínio, então aqui validamos apenas a orquestração
// com o repositório e a tradução para AlunoResponse.
@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @Test
    public void deveRetornarAlunoExistenteQuandoBuscarOuCriarEJaExiste() {
        // Given
        AlunoEntity existente = new AlunoEntity("Ana");
        when(alunoRepository.findByNome("Ana")).thenReturn(Optional.of(existente));

        // When
        AlunoEntity resultado = alunoService.buscarOuCriar("Ana");

        // Then
        assertSame(existente, resultado);
        verify(alunoRepository, never()).save(any());
    }

    @Test
    public void deveCriarNovoAlunoQuandoBuscarOuCriarENaoExiste() {
        // Given
        when(alunoRepository.findByNome("Bruno")).thenReturn(Optional.empty());
        AlunoEntity novo = new AlunoEntity("Bruno");
        when(alunoRepository.save(any(AlunoEntity.class))).thenReturn(novo);

        // When
        AlunoEntity resultado = alunoService.buscarOuCriar("Bruno");

        // Then
        assertEquals("Bruno", resultado.getNome());
        verify(alunoRepository).save(any(AlunoEntity.class));
    }

    @Test
    public void deveRetornarAlunoQuandoBuscarPorNomeExistente() {
        // Given
        AlunoEntity existente = new AlunoEntity("Carlos");
        when(alunoRepository.findByNome("Carlos")).thenReturn(Optional.of(existente));

        // When
        AlunoEntity resultado = alunoService.buscarPorNome("Carlos");

        // Then
        assertSame(existente, resultado);
    }

    @Test
    public void deveLancarExcecaoQuandoBuscarPorNomeInexistente() {
        // Given
        when(alunoRepository.findByNome("Fantasma")).thenReturn(Optional.empty());

        // When / Then
        assertThrows(EntityNotFoundException.class, () -> alunoService.buscarPorNome("Fantasma"));
    }

    @Test
    public void deveListarTodosOsAlunosDoRepositorio() {
        // Given
        List<AlunoEntity> alunos = List.of(new AlunoEntity("Duda"), new AlunoEntity("Elias"));
        when(alunoRepository.findAll()).thenReturn(alunos);

        // When
        List<AlunoEntity> resultado = alunoService.listarTodos();

        // Then
        assertEquals(2, resultado.size());
    }

    @Test
    public void deveTraduzirEntidadeParaResponseComTodosOsCampos() {
        // Given
        AlunoEntity entity = new AlunoEntity("Fabio");
        entity.setCursosConcluidos(4);
        entity.setMoedas(3);
        entity.setPlano(Aluno.Plano.PREMIUM);

        // When
        AlunoResponse response = alunoService.paraResponse(entity);

        // Then
        assertEquals("Fabio", response.nome());
        assertEquals(4, response.cursosConcluidos());
        assertEquals(3, response.moedas());
        assertEquals("PREMIUM", response.plano());
    }
}
