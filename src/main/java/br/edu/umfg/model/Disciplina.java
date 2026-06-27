package br.edu.umfg.model;
public class Disciplina {
    private Integer id;
    private String nome;
    private Integer cargaHoraria;

    public Disciplina(Integer id, String nome, Integer cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public Integer getCargaHoraria() { return cargaHoraria; }
}