import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner entrada = new Scanner(System.in);

        agenda.novoContato("Nikely", "85 9 7532-1598", "15/04");
        agenda.novoContato("Carlos", "85 9 9514-8456", "03/10");
        agenda.novoContato("Caio", "85 9 7489-6532", "12/05");
        agenda.novoContato("Felipe", "85 9 7489-6532", "06/07");


        boolean stop = false;
        while (stop != true) {
            System.out.println(" ===============  Agenda  =============== ");
            agenda.atualizarPrevia();
            System.out.println("Em caso de dúvidas, digite 'ajuda'.");
            System.out.println();
            String input = entrada.nextLine();
            if (input.equals("ajuda")) {
                exibirComandos();
            } else if (input.equals("novo")) {
                System.out.print("Nome: ");
                String name = entrada.nextLine();
                System.out.print("Telefone: ");
                String phone = entrada.nextLine();
                System.out.print("Aniversário: ");
                String birthday = entrada.nextLine();
                agenda.novoContato(name, phone, birthday);
            } else if (input.equals("excluir")) {
                System.out.print("Digite o ID que deseja excluir: ");
                int id = Integer.parseInt(entrada.nextLine());
                agenda.excluirContato(id);
            } else if (input.equals("exibir")) {
                System.out.print("Digite o ID que deseja exibir: ");
                int id = Integer.parseInt(entrada.nextLine());
                agenda.exibirContato(id);

                System.out.println();
                System.out.println("Pressione enter para voltar ao menu.");
                entrada.nextLine();
            } else if (input.equals("editar")) {
                System.out.print("Digite o ID que deseja editar: ");
                int id = Integer.parseInt(entrada.nextLine());
                agenda.exibirContato(id);
                System.out.print("Qual campo deseja editar? ");
                input = entrada.nextLine();
                if (input.equals("nome") || input.equals("Nome")) {
                    String name = entrada.nextLine();
                    agenda.editarContato(id, name, null, null);
                } else if (input.equals("telefone") || input.equals("Telefone")) {
                    String phone = entrada.nextLine();
                    agenda.editarContato(id, null, phone, null);
                } else if (input.equals("aniversário") || input.equals("Aniversário") || input.equals("aniversario") || input.equals("Aniversario")) {
                    String birthday = entrada.nextLine();
                    agenda.editarContato(id, null, null, birthday);
                } else {
                    System.out.println("Campo não encontrado!");
                }
            } else {
                System.out.println("Comando não encontrado!");
            }
        }
    }
    static void exibirComandos() {
        System.out.println("novo - Adiciona um novo contato.");
        System.out.println("editar - Edita um contato.");
        System.out.println("excluir - Remove um contato.");
        System.out.println("exibir - Exibe um contato.");
    }
}
