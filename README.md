# Sistema de Logística para Entregas (E-commerce)

Este sistema foi desenvolvido para o CP 2 da disciplina de Domain Driven Design. Ele simula o fluxo básico de operação logística utilizando os conceitos fundamentais de POO em Java.

## Estrutura do Sistema

- **Herança**: A classe `Entregador` atua como uma superclasse abstrata que fornece propriedades básicas. As classes `EntregadorMoto`, `EntregadorBicicleta` e `EntregadorCarro` herdam dela.
- **Interfaces**: A interface `Rastreavel` dita o comportamento de qualquer entidade que possa ter sua localização atualizada. `Entrega` implementa essa interface.
- **Sobrescrita de Métodos (Polimorfismo)**: Cada classe filha de `Entregador` sobrescreve os métodos abstratos `calcularCustoFrete` e `calcularTempoEstimado`.
- **Sobrecarga de Métodos**: A classe `Entrega` tem o método `atualizarStatus(Status novoStatus)` e também o sobrecarregado `atualizarStatus(Status novoStatus, String observacao)`.
- **Encapsulamento**: Os atributos das Classes são privados e acessados via getters e setters.

## Como Executar o Projeto

1. Tenha o Java instalado (JDK 8+).
2. Acesse o diretório `src`.
3. Compile as classes com o comando:
   `javac logistica/Main.java logistica/models/*.java logistica/interfaces/*.java logistica/services/*.java`
4. Execute o sistema com:
   `java logistica.Main`
5. Siga as instruções do Menu no console.
