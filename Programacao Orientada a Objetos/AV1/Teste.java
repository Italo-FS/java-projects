public class Teste {
    public static void main(String[] args) {
        Gato gato1 = new Gato("Garfield", "Jhon");
        Gato gato2 = new Gato("Frajola", "Vovó");

        gato1.miar();
        gato1.dormir();

        gato2.dormir();
        gato2.dormir();
        gato2.acordar();

        gato1.ApresentarDados();
        gato2.ApresentarDados();
    }
}
