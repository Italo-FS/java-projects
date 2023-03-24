public class Gato {
    public String nome;
    private float peso;
    private boolean sexo;
    private String proprietario;
    public String cor;
    private boolean Estado;

    //===============================================================================

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        Estado = estado;
    }

    //===============================================================================

    public Gato(String nome, String proprietario) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.setEstado(true);
    }


    //===============================================================================

    public void miar() {
        System.out.println("O gato " + this.nome + " Miou!");
    }

    public void dormir() {
        if (this.isEstado()) {
            this.setEstado(false);
            System.out.println("O gato " + this.nome + " dormiu.");
        } else {
            System.out.println("O gato " + this.nome + " já está dormindo.");
        }
    }

    public void acordar() {
        if (!this.isEstado()) {
            this.setEstado(true);
            System.out.println("O gato " + this.nome + " acordou.");
        } else {
            System.out.println("O gato " + this.nome + " já está acordado.");
        }
    }

    public void ApresentarDados() {
        System.out.println();
        System.out.println("=========== DADOS DO GATO ===========");
        System.out.println("nome = " + nome);
        System.out.println("peso = " + peso);
        System.out.println("sexo = " + sexo);
        System.out.println("proprietario = " + proprietario);
        System.out.println("cor = " + cor);
        System.out.println("Estado = " + Estado);
        System.out.println("=====================================");
    }
}
