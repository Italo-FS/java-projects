package P01;

import java.io.IOException;
import java.util.Scanner;

public class Prova {
  Questao[] questoes = new Questao[10];
  int[] respostas = new int[10];
  float nota;

  Scanner input = new Scanner(System.in);

  public void realizarProva() throws IOException, InterruptedException {
    try {
      for (int i = 0; i < questoes.length; i++) {
        do {
          Terminal.limparConsole();
          questoes[i].apresentarQuestao();
          System.out.println();
          System.out.println("Escolha uma alternativa:");
          int answer = input.nextInt();
        } while (answer < 1 || answer > 4);
        respostas[i] = answer;
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    } finally {
      input.close();
    }
  }

  public void corrigirProva() {
    this.nota = 0;
    for (int i = 0; i < questoes.length; i++) {
      this.nota += questoes[i].isCorrect(respostas[i]) ? 1 : 0;
    }
  }

  public void apresentarResultado() throws IOException, InterruptedException {
    try {
      Terminal.limparConsole();
      System.out.println("Nota da Avaliação: " + this.nota);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public Prova(Questao[] questoes) {
    this.questoes = questoes;
  }

}
