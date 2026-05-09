package logistica.models;

public class EntregadorMoto extends Entregador {
    private static final double TAXA_POR_KM = 1.50;
    private static final int TEMPO_POR_KM_MINUTOS = 2;

    public EntregadorMoto(int id, String nome, double capacidadeCarga) {
        super(id, nome, capacidadeCarga);
    }

    @Override
    public double calcularCustoFrete(double distanciaKm) {
        return distanciaKm * TAXA_POR_KM + 5.00; // Custo base de 5.00
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        return (int) (distanciaKm * TEMPO_POR_KM_MINUTOS);
    }
}
