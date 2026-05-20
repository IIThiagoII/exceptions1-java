# 🎮 Laboratório de Prática: O Jogo da Velha (Três Níveis de Arquitetura)

Este diretório reúne meus exercícios de revisão e prática avulsa. O objetivo principal deste laboratório foi desenvolver o clássico **Jogo da Velha** evoluindo o projeto através de três níveis diferentes de arquitetura e maturidade de código.

---

## 📌 Linha do Tempo e Estrutura do Projeto

Navegue pelas pastas acima para conferir o código de cada etapa da evolução:

### 📁 1. Versão Estruturada (Nível Inicial)
* **Conceitos aplicados:** Lógica de matrizes (`char[][]`), laços de repetição (`while` / `for`), variáveis de controle e entrada de dados com `Scanner`.
* **Foco do estudo:** Centralização da lógica no método `main` e tratamento de erros primitivo utilizando estruturas condicionais `if-else` aninhadas. Foi a base para sentir a necessidade de uma arquitetura melhor.

### 📁 2. Versão Orientada a Objetos (Nível Intermediário)
* **Conceitos aplicados:** Abstração, classes, atributos, métodos, construtores e encapsulamento real de dados.
* **Foco do estudo:** Descentralizar o código do `main`. O projeto foi dividido em entidades de responsabilidade única:
    - `Jogador`: Armazena dados e símbolos.
    - `Tabuleiro`: Modifica e gerencia a matriz sem expô-la diretamente de forma vulnerável.
    - `Jogo`: Orquestra as rodadas e o fluxo através de ponteiros dinâmicos (alternando entre os objetos de jogadores).

### 📁 3. Versão com Tratamento de Exceções (Nível Profissional)
* **Conceitos aplicados:** Programação Defensiva, blocos `try-catch`, lançamento de exceções com `throw` e criação de exceções personalizadas.
* **Foco do estudo:** Blindar a aplicação. O emaranhado de `if-else` de validação foi removido do fluxo principal.
    - Criada a exceção customizada `JogoException` (herdando de `RuntimeException`) para validar limites e posições ocupadas no tabuleiro.
    - Tratamento de robustez usando `InputMismatchException` para capturar e limpar o buffer do scanner caso o usuário digite letras em vez de números, impedindo o programa de travar.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas
- **Linguagem:** Java SE
- **IDE:** IntelliJ IDEA
- **Ambiente de Versionamento:** Git / GitHub

---

## 🧠 Aprendizado Obtido
Esse laboratório foi o divisor de águas nos meus estudos em Java. 
Conseguir enxergar o mesmo problema resolvido de forma amadora (estruturada) e depois aplicando as melhores práticas exigidas pelo mercado (OO e Exceções) sedimentou conceitos de legibilidade, 
facilidade de manutenção e segurança de código que levarei para projetos reais.