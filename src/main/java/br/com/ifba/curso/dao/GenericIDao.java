/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.dao;

import java.util.List;

public interface GenericIDao<T> {
    void salvar(T obj);
    void atualizar(T obj);
    void remover(T obj);
    List<T> listarTodos();
    T buscarPorId(Long id);
}
