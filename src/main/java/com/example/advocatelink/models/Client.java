package com.example.advocatelink.models;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Client {
    private long id;
    private String nome;
    private long cpf;
    private Endereco endereco;
    private Contato contato;
    private String urlfoto;
    private String oab;
    private String areaAtuacao;
}
