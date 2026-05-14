/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.util;

public class StringUtil {
    
    // Verifica se a string é nula ou está vazia
    public static boolean isNullOrEmpty(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
}
