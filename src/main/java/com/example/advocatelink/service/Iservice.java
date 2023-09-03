package com.example.advocatelink.service;

import com.example.advocatelink.models.Client;

import java.util.List;

public interface Iservice <T> {
    T inclui(T item);
    T alterar(Long id,T item);
    boolean deletar(Long id);
    List<T> listar();
    T selecionar(Long id);
}
