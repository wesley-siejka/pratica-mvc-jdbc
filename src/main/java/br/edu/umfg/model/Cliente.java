package br.edu.umfg.model;

public class Cliente {
    private Integer id;
    private String nome;
    private String telefone;

    public Cliente() {}

    public Cliente(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
}