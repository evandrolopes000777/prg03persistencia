package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CursoDAOImpl extends GenericDao<Curso> implements CursoDAO {
    
    // salvar, remover e listarTodos estão no GenericDao
    
    @Override
    public List<Curso> buscarPorNome(String nomeBusca) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("from Curso where nome like :nome", Curso.class)
                     .setParameter("nome", "%" + nomeBusca + "%")
                     .getResultList();
        } finally {
            em.close();
        }
    }
}