package br.edu.umfg.service;
import br.edu.umfg.model.Veiculo;
import br.edu.umfg.repository.VeiculoRepository;
import java.sql.SQLException;

public class VeiculoService {
    private VeiculoRepository repo = new VeiculoRepository();
    public void salvar(Veiculo v) throws SQLException { repo.salvar(v); }
}