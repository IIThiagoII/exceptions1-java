# 🧪 Laboratório de Prática Java: Arquitetura e Resiliência

Este repositório reúne meus exercícios de revisão, desafios e projetos práticos avulsos em Java. O objetivo principal deste laboratório é aplicar conceitos de mercado, evoluindo a maturidade do meu código a cada projeto desenvolvido.

---

## 🎮 Projeto 1: O Jogo da Velha (Três Níveis de Arquitetura)

O objetivo deste projeto foi desenvolver o clássico Jogo da Velha evoluindo o design através de três níveis diferentes de maturidade de código.

### 📌 Estrutura e Evolução do Projeto
* **📁 1. Versão Estruturada (Nível Inicial):** Centralização da lógica no método `main` com matrizes (`char[][]`) e laços de repetição. Base essencial para sentir a necessidade de refatoração.
* **📁 2. Versão Orientada a Objetos (Nível Intermediário):** Divisão em entidades com responsabilidade única (`Jogador`, `Tabuleiro` e `Jogo`), aplicando abstração, métodos encapsulados e construtores.
* **📁 3. Versão com Tratamento de Exceções (Nível Profissional):** Programação defensiva com blocos `try-catch`. Remoção de `if-else` aninhados através do lançamento da exceção customizada `JogoException` (herdando de `RuntimeException`).

### 🧠 Conhecimentos Consolidados (Jogo da Velha)
* **Manipulação de Estruturas de Dados Bidimensionais:** Aplicação prática de matrizes para renderização e validação de estados do tabuleiro.
* **Arquitetura e Clean Code:** Decomposição de software focado no Princípio de Responsabilidade Única (SRP), separando lógica visual de regras de negócio.
* **Introdução à Programação Defensiva:** Substituição de validações condicionais complexas por fluxos baseados no lançamento de exceções controladas.

---

## 🏦 Projeto 2: Sistema ATM Bancário (Tratamento Avançado de Erros e Serviços)

Um terminal de caixa eletrônico (ATM) desenvolvido para simular operações financeiras complexas (saque, depósito e transferência entre contas), com foco absoluto em resiliência de interface e integridade de dados.

### 🧠 Desafios Encontrados & Aprendizados Práticos (Superando Bugs Reais)

Durante a construção do sistema ATM, enfrentei problemas clássicos de concorrência de memória e fluxo que consolidaram meu entendimento sobre a mecânica de execução do Java:

1. **O Bug do Buffer do Scanner:** Inicialmente, o uso combinado de `nextInt()`/`nextDouble()` com `nextLine()` deixava quebras de linha (o caractere Enter) pendentes na memória. Isso fazia o menu capturar strings vazias no loop seguinte, quebrando o sistema e gerando erros ocultos de ponteiro nulo (`NullPointerException`).
  * *Solução:* Migrei toda a entrada de dados do console para `scanner.nextLine()`, aplicando `.trim()` nas Strings e fazendo o parsing manual para os tipos numéricos (`Integer.parseInt` e `Double.parseDouble`). Isso limpou o fluxo de dados definitivamente.
2. **Alinhamento de Escopo dos Blocos Try-Catch:** No início, erros em suboperações (como digitar uma conta inexistente para transferência) faziam a aplicação inteira encerrar abruptamente.
  * *Solução:* Reestruturei a arquitetura do método `main`, aplicando "escudos" de proteção em níveis. Um bloco protege as operações diárias dentro do menu, enquanto outro gerencia de forma isolada o fluxo de Login. Agora, o sistema falha de forma elegante e mantém o usuário ativo no loop.
3. **Exceções Customizadas sem Acoplamento:** Implementação de `SaldoInsuficienteException` e `ContaNao EncontradaException` estendendo `RuntimeException`. O aprendizado chave foi delegar as validações de saldo para a própria entidade (`ContaBancaria`) e as buscas de dados para a camada de gerenciamento (`BancoService`), mantendo o código limpo, legível e desacoplado.

### 🧠 Conhecimentos Consolidados (Sistema ATM)
* **Camada de Serviço (Service Pattern):** Separação clara entre a entidade de dados (`ContaBancaria`) e o gerenciador de regras de negócio (`BancoService`).
* **Estruturas de Dados de Alta Performance:** Utilização de `Map` (`HashMap`) para busca direta de chaves e simulação eficiente de repositórios/bancos de dados em memória.
* **Mecânica Interna da JVM e I/O:** Compreensão aprofundada de fluxos de entrada (`java.util.Scanner`), limpeza de buffers de memória e ciclo de vida de exceções nativas.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

* **Linguagem:** Java SE
* **IDE:** IntelliJ IDEA
* **Ambiente de Versionamento:** Git / GitHub

## 📈 Conclusão Geral do Laboratório

Dominar a sintaxe é apenas o primeiro passo. Este laboratório tem sido o divisor de águas nos meus estudos porque me força a encarar os erros, entender o comportamento do ecossistema Java (como a gerência do teclado e das exceções) e aplicar os padrões de arquitetura exigidos pelo mercado (OO, Services e Programação Defensiva).