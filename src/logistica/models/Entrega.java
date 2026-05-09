package logistica.models;

import logistica.interfaces.Rastreavel;

public class Entrega implements Rastreavel {
    private int id;
    private String enderecoDestino;
    private double distanciaKm;
    private StatusEntrega status;
    private Entregador entregadorAlocado;
    private String observacao;

    public Entrega(int id, String enderecoDestino, double distanciaKm) {
        this.id = id;
        this.enderecoDestino = enderecoDestino;
        this.distanciaKm = distanciaKm;
        this.status = StatusEntrega.PENDENTE;
    }

    // Encapsulamento
    public int getId() {
        return id;
    }

    public void setEntregadorAlocado(Entregador entregador) {
        this.entregadorAlocado = entregador;
    }

    public Entregador getEntregadorAlocado() {
        return entregadorAlocado;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    // Sobrecarga de método (Overloading) - Requisito da avaliação
    public void atualizarStatus(StatusEntrega novoStatus) {
        this.status = novoStatus;
        if(novoStatus == StatusEntrega.ENTREGUE) {
            atualizarLocalizacao("Entregue ao cliente");
        }
    }

    public void atualizarStatus(StatusEntrega novoStatus, String observacao) {
        this.status = novoStatus;
        this.observacao = observacao;
        System.out.println("Status atualizado com observação: " + observacao);
    }

    // Implementação da Interface Rastreavel
    private String localizacaoAtual = "Aguardando Coleta";

    @Override
    public void atualizarLocalizacao(String novoLocal) {
        this.localizacaoAtual = novoLocal;
    }

    @Override
    public String obterLocalizacaoAtual() {
        return this.localizacaoAtual;
    }

    public String exibirDetalhes() {
        double custoEstimado = entregadorAlocado != null ? entregadorAlocado.calcularCustoFrete(distanciaKm) : 0;
        int tempoEstimado = entregadorAlocado != null ? entregadorAlocado.calcularTempoEstimado(distanciaKm) : 0;

        return "Entrega [ID=" + id + " | Destino: " + enderecoDestino + " | Status: " + status + "]\n" +
               " - Rastreamento Atual: " + obterLocalizacaoAtual() + "\n" +
               (entregadorAlocado != null ? 
                  (" - Entregador: " + entregadorAlocado.getNome() + " | Custo Estimado: R$" + custoEstimado + " | Tempo Estimado: " + tempoEstimado + " min") 
                  : " - Entregador: Aguardando atribuição");
    }
}
