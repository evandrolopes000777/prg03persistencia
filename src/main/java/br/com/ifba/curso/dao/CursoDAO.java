package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

public interface CursoDAO extends GenericIDao<Curso> {
    // salvar, atualizar, remover e listarTodos vêm do GenericIDao
    List<Curso> buscarPorNome(String nomeBusca);
}