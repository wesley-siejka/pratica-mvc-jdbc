package br.edu.umfg.controller;

import br.edu.umfg.model.OrdemServico;
import br.edu.umfg.service.OrdemServicoService;
import java.sql.SQLException;

public class OrdemServicoController {
    private OrdemServicoService service = new OrdemServicoService();

    public void abrirOrdem(Integer idVeiculo, String descricao, Double valor, String status) throws SQLException {
        service.abrirOrdem(new OrdemServico(null, idVeiculo, descricao, valor, status));
    }
}