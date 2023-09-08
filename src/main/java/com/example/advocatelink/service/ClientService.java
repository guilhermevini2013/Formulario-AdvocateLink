package com.example.advocatelink.service;

import com.example.advocatelink.models.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService implements Iservice<Client> {
    public static List<Client> clients = new ArrayList<>();

    @Override
    public Client inclui(Client item) {
        var id = clients.stream()
                .mapToLong(Client::getId)
                .max()
                .orElse(0);
        item.setId(id + 1);
        clients.add(item);
        return item;
    }

    @Override
    public Client alterar(Long id, Client item) {
        var retorno = getclient(id);
        retorno.setNome(item.getNome());
        retorno.setEndereco(item.getEndereco());
        retorno.setContato(item.getContato());
        retorno.setCpf(item.getCpf());
        retorno.setAreaAtuacao(item.getAreaAtuacao());
        retorno.setOab(item.getOab());
        retorno.setUrlfoto(item.getUrlfoto());
        return retorno;
    }

    @Override
    public boolean deletar(Long id) {
        var retorno = getclient(id);
        clients.remove(retorno);
        return retorno != null;
    }

    @Override
    public List<Client> listar() {
        return clients;
    }

    @Override
    public Client selecionar(Long id) {
        return getclient(id);
    }

    public Client getclient(Long id) {
        var retorno = clients.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return retorno;
    }
}