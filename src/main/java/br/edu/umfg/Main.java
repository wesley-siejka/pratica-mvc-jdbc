package br.edu.umfg;

import br.edu.umfg.controller.*;

public class Main {
    public static void main(String[] args) {
        ClienteController cCtrl = new ClienteController();
        VeiculoController vCtrl = new VeiculoController();
        OrdemServicoController osCtrl = new OrdemServicoController();

        try {
            System.out.println("--- OFICINA MECÂNICA ---");
            cCtrl.salvar("Carlos Silva", "9999-0000");
            vCtrl.salvar("ABC-1234", "Fusca", 1980, 1);
            osCtrl.abrirOrdem(1, "Troca de pneus", 500.0, "ABERTA");
            System.out.println("O.S. registrada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}