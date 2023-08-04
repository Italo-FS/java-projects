# Prova de Programação Orientada a Objetos em Java

Este é um programa Java para realizar uma prova de conceitos de Programação Orientada a Objetos (POO). A prova consiste em 10 questões de múltipla escolha, onde o aluno deve escolher a alternativa correta para cada pergunta. O programa apresenta as questões, permite ao usuário responder e, em seguida, corrige e apresenta o resultado da prova.

## Como usar o programa

1. Clone o repositório ou faça o download do código-fonte.
2. Certifique-se de ter o Java instalado em seu computador.
3. Compile o programa executando o seguinte comando no terminal:

```bash
javac App.java
```

4. Execute o programa com o comando:

```bash
java App
```

5. O programa apresentará cada questão e aguardará a entrada do usuário. Digite o número da alternativa desejada (1, 2, 3 ou 4) e pressione Enter.
6. Após responder todas as questões, o programa corrigirá a prova e exibirá a nota obtida.

## Estrutura do código

O programa é dividido em três classes:

1. `App`: Esta é a classe principal do programa, contendo o método `main`, onde a prova é criada, realizada, corrigida e o resultado é apresentado. As questões da prova são criadas utilizando a classe `Questao`.

2. `Prova`: Esta classe é responsável por realizar a prova. Ela possui um array de questões, um array de respostas (armazenando a escolha do usuário) e métodos para realizar a prova, corrigi-la e apresentar o resultado.

3. `Questao`: Esta classe representa cada questão da prova. Cada objeto `Questao` é composto por um enunciado, quatro alternativas e a resposta correta.

## Limpeza da tela

O programa possui uma classe chamada `Terminal`, que é responsável por limpar a tela do console antes de apresentar cada questão. Essa funcionalidade é utilizada para melhorar a experiência do usuário ao realizar a prova, mantendo apenas a questão atual visível.

## Observações

- Certifique-se de responder todas as questões antes de finalizar a prova.
- As alternativas são numeradas de 1 a 4.
- O programa funciona apenas em consoles de sistemas operacionais Windows e Linux.

Esse programa é uma simples demonstração do conceito de Programação Orientada a Objetos em Java e pode ser estendido e aprimorado para outros fins educacionais. Sinta-se à vontade para modificar e explorar o código conforme suas necessidades. Boa prova!
