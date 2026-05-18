package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDAO;
import br.com.ifba.curso.dao.CursoDAOImpl;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {
    
    @Autowired
    private CursoDAO cursoDAO;

    @Override
    public void salvarCurso(Curso curso) throws Exception {
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new Exception("O nome do curso não pode estar vazio!");
        }
        if (curso.getCargaHoraria() <= 0) {
            throw new Exception("A carga horária deve ser maior que zero!");
        }
        cursoDAO.salvar(curso);
    }

    @Override
    public void atualizarCurso(Curso curso) throws Exception {
        if (StringUtil.isNullOrEmpty(curso.getNome())) {
            throw new Exception("O nome do curso não pode estar vazio para editar!");
        }
        cursoDAO.atualizar(curso);
    }

    @Override
    public void removerCurso(Curso curso) throws Exception {
        cursoDAO.remover(curso);
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoDAO.listarTodos();
    }

    @Override
    public List<Curso> buscarPorNome(String nome) {
        return cursoDAO.buscarPorNome(nome);
    }
}   