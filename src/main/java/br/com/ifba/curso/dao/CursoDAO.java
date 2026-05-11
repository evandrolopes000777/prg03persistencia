package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

public interface CursoDAO {
    void salvar(Curso curso);
    void remover(Long id);
    List<Curso> listarTodos();
    List<Curso> buscarPorNome(String nomeBusca);
}