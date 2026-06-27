package br.edu.umfg.model;

import java.time.LocalDate;

public class Matricula {
    private Integer id;
    private Integer idAluno;
    private Integer idDisciplina;
    private LocalDate dataMatricula;

    public Matricula(Integer id, Integer idAluno, Integer idDisciplina, LocalDate dataMatricula) {
        this.id = id;
        this.idAluno = idAluno;
        this.idDisciplina = idDisciplina;
        this.dataMatricula = dataMatricula;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdAluno() { return idAluno; }
    public Integer getIdDisciplina() { return idDisciplina; }
    public LocalDate getDataMatricula() { return dataMatricula; }
}