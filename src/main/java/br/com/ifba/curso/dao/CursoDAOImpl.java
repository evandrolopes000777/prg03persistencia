package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursoDAOImpl implements CursoDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("prg03persistencia");

    @Override
    public void salvar(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso curso = em.find(Curso.class, id);
            if (curso != null) {
                em.remove(curso);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Curso> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Curso", Curso.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Curso> buscarPorNome(String nomeBusca) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Curso where nome like :nome", Curso.class)
                     .setParameter("nome", "%" + nomeBusca + "%")
                     .getResultList();
        } finally {
            em.close();
        }
    }
}