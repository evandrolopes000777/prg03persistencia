package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoService;
import br.com.ifba.curso.service.ICursoService;
import java.util.List;

public class CursoController implements ICursoController {
    
    // Instancia o Service para mandar as ações da tela para lá
    private ICursoService cursoService = new CursoService();

    @Override
    public void salvarCurso(Curso curso) throws Exception {
        cursoService.salvarCurso(curso);
    }

    @Override
    public void atualizarCurso(Curso curso) throws Exception {
        cursoService.atualizarCurso(curso);
    }

    @Override
    public void removerCurso(Curso curso) throws Exception {
        cursoService.removerCurso(curso);
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoService.listarTodos();
    }

    @Override
    public List<Curso> buscarPorNome(String nome) {
        return cursoService.buscarPorNome(nome);
    }
}