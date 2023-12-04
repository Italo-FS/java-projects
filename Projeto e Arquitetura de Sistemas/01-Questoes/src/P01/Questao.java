package P01;

public class Questao {
  String enunciado;
  String alternativa_1;
  String alternativa_2;
  String alternativa_3;
  String alternativa_4;
  int resposta;

  public Questao(String enunciado, String alternativa_1, String alternativa_2, String alternativa_3,
      String alternativa_4, int resposta) {
    this.enunciado = enunciado;
    this.alternativa_1 = alternativa_1;
    this.alternativa_2 = alternativa_2;
    this.alternativa_3 = alternativa_3;
    this.alternativa_4 = alternativa_4;
    this.resposta = resposta;
  }

  public boolean isCorrect(int alternativa) {
    return (alternativa == this.resposta);
  }

  public void apresentarQuestao() {
    System.out.println();
    System.out.println("Questão: " + this.enunciado);
    System.out.println("1. " + this.alternativa_1);
    System.out.println("2. " + this.alternativa_2);
    System.out.println("3. " + this.alternativa_3);
    System.out.println("4. " + this.alternativa_4);
  }
}
