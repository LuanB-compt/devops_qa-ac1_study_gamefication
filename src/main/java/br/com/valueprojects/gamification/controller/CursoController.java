package br.com.valueprojects.gamification.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valueprojects.gamification.dto.AlunoResponse;
import br.com.valueprojects.gamification.dto.ConcluirCursoRequest;
import br.com.valueprojects.gamification.service.CursoService;

/**
 * Conclusão de cursos por um aluno (cenário 4).
 */
@RestController
@RequestMapping("/api/alunos/{alunoNome}/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public AlunoResponse concluirCurso(@PathVariable String alunoNome, @RequestBody ConcluirCursoRequest request) {
        return cursoService.concluirCurso(alunoNome, request.cursoNome(), request.media());
    }
}
