package br.edu.umfg.model;

public class Aluno {
    private Integer id;
    private String nome;
    private String email;

    public Aluno(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
}