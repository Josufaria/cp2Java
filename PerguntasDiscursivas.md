# Respostas Discursivas - CP 2

## 1. Herança
**Explique como a herança foi utilizada no seu sistema. Qual problema ela resolveu e quais classes estão envolvidas?**

A herança foi utilizada para criar uma hierarquia de entregadores. A classe-base `Entregador` contém os comportamentos comuns (ID, Nome e Capacidade de Carga). As subclasses `EntregadorMoto`, `EntregadorBicicleta` e `EntregadorCarro` herdam dela. O principal problema que isso resolve é a duplicação de atributos e falta de coesão: sem herança, teríamos múltiplas classes iguais ou uma classe infesta de `ifs`.  Isso facilita o crescimento, se for adicionado o "Drone", basta herdar de `Entregador` também.

## 2. Interfaces
**Qual interface foi criada no sistema? Por que você decidiu utilizá-la e qual vantagem ela trouxe?**

Foi criada a interface `Rastreavel`. Decidimos utilizá-la porque "ser rastreável" é um contrato comportamental e não uma definição do objeto. Com as assinaturas `obterLocalizacaoAtual` e `atualizarLocalizacao`, a entidade `Entrega` implementa-a. Vantagem: Qualquer outro elemento futuro (ex: `Caixa`) só precisaria do `implements Rastreavel` sem intervir na árvore primária de heranças.

## 3. Classe Abstrata
**Explique o papel da classe abstrata no seu sistema. Por que ela não poderia ser uma classe comum?**

A classe `Entregador` é uma Classe Abstrata para blindar a casca padrão, forçando as filhas a implementar os métodos de `calcularCustoFrete` e `calcularTempoEstimado`. Ela não poderia ser comum/concreta pois o "Entregador" puro/genérico não pode instanciar cálculos no mundo real (não podemos estimar um "frete" apenas de um entregador vazio, mas sim a partir de um motoboy ou ciclista). Impedindo instâncias arbitrárias `new Entregador()` ajudamos o compilador a nos manter seguros.
