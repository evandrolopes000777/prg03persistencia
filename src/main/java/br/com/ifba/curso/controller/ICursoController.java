package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

public interface ICursoController {
    void salvarCurso(Curso curso) throws Exception;
    void atualizarCurso(Curso curso) throws Exception;
    void removerCurso(Curso curso) throws Exception;
    List<Curso> listarTodos();
    List<Curso> buscarPorNome(String nome);
}