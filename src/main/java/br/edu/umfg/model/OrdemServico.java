package br.edu.umfg.model;

public class OrdemServico {
    private Integer id;
    private Integer idVeiculo;
    private String descricao;
    private Double valor;
    private String status;

    public OrdemServico() {}

    public OrdemServico(Integer id, Integer idVeiculo, String descricao, Double valor, String status) {
        this.id = id;
        this.idVeiculo = idVeiculo;
        this.descricao = descricao;
        this.valor = valor;
        this.status = status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getIdVeiculo() { return idVeiculo; }
    public String getDescricao() { return descricao; }
    public Double getValor() { return valor; }
    public String getStatus() { return status; }
}