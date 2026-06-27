package br.edu.umfg.controller;

import br.edu.umfg.model.Veiculo;
import br.edu.umfg.service.VeiculoService;
import java.sql.SQLException;

public class VeiculoController {
    private VeiculoService service = new VeiculoService();

    public void salvar(String placa, String modelo, Integer ano, Integer idCliente) throws SQLException {
        service.salvar(new Veiculo(null, placa, modelo, ano, idCliente));
    }
}