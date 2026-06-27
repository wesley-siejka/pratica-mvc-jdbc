package br.edu.umfg.service;
import br.edu.umfg.model.OrdemServico;
import br.edu.umfg.repository.OrdemServicoRepository;
import br.edu.umfg.repository.VeiculoRepository;
import java.sql.SQLException;

public class OrdemServicoService {
    private OrdemServicoRepository osRepo = new OrdemServicoRepository();
    private VeiculoRepository veiculoRepo = new VeiculoRepository();

    public void abrirOrdem(OrdemServico os) throws SQLException {
        if (os.getValor() < 0) throw new IllegalArgumentException("Valor da O.S. não pode ser negativo!");
        if (veiculoRepo.buscarPorId(os.getIdVeiculo()) == null) throw new IllegalArgumentException("Veículo não encontrado!");
        osRepo.salvar(os);
    }
}