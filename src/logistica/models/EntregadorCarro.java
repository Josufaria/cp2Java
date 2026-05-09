package logistica.models;

public class EntregadorCarro extends Entregador {
    private static final double TAXA_POR_KM = 2.50;
    private static final int TEMPO_POR_KM_MINUTOS = 3;

    public EntregadorCarro(int id, String nome, double capacidadeCarga) {
        super(id, nome, capacidadeCarga);
    }

    @Override
    public double calcularCustoFrete(double distanciaKm) {
        return distanciaKm * TAXA_POR_KM + 15.00; // Custo base maior que a moto e capacidade bem maior
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        // Carro pega mais trânsito e demora para estacionar
        return (int) (distanciaKm * TEMPO_POR_KM_MINUTOS) + 10;
    }
}
