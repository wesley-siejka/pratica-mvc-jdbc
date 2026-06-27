package br.edu.umfg.model;

public class Veiculo {
    private Integer id;
    private String placa;
    private String modelo;
    private Integer ano;
    private Integer idCliente;

    public Veiculo() {}

    public Veiculo(Integer id, String placa, String modelo, Integer ano, Integer idCliente) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.idCliente = idCliente;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public Integer getAno() { return ano; }
    public Integer getIdCliente() { return idCliente; }
}