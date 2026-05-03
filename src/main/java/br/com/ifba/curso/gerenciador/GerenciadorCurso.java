package br.com.ifba.curso.gerenciador;

import br.com.ifba.curso.entity.Curso;
import java.util.List; 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GerenciadorCurso {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("prg03persistencia");

    public void salvar(Curso curso) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso); 
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Erro ao salvar curso no banco: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Curso> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from Curso", Curso.class).getResultList();
        } finally {
            em.close();
        }
    }
    
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

    public void remover(Long id) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso curso = em.find(Curso.class, id);
            if (curso != null) {
                em.remove(curso);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Erro ao remover o curso: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void atualizar(Curso curso) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Erro ao atualizar os dados: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}