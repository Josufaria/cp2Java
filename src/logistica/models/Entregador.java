package logistica.models;

public abstract class Entregador {
    private int id;
    private String nome;
    private double capacidadeCarga;

    public Entregador(int id, String nome, double capacidadeCarga) {
        this.id = id;
        this.nome = nome;
        this.capacidadeCarga = capacidadeCarga;
    }

    // Métodos Abstratos (Polimorfismo obrigatório para as filhas)
    public abstract double calcularCustoFrete(double distanciaKm);
    public abstract int calcularTempoEstimado(double distanciaKm);

    // Encapsulamento
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String toString() {
        return "Entregador [ID=" + id + ", Nome=" + nome + ", Capacidade=" + capacidadeCarga + "kg]";
    }
}
