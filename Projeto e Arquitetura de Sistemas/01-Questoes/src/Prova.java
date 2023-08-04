import java.util.Scanner;

public class Prova {
  Questao[] questoes = new Questao[10];
  int[] respostas = new int[10];
  float nota;

  Scanner input = new Scanner(System.in);

  public void realizarProva() {
    for (int i = 0; i < questoes.length; i++) {
      questoes[i].apresentarQuestao();
      System.out.println();
      System.out.println("Escolha uma alternativa:");
      respostas[i] = input.nextInt();
    }
    input.close();
  }
      
  public void corrigirProva() {
    this.nota = 0;
    for (int i = 0; i < questoes.length; i++) {
      this.nota += questoes[i].isCorrect(respostas[i]) ? 1 : 0;
    }
  }

	public void apresentarResultado() {
		System.out.println("Nota: " + this.nota);
	}

}
