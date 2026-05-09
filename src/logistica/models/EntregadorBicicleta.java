package logistica.models;

public class EntregadorBicicleta extends Entregador {
    private static final double TAXA_POR_KM = 0.50;
    private static final int TEMPO_POR_KM_MINUTOS = 5;

    public EntregadorBicicleta(int id, String nome, double capacidadeCarga) {
        super(id, nome, capacidadeCarga);
    }

    @Override
    public double calcularCustoFrete(double distanciaKm) {
        return distanciaKm * TAXA_POR_KM; // Sem custo base, mais ecológico e barato
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        return (int) (distanciaKm * TEMPO_POR_KM_MINUTOS);
    }
}
