package br.edu.umfg.model;

import java.time.LocalDate;

public class Consulta {
    private Integer id;
    private Integer idAnimal; // Chave estrangeira ligando ao animal
    private LocalDate dataConsulta;
    private String motivo;
    private Double valor;

    public Consulta() {}

    public Consulta(Integer id, Integer idAnimal, LocalDate dataConsulta, String motivo, Double valor) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.dataConsulta = dataConsulta;
        this.motivo = motivo;
        this.valor = valor;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdAnimal() { return idAnimal; }
    public void setIdAnimal(Integer idAnimal) { this.idAnimal = idAnimal; }

    public LocalDate getDataConsulta() { return dataConsulta; }
    public void setDataConsulta(LocalDate dataConsulta) { this.dataConsulta = dataConsulta; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return "Consulta [ID=" + id + ", ID_Animal=" + idAnimal + ", Data=" + dataConsulta + ", Motivo=" + motivo + ", Valor=R$" + valor + "]";
    }
}