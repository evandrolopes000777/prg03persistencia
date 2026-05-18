package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoService;
import br.com.ifba.curso.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CursoController implements ICursoController {
    
    @Autowired
    private ICursoService cursoService;

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