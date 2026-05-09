package logistica.services;

import logistica.models.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEntregas {
    private List<Entregador> entregadores = new ArrayList<>();
    private List<Entrega> entregas = new ArrayList<>();

    public void cadastrarEntregador(Entregador entregador) {
        entregadores.add(entregador);
        System.out.println("Entregador cadastrado: " + entregador.getNome());
    }

    public void criarEntrega(Entrega entrega) {
        entregas.add(entrega);
        System.out.println("Entrega criada com sucesso!");
    }

    public List<Entregador> listarEntregadores() {
        return entregadores;
    }

    public List<Entrega> listarEntregas() {
        return entregas;
    }

    public void atribuirEntrega(int idEntrega, int idEntregador) {
        Entrega entrega = buscarEntregaPorId(idEntrega);
        Entregador entregador = buscarEntregadorPorId(idEntregador);

        if (entrega != null && entregador != null) {
            entrega.setEntregadorAlocado(entregador);
            System.out.println("=> Entregador " + entregador.getNome() + " alocado com sucesso à entrega " + idEntrega);
        } else {
            System.out.println("Erro: Entrega ou Entregador não encontrado pela ID.");
        }
    }

    public void atualizarStatusEntrega(int idEntrega, StatusEntrega novoStatus, String obs) {
        Entrega entrega = buscarEntregaPorId(idEntrega);
        if (entrega != null) {
            // Verificação para usar a Sobrecarga (Overloading) de forma dinâmica
            if (obs == null || obs.trim().isEmpty()) {
                entrega.atualizarStatus(novoStatus); 
            } else {
                entrega.atualizarStatus(novoStatus, obs); 
            }
            System.out.println("=> Status do pedido " + idEntrega + " atualizado para: " + novoStatus);
        } else {
            System.out.println("Erro: Entrega não encontrada.");
        }
    }

    private Entrega buscarEntregaPorId(int id) {
        for (Entrega e : entregas) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    private Entregador buscarEntregadorPorId(int id) {
        for (Entregador e : entregadores) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
