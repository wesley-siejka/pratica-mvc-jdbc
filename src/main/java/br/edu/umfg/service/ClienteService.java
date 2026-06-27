package br.edu.umfg.service;
import br.edu.umfg.model.Cliente;
import br.edu.umfg.repository.ClienteRepository;
import java.sql.SQLException;

public class ClienteService {
    private ClienteRepository repo = new ClienteRepository();
    public void salvar(Cliente c) throws SQLException { repo.salvar(c); }
}