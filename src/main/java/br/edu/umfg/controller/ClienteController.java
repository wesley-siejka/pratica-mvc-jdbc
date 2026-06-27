package br.edu.umfg.controller;

import br.edu.umfg.model.Cliente;
import br.edu.umfg.service.ClienteService;
import java.sql.SQLException;

public class ClienteController {
    private ClienteService service = new ClienteService();

    public void salvar(String nome, String telefone) throws SQLException {
        service.salvar(new Cliente(null, nome, telefone));
    }
}