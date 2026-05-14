/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDao<T> implements GenericIDao<T> {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("prg03persistencia");
    private Class<T> persistedClass;

    @SuppressWarnings("unchecked")
    public GenericDao() {
        // Descobre qual é a classe (entidade) que está sendo usada no momento (ex: Curso)
        this.persistedClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void salvar(T obj) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizar(T obj) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void remover(T obj) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            // Garante que o objeto está no contexto do JPA antes de remover
            obj = em.merge(obj); 
            em.remove(obj);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> listarTodos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("from " + persistedClass.getName()).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public T buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(persistedClass, id);
        } finally {
            em.close();
        }
    }
}